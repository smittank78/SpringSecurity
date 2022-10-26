package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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
/*		auth.inMemoryAuthentication()
		.withUser("smit")
		.password("{bcrypt}$2a$10$Mgbjoewiu3YwE2yBhVVCj.d6jCVDEwhFiFNXSqdYCL1tGkZ0zobGC")  //+encoder.encode("smit123").toString())
		.roles("admin")
		.and()
		.withUser("mit")
		.password("{bcrypt}$2a$10$oEDHrLS8m5d6Z1qviFb1mu/Bi/.e2ksEudnbH3mtTcT0c2D6hKcJC")
		.roles("user");
*/
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
		.antMatchers("/test1").authenticated()
		.antMatchers("/test2").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/process-login")
		.and().logout()
		.and()
		.httpBasic();
		
		//http.csrf().disable();
	}
	
}