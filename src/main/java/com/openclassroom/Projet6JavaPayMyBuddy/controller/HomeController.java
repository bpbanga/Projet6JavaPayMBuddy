
package com.openclassroom.Projet6JavaPayMyBuddy.controller;
  
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import  org.springframework.ui.Model;
import  org.springframework.web.bind.annotation.GetMapping;


/**
 * Controller for /transfer endpoint
*/
@Controller 
public class HomeController {
	  
private static final Logger logger = LogManager.getLogger("HomeController");

	  
  
	/**
	 * Endpoint GET /home to return Home
	 * @param model attribute who make link between the front and back end
	 * @return  html page Home
	 */
	@GetMapping("/home") 
	public String showHome(Model model) {
		logger.info("GET request to /home");
	
		  
	  
	return "Home";
	}
  
}
  
  
  
  
  
  
 