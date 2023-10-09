package com.openclassroom.Projet6JavaPayMyBuddy.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.openclassroom.Projet6JavaPayMyBuddy.model.Transaction;
import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UtilisateurRepository;
@Controller
public class ProfileController {
	
	


	@Autowired
		private UtilisateurRepository utilisateurDao;
	    private static final Logger logger = LogManager.getLogger("ProfilController");
	    
	    
	  	
		@GetMapping("/profil")
		public String showProfile(Model model) {
			logger.info("GET request to /profile");
			int idUticonnect = 1;
			java.util.Optional<Utilisateur> userPofileId = utilisateurDao.findById(idUticonnect);
		if(userPofileId.isPresent()) {
				Optional<Utilisateur> user = userPofileId;
				
			 
				 
				
				 model.addAttribute("user", user);

		}
		
		return "Profile";


		}
}
