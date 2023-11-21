package com.openclassroom.Projet6JavaPayMyBuddy.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
 * Controller for /transfer endpoint
 */
@Controller
public class TransferController {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private TransactionRepository transactionDao;
	@Autowired
	private UserRepository userDao;
	
    private static final Logger logger = LogManager.getLogger("TransferController");
   
    
  	/**
  	 * Endpoint GET /tranfer to return Transfer
  	 * @param model attribute who make link between the front and back end
  	 * @param session attribute allowing to get a user connect
  	 * @return html page of transfer
  	 */
	@GetMapping("/transfer")
	public String getTransactions(Model model, HttpSession session ,String error, @RequestParam(defaultValue = "0") int page  ) {
	logger.info("GET request to /transfer");
   

	 UserDto utiConnect = userDao.findByEmail( session.getAttribute("username").toString());
		
			List<UserDto> friends = utiConnect.getFriends();
			 model.addAttribute("friends", friends);
			 
			 List<TransactionDto> transUtiConnect = (List<TransactionDto>) transactionDao.findByIssuer(utiConnect);
			 
			 if (!transUtiConnect.isEmpty()) {
				 				
					 int index = page * 3;
					 List<TransactionDto> transAffiche = showTrans( index , transUtiConnect);
					 
					 
					 model.addAttribute("transFerts", transAffiche );
					 model.addAttribute("transFertsAll", transUtiConnect );
					 model.addAttribute("currentPage", page);
					 
				 
			 }
			 int nbPage = (int) Math.ceil(transUtiConnect.size() / 3.0 );
			 model.addAttribute("nbPage", nbPage);
			 
			  model.addAttribute("transaction", new TransactionDto());
			  //model.addAttribute("error", error);
			  


		
		return "Transfer";
	}
	
	public List<TransactionDto> showTrans( int index, List<TransactionDto> transList){
		List<TransactionDto> listAffiche = new ArrayList<TransactionDto>() ;
		int indexEnd = index + 3;
		if(indexEnd > transList.size() ) {
			indexEnd = transList.size();
		}
		listAffiche = transList.subList(index, indexEnd);
		
		return listAffiche;
		
	}
	
	
	/**
	 * post method allowing transaction of users
	 * @param session attribute allowing to get a user connect
	 * @param idFriend reference of the user who receive the amount
	 * @param amountAsked value of amount asked
	 * @param newTransaction attribute of the transaction
	 * @return html page of transfer
	 */
	@RequestMapping(value="/transfer" , method=RequestMethod.POST)
	public String getTransaction(HttpSession session,  @RequestParam("connections") int idFriend, @RequestParam("amountAsked") float amountAsked,
								 @ModelAttribute TransactionDto newTransaction, String error ) {
		logger.info("POST request form to /transfer");
		try {
			
			
			
			 UserDto utiConnect = userDao.findByEmail( session.getAttribute("username").toString());
			 if (idFriend == -1) {
					
					return "redirect:error?error=3";
				}
						Optional<UserDto> utiRec = userDao.findById(idFriend);

						
				float comm = (float) (amountAsked * 0.05);
				//error handling
				if(!(utiConnect.getAccountBalance() > (amountAsked + comm))) {
					
					return "redirect:/error?error=1";
					
						
				}else if (amountAsked <= 0) {
					
					return "redirect:/error?error=2";

				} 
				
				else {
					

					 TransactionDto trans = new TransactionDto();
					 trans.setDescription("Transfert");
					 trans.setIssuer(utiConnect);
					 trans.setRecipient(utiRec.get());
					 trans.setAmountAsked(amountAsked);
					 trans.setAmountCommission(comm);
					 trans.setTypeTransaction("virement");
					 
					 
					try { 
						transactionService.buildTransaction(idFriend, utiConnect.getIdUser() , amountAsked , trans);
					
					
					} catch (Exception e) {
						return "redirect:/error?error=10";
						
					}


				}
				
			
		
		} catch(Exception e) {
			
		}
		
	return "redirect:transfer";
		
	}	
	
}

	
	


