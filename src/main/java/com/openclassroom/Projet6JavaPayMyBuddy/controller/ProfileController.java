package com.openclassroom.Projet6JavaPayMyBuddy.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class ProfileController {
	
	


	@Autowired
		private UserRepository utilisateurDao;
	    private static final Logger logger = LogManager.getLogger("ProfilController");
	    
	    
	  	
		@GetMapping("/profil")
		public String showProfile(Model model , HttpSession session) {
			logger.info("GET request to /profile");
			
			 UserDto utiConnect = utilisateurDao.findByEmail( session.getAttribute("username").toString());

			int idUticonnect = 2;
			java.util.Optional<UserDto> userPofileId = utilisateurDao.findById(idUticonnect);
		if(userPofileId.isPresent()) {
				UserDto user = utiConnect;
				
			 
				 
				
				 model.addAttribute("user", user);

		}
		
		return "Profile";


		}
}
