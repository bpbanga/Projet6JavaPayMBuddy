package com.openclassroom.Projet6JavaPayMyBuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
/*import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;
*/import com.openclassroom.Projet6JavaPayMyBuddy.repository.TransactionRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionDao;
	@Autowired
	private UserRepository utilisateurDao;
	
	
	public List<TransactionDto> getTransactions() {
		return (List<TransactionDto>) transactionDao.findAll();
	} 
	
	/*
	 * public Transaction getTransactionInformations(int idTrans) { Transaction
	 * transInf = new Transaction(int idTransaction : String typeTransaction :float
	 * montantDemande, float montantCommision, String description, Utilisateur
	 * destinataire, Utilisateur emmeteur);
	 * 
	 * 
	 * return transInf; }
	 */
	
	public void BuildTransaction(int idDest, int idUticonnect, float montantDem) {
		float montRecu = (float) (montantDem - (montantDem * 0.05));
		List<UserDto>userDtos = (List<UserDto>) utilisateurDao.findAll();
		for (UserDto destinataire : userDtos) {
			if(idDest == destinataire.getIdUtilisateur()) {
				 destinataire.setAccountBalance(montRecu + destinataire.getAccountBalance());
				 
			}
			utilisateurDao.save(destinataire);
		}
		for (UserDto emetteur : userDtos) {
			if(idUticonnect == emetteur.getIdUtilisateur()) {
				emetteur.setAccountBalance(emetteur.getAccountBalance()  - montantDem  );
				 
			}
			utilisateurDao.save(emetteur);

		}
		
		
	}

}
