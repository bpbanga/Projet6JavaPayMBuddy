package com.openclassroom.Projet6JavaPayMyBuddy.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


/**
 * Controller for /register endpoint
 */
@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository utilisateurDao;
	@Autowired
	private  PasswordEncoder passwordEncoder;
	
	
    private static final Logger logger = LogManager.getLogger("RegisterController");

	/**
	 * Endpoint GET /register to return Register
	 * @param model attribute who make link between the front and back end
	 * @return html page Register
	 */
    @GetMapping("/register") 
	public String register(Model model ){ 
    	logger.info("GET request to /register");

		  
		  
		  model.addAttribute("registerForm", new UserDto());

	  
		  return "Register"; 
	  
	  }
	  
	/**
	 * 	method post for registering a user 
	 * @param session  attribute allowing to get a user connect
	 * @param email value of the email user's register
	 * @param password value of the password user's register
	 * @param name value of the name user's register
	 * @param rib value of the rib user's register
	 * @param registerForm attribute allowing connect the back and the front end
	 * @return html page  Login
	 */
    @RequestMapping(value="/register" , method=RequestMethod.POST)
		public String registerUSer( HttpSession session,@RequestParam("email") String email, @RequestParam("password") String password,
				@RequestParam("name") String name ,@RequestParam("rib") String rib,
				@ModelAttribute UserDto registerForm) {
			
			logger.info("POST request form to /register");

			
			UserDto newUser = new UserDto();
			
			

			newUser.setAccountBalance(0);
			newUser.setEmail(email);
			newUser.setName(name);
			newUser.setRib(rib);
			newUser.setPassword(passwordEncoder.encode(password));
			
			utilisateurDao.save(newUser);
			

		
			
			return "redirect:login";
		}
	  
	  
	  
	
	
	
	
	

}
