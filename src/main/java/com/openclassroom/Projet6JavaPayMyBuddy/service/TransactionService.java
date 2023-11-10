package com.openclassroom.Projet6JavaPayMyBuddy.service;

import java.util.List;

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
		List<UserDto>userDtos = (List<UserDto>) userDao.findAll();
		for (UserDto recipient : userDtos) {
			if(idRec == recipient.getIdUser()) {
				recipient.setAccountBalance(amountRec + recipient.getAccountBalance());
				 
			}
			userDao.save(recipient);
		}
		for (UserDto issuer : userDtos) {
			if(idUticonnect == issuer.getIdUser()) {
				issuer.setAccountBalance(issuer.getAccountBalance()  - amountAsked  );
				 
			}
			userDao.save(issuer);

		}
		
	}
	
	
	/**
	 * method allowing recharge or withdrawal (to another bank account) on the balance of any user account
	 * @param rib bank account information
	 * @param action type of transaction
	 * @param amountTrans amount of transaction
	 */
	public void buildAccountBalance(String rib , String action, float amountTrans) {
		float amountRec = (float) (amountTrans - (amountTrans * 0.05));
		List<UserDto>userDtos = (List<UserDto>) userDao.findAll();
		for (UserDto recipient : userDtos) {
			if(rib == recipient.getRib()) {
				if(action == "deposit" || action!= "") {
					recipient.setAccountBalance(amountRec + recipient.getAccountBalance());

				}else {
					recipient.setAccountBalance(recipient.getAccountBalance() - amountRec);
				}
				
				 
			}
			userDao.save(recipient);

		}
		
	}

}
