package com.openclassroom.Projet6JavaPayMyBuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;



@Controller
public class ErrorController {
	
	@GetMapping("/error")
	public String login(HttpSession session, Model model  ){ 
		  
		  
		
	
	  
	return "Error"; 
	  
	}

}
