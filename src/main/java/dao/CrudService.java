package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dto.ChangePassword;
import dto.signUpDto;

@Component
public class CrudService 
{
	@Autowired
	JdbcUserDetailsManager jdbcManager;
	
/*	public void insertUser(signUpDto dto) 
	{
		String User = "insert into users values(?,?,?)";
		jdbcTemplate.update(User, dto.getUserName(),dto.getPassword(),1);

		String Role = "insert into authorities values(?,?)";
		jdbcTemplate.update(Role, dto.getUserName(),dto.getRole());
	}
*/
	public void insertUser(signUpDto dto) 
	{
		UserDetails user = User.withUsername(dto.getUserName()).password(dto.getPassword()).authorities(dto.getRole()).build();
	
		jdbcManager.createUser(user);
	}
	
	public void deleteUser(String username) 
	{
		jdbcManager.deleteUser(username);
	}
	public void resetPassword(ChangePassword password) 
	{
		jdbcManager.loadUserByUsername(null);
	}
}