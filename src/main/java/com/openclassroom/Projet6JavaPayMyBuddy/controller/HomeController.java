
package com.openclassroom.Projet6JavaPayMyBuddy.controller;
  
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import  org.springframework.ui.Model;
import  org.springframework.web.bind.annotation.GetMapping;


  
  @Controller 
  public class HomeController {
	  
	    private static final Logger logger = LogManager.getLogger("HomeController");

	  
  
  @GetMapping("/home") 
  public String showHome(Model model) {
		logger.info("GET request to /home");

	  
  
  return "Home";
  }
 
  
  
  
  
  
  }
  
  
  
  
  
  
 