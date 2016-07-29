
package com.taqnihome.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.taqnihome.domain.User;
import com.taqnihome.service.UserDataService;


@Controller
@ControllerAdvice
public class HomeController {

	@Autowired
	private UserDataService userDataService;

	@RequestMapping("/")
	public ModelAndView Home() {
		
		

	return new ModelAndView("thankyou");

	}
	
	
	

	@RequestMapping(value = "signup")
	@ResponseBody
	public String saveData(@RequestBody User user) {
		try{
		userDataService.userSignup(user);
		}
		catch(Exception e ){
			System.out.println("Exception in signup"+ e.getMessage());
		}
		return null;

	
	}
	
	

	@RequestMapping(value = "login")
	@ResponseBody
	public String login(@RequestBody User user) {
		try{
		userDataService.userLogin(user.getPassword(), user.getMacAddress());
		return "success";
		}
		catch(Exception e ){
			System.out.println("Exception in signup"+ e.getMessage());
		}
		return "failure";

	
	}
	

	@RequestMapping(value = "search")
	@ResponseBody
	public String checkMacAddress(@RequestBody String macAddress) {
		try{
		User user = userDataService.userAvailable(macAddress);
		if(user!=null){
			return user.getUserName();
		}
		
		return "success";
		}
		catch(Exception e ){
			System.out.println("Exception in signup"+ e.getMessage());
			return "failure";
		}
	

	
	}
	
	
	
	


}
