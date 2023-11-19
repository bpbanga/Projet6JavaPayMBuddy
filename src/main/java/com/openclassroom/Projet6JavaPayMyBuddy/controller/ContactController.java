package com.openclassroom.Projet6JavaPayMyBuddy.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller

public class ContactController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository utilisateurDao;
	
    private static final Logger logger = LogManager.getLogger("ContactController");
    
    @GetMapping("/contact")
		public String getContact(Model model, HttpSession session) {
			logger.info("GET request to /contact");
			
			UserDto utiConnect = utilisateurDao.findByEmail( session.getAttribute("username").toString());
				
					List<UserDto> users = utiConnect.getFriends();
					 model.addAttribute("users", users);
					 model.addAttribute("user", new UserDto());
			
		return "Contact";
		}
    
    @RequestMapping(value="/contact" , method=RequestMethod.POST)
	public String addContact(HttpSession session,  @RequestParam("email") String email, 
			@ModelAttribute UserDto user) {
		logger.info("POST request form to /contact");
		try {
			
			
			
			UserDto userConnect = utilisateurDao.findByEmail( session.getAttribute("username").toString());
			//error handling
			if(email.equals(userConnect.getEmail())) {
				return "redirect:error?error=7";
			}else {
				
				UserDto userFriend = utilisateurDao.findByEmail(email);
				
				if(userFriend == null ) {
					
					return "redirect:error?error=9";
					
				}else 		   
					 userService.addFriend(userConnect, userFriend);
				}

		} catch(Exception e) {
			
		}
		
	return "redirect:contact";
		
	}

   

}
