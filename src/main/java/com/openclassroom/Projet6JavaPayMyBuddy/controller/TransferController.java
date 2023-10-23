package com.openclassroom.Projet6JavaPayMyBuddy.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.openclassroom.Projet6JavaPayMyBuddy.service.UserService;

import jakarta.servlet.http.HttpSession;




@Controller
public class TransferController {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private TransactionRepository transactionDao;
	@Autowired
	private UserRepository utilisateurDao;
	
    private static final Logger logger = LogManager.getLogger("TransferController");
   
    
  	
	@GetMapping("/transfer")
	public String getTransactions(Model model, HttpSession session) {
	logger.info("GET request to /transfer");
	/*
	 * int idUticonnect = 1; Optional<UserDto> utiConnect =
	 * utilisateurDao.findById(idUticonnect);
	 */
	 UserDto utiConnect = utilisateurDao.findByEmail( session.getAttribute("username").toString());
		
			List<UserDto> amis = utiConnect.getAmis();
			 model.addAttribute("amis", amis);
			 
			 List<TransactionDto> transUtiConnect = new ArrayList<TransactionDto>();
			 for(TransactionDto transac:transactionDao.findAll()) {
				 if(transac.getEmmeteur().getIdUtilisateur() == utiConnect.getIdUtilisateur()) {
					 transUtiConnect.add(transac);
				 }
			 }
			  model.addAttribute("transFerts", transUtiConnect );
			  model.addAttribute("transaction", new TransactionDto()); 
		
		


		
		return "Transfer";
	}
	
	@RequestMapping(value="/transfer" , method=RequestMethod.POST)
	public String getTransaction(HttpSession session,  @RequestParam("connections") int idAmi, @RequestParam("montantDemande") float montantDemander,
								 @ModelAttribute TransactionDto newTransaction) {
		logger.info("POST request form to /transfer");
		try {
			
			
			
			 UserDto utiConnect = utilisateurDao.findByEmail( session.getAttribute("username").toString());
			 
						Optional<UserDto> utiDes = utilisateurDao.findById(idAmi);

						
				float comm = (float) (montantDemander * 0.05);
				if((utiConnect.getAccountBalance() > (montantDemander + comm)) || (montantDemander != 0)) {
					

					 TransactionDto trans = new TransactionDto();
					 trans.setDescription("Tickets restau");
					 trans.setEmmeteur(utiConnect);
					 trans.setDestinataire(utiDes.get());
					 trans.setMontantDemande(montantDemander);
					 trans.setMontantCommision(comm);
					 trans.setTypeTransaction("virement");
					 
					 transactionDao.save(trans);

				}
				
				   transactionService.BuildTransaction(idAmi, utiConnect.getIdUtilisateur() , montantDemander);
			
			
			
			 
				
		
				
			
		
		} catch(Exception e) {
			
		}
		
	return "redirect:transfer";
		
	}

	
    		    
    
   

	
	
}

	
	


