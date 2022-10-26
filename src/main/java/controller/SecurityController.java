package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController 
{
	@ResponseBody
	@RequestMapping("/")
	public String test() 
	{
		System.out.println("test done..." );
		return "test done";
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
	
	@RequestMapping("/login")
	public String login() 
	{
		System.out.println("tredirecting to login page..." );
		return "login";
	}
	@RequestMapping("/logout")
	public String logout() 
	{
		System.out.println("redirecting to log-out page..." );
		return "logout";
	}
}