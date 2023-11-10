package com.openclassroom.Projet6JavaPayMyBuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
import com.openclassroom.Projet6JavaPayMyBuddy.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class LogOffController {
	
	
	public UserService userService;
	 
	
	/**
	 * Endpoint GET /login to return Login
	 * @param session attribute allowing to get a user connect
	 * @param model attribute who make link between the front and back end
	 * @return html page Login
	 */
	@GetMapping("/logout") 
	public String logout(HttpSession session, Model model ){ 
		  
		  
		model.addAttribute("logOutForm", new UserDto());
	
	  
	return "Logout"; 
	  
	}
	 
	/**
	 * method allowing the login of a user to access at the application
	 * @param email value of the user connect email
	 * @param password value of the user connect password
	 * @param connectForm attribute allowing connect the back and the front end
	 * @return html page Home
	 */
	@RequestMapping(value="/logout" , method=RequestMethod.POST)
	public String logoutUser( @ModelAttribute UserDto logOutForm) {
		
			
	return "Logout";
	}

}
