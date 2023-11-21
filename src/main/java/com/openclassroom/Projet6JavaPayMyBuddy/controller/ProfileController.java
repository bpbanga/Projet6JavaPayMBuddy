package com.openclassroom.Projet6JavaPayMyBuddy.controller;

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
import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.TransactionRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.service.TransactionService;

import jakarta.servlet.http.HttpSession;


/**
 * Controller for /profile endpoint
 */
@Controller
public class ProfileController {
	
	
	
	@Autowired
	private TransactionService transactionService ;
	
	@Autowired
	private UserRepository userDao;
	   private static final Logger logger = LogManager.getLogger("ProfilController");
	    
	    
	  	/**
	  	 * Endpoint GET /profil to return Profile
	  	 * @param model attribute who make link between the front and back end
	  	 * @param session attribute allowing to get a user connect
	  	 * @return html page Profile
	  	 */
		@GetMapping("/profil")
		public String showProfile(Model model , HttpSession session, String error ) {
			logger.info("GET request to /profile");
			
			 UserDto utiConnect = userDao.findByEmail( session.getAttribute("username").toString());

				UserDto user = utiConnect;
				
			 
				 
				
				 model.addAttribute("user", user);
				 model.addAttribute("userAction" , new TransactionDto());
				 model.addAttribute("error", error);

		
		
		return "Profile";


		}
		
		/**
		 * method allowing to do user's transactions of your rib
		 * @param session attribute allowing to get a user connect
		 * @param amountAsked mount of transaction
		 * @param userAction attribute allowing connect front and back end
		 * @return html page Profile
		 */
		@RequestMapping(value="/profil" , method=RequestMethod.POST)
		public String rechargeAccountBalance(HttpSession session,  @RequestParam("amountAsked") float amountAsked,
				 @ModelAttribute TransactionDto userAction) {
			logger.info("POST request form to /transfer");
			try {
				
				
				
				 UserDto utiConnect = userDao.findByEmail( session.getAttribute("username").toString());
				 
							

							
					float comm = (float) (amountAsked * 0.05);
					 TransactionDto trans = new TransactionDto();
					 trans.setDescription(userAction.getTypeTransaction());
					 trans.setIssuer(utiConnect);
					 trans.setRecipient(utiConnect);
					 trans.setAmountAsked(amountAsked);
					 trans.setAmountCommission(comm);
					
					  if (("withdrawal".equals(userAction.getTypeTransaction()))){
						//error handling
							if(!(utiConnect.getAccountBalance() > (amountAsked + comm))) {
								return "redirect:error?error=5";
								
							}else if(amountAsked <= 0) {
								return "redirect:error?error=6";	
							}
							
							utiConnect.setAccountBalance(utiConnect.getAccountBalance() - (comm + amountAsked));
							
						  	transactionService.buildAccountBalance(utiConnect, trans);
	
						}
					
					  if("deposit".equals(userAction.getTypeTransaction())){
						  	if(amountAsked <= 0) {
						  		return "redirect:error?error=7";
						  	}
						  	utiConnect.setAccountBalance(utiConnect.getAccountBalance() + ( amountAsked - comm));
						  	
						  	transactionService.buildAccountBalance(utiConnect, trans);

					  	}
			
			} catch(Exception e) {
				
			}
			
		return "redirect:profil";
			
		}
}
