package com.openclassroom.Projet6JavaPayMyBuddy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
/*import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;
*/import com.openclassroom.Projet6JavaPayMyBuddy.repository.TransactionRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;

/**
 * class allowing the construction of different functionalities on transactions
 */
@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionDao;
	@Autowired
	private UserRepository userDao;
	

	
	/**
	 * method returning the list of database transactions
	 * @return list of transactions
	 */
	public List<TransactionDto> getTransactions() {
		return (List<TransactionDto>) transactionDao.findAll();
	} 
	
	
	/**
	 * method allowing the build of transaction between different users
	 * @param idRec receiver identifier
	 * @param idUticonnect  sender identifier
	 * @param amountAsked amount requested
	 */
	public void buildTransaction(int idRec, int idUticonnect, float amountAsked) {
		float amountRec = (float) (amountAsked - (amountAsked * 0.05));
		Optional<UserDto> recipient = userDao.findById(idRec);
		Optional<UserDto> issuer = userDao.findById(idRec);
		if(recipient != null || issuer != null) {
			
			recipient.get().setAccountBalance(amountRec + recipient.get().getAccountBalance());
			issuer.get().setAccountBalance(issuer.get().getAccountBalance()  - amountAsked  );
			 
			
		}
			
		userDao.save(recipient.get());
		userDao.save(issuer.get());

		
		
	}
	
	
	/**
	 * method allowing recharge or withdrawal (to another bank account) on the balance of any user account
	 * @param rib bank account information
	 * @param action type of transaction
	 * @param amountTrans amount of transaction
	 */
	public void buildAccountBalance(String rib , String action, float amountTrans) {
		float amountRec = (float) (amountTrans - (amountTrans * 0.05));
		
		UserDto user = new UserDto();
		
			if(rib == user.getRib()) {
				if(action == "deposit" || action!= "") {
					user.setAccountBalance(amountRec + user.getAccountBalance());

				}else {
					user.setAccountBalance(user.getAccountBalance() - amountRec);
				}
				
				 
			}
			userDao.save(user);

	}
		
}


