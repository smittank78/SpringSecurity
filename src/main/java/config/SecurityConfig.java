package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
	
		/*
		 * 3 ways to create user
		 * 1.
		 * auth.inMemoryAuthentication()
		.	withUser("smit")
		.	password("{bcrypt}$2a$10$Mgbjoewiu3YwE2yBhVVCj.d6jCVDEwhFiFNXSqdYCL1tGkZ0zobGC")  //+encoder.encode("smit123").toString())
			.roles("admin")
			.and()
			.withUser("mit")
			.password("{bcrypt}$2a$10$oEDHrLS8m5d6Z1qviFb1mu/Bi/.e2ksEudnbH3mtTcT0c2D6hKcJC")
			.roles("user");
		 * 2. using constructor
		 * ArrayList<GrantedAuthority> arrayList = new ArrayList<>();
		   
		   GrantedAuthority authority = new SimpleGrantedAuthority("role");
		   arrayList.add(authority);
		
		   User user = new User("user", "password", arrayList);
		 * 
		 * 3. using built method
		 * UserDetails user = User.withUsername("").password(null).roles(null).build();
		 */
		
		/*
		 * 1.on server
		 * 2.in db
		 */
		/*
		 * userDetailManager -> createUser() , update , delete , ...
		 * userDetailService -> loadUser()
		 * 
		 * create user on server
		 * 
		 * inMemoryUserDetailManager -> userDetailManager and userDetailService
		 * 
		 * UserDetails user = User.withUsername("").password(null).roles(null).build();

			InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();	
			detailsManager.createUser(user);	
			auth.userDetailsService(detailsManager);
		 */
		
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder);
		
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
		.antMatchers("/test1","/test2").authenticated()
		.antMatchers("/user").hasAuthority("user")
		.antMatchers("/admin").hasAuthority("admin")
		.anyRequest().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/unauthorized")
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/process-login")
		.and().logout()
		.and()
		.httpBasic();
		
		//http.csrf().disable();
	}
}