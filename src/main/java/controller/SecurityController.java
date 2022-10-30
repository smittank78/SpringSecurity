package controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import dao.CrudService;
import dto.ChangePassword;
import dto.signUpDto;

@Controller
public class SecurityController 
{
	@Autowired
	private CrudService service;
	
	@Autowired
	PasswordEncoder encoder;
	
	@RequestMapping("/")
	public String login() 
	{
		return "login";
	}
	@RequestMapping("/detail")
	public String detail() 
	{
		return "detail";
	}
	@RequestMapping("/process-signup")
	public String signup(@ModelAttribute("signUpDto") signUpDto dto) 
	{
		System.out.println(dto.toString());
		dto.setPassword(encoder.encode(dto.getPassword()));
		service.insertUser(dto);		
		return "login";
	}
	@RequestMapping("/deleteAcc/{username}")
	public String deleteAcc(@PathVariable("username") String username)
	{
		service.deleteUser(username);
		return "redirect:/";
	}
	@RequestMapping("/changePassword")
	public String changePassword(@ModelAttribute("changePwd") ChangePassword password)
	{
		return "reset";
	}
	@RequestMapping("/resetPassword")
	public String resetPassword(@ModelAttribute("changePwd") ChangePassword password,Principal principal)
	{
		/*
		 * change pending
		 * check new old matches or not
		 * matches then find user by username
		 * match old password with current by jdbcManager.Loaduser
		 * if matches then change password -> jdbcManager.changePassword(old,new)
		 * 
		 * if current not match then return to reset page
		 * 
		 * if password changed then home page
		 */
		System.out.println(password.toString());
		boolean matches = encoder.matches(encoder.encode(password.getNewPassword()),encoder.encode(password.getConfirmedPassword()));
		System.out.println(matches);
		if(matches)
		{
			System.out.println("new matches confirmed for " + principal.getName());
			service.resetPassword(password);
		}
		
		return "reset";
	}
	@RequestMapping("/redirectToSignUp")
	public String redirectToSignUp(@ModelAttribute("signUpDto") signUpDto dto) 
	{
		return "sign-up";
	}
	@ResponseBody
	@RequestMapping("/test1")
	public String test1() 
	{
		System.out.println("test-1 done..." );
		return "test-1";
	}
	@ResponseBody
	@RequestMapping("/test2")
	public String test2() 
	{
		System.out.println("test-2 done..." );
		return "test-2";
	}
	@RequestMapping("/home")
	public String home()
	{
//		System.out.println("user : " + ((Principal) auth.getPrincipal()).getName());
		return "home";
	}
	@ResponseBody
	@RequestMapping("/user")
	public String user() 
	{
		System.out.println("user..." );
		return "user";
	}
	@ResponseBody
	@RequestMapping("/admin")
	public String admin() 
	{
		System.out.println("tredirecting to admin page..." );
		return "admin";
	}
	@ResponseBody
	@RequestMapping("/unauthorized")
	public String unauthorized() 
	{
		System.out.println("redirecting to unauthorized page..." );
		return "unauthorized";
	}
	@RequestMapping("/logout")
	public String logout() 
	{
		System.out.println("redirecting to log-out page..." );
		return "logout";
	}
}