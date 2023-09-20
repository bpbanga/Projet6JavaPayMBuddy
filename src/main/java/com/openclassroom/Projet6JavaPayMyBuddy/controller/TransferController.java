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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassroom.Projet6JavaPayMyBuddy.model.Transaction;
import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.TransactionRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UtilisateurRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.service.TransactionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class TransferController {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private TransactionRepository transactionDao;
	@Autowired
	private UtilisateurRepository utilisateurDao;
    private static final Logger logger = LogManager.getLogger("TransferController");
    
    
  	
	@GetMapping("/transfer")
	public String getTransactions(Model model) {
		logger.info("GET request to /transfer");
		int idUticonnect = 1;
		Optional<Utilisateur> utiConnect = utilisateurDao.findById(idUticonnect);
		if(utiConnect.isPresent()) {
			List<Utilisateur> amis = utiConnect.get().getAmis();
			 model.addAttribute("amis", amis);
			 
			 List<Transaction> transUtiConnect = new ArrayList<Transaction>();
			 for(Transaction transac:transactionDao.findAll()) {
				 if(transac.getEmmeteur().getIdUtilisateur() == utiConnect.get().getIdUtilisateur()) {
					 transUtiConnect.add(transac);
				 }
			 }
			  model.addAttribute("transFerts", transUtiConnect );
			  model.addAttribute("transaction", new Transaction()); 
		}
		


		
		return "Transfer";
	}
	
	@RequestMapping(value="/transfer" , method=RequestMethod.POST)
	public String getTransaction(@RequestParam("connections") int idAmi, @RequestParam("montantDemande") float montantDemander,
								 @ModelAttribute Transaction newTransaction) {
		logger.info("POST request form to /transfer");
		try {
			
			int idUticonnect = 1;
			Optional<Utilisateur> utiConnect = utilisateurDao.findById(idUticonnect);
			Optional<Utilisateur> utiDes = utilisateurDao.findById(idAmi);

			if(utiConnect.isPresent() ||utiDes.isPresent()) {			
				float comm = (float) (montantDemander * 0.05);
				if((utiConnect.get().getSoldeCompte() > (montantDemander + comm)) || (montantDemander != 0)) {
					

					 Transaction trans = new Transaction();
					 trans.setDescription("Tickets restau");
					 trans.setEmmeteur(utiConnect.get());
					 trans.setDestinataire(utiDes.get());
					 trans.setMontantDemande(montantDemander);
					 trans.setMontantCommision(comm);
					 trans.setTypeTransaction("virement");
					 
					 transactionDao.save(trans);

				}
				
				   transactionService.BuildTransaction(idAmi, idUticonnect , montantDemander);
			}
			
			
			 
				
		
				
			
		
		} catch(Exception e) {
			
		}
		
		return "redirect:transfer";
		
	}

	
    		    
    
    

	
	
}

	
	


