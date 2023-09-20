package com.openclassroom.Projet6JavaPayMyBuddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassroom.Projet6JavaPayMyBuddy.model.*;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.TransactionRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UtilisateurRepository;

@SpringBootApplication
public class Projet6JavaPayMyBuddyApplication implements CommandLineRunner{

	  @Autowired
	  UtilisateurRepository utilisateurDao;
	  
		@Autowired
		private TransactionRepository transactionDao;	  
	
	public static void main(String[] args) {
		SpringApplication.run(Projet6JavaPayMyBuddyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		    
		  // utilisateur 1
		  Utilisateur uti =new Utilisateur();
		  uti.setEmail("titi@toto.com");
		  uti.setNom("Titi");
		  uti.setPassword("password");
		  uti.setRib("123456");
		  uti.setSoldeCompte(100);
				  
		  // utilisateur 2
		  Utilisateur uti2 =new Utilisateur();
		  uti2.setEmail("toto@titi.com");
		  uti2.setNom("toto");
		  uti2.setPassword("password");
		  uti2.setRib("654321");
		  uti2.setSoldeCompte(200);

		  // utilisateur 3		  
		  Utilisateur uti3 =new Utilisateur();
		  uti3.setEmail("tutu@titi.com");
		  uti3.setNom("tutu");
		  uti3.setPassword("password");
		  uti3.setRib("987654");
		  uti3.setSoldeCompte(50);		  
		  
		  // amis
		  uti.getAmis().add(uti2);
		  uti.getAmis().add(uti3);
		  uti2.getAmis().add(uti);
		  uti2.getAmis().add(uti3);

		  utilisateurDao.save(uti);
		  utilisateurDao.save(uti2);
		  
		  // transactions
		  Transaction tran1 = new Transaction();
		  tran1.setDescription("Transaction 1");
		  tran1.setEmmeteur(uti);
		  tran1.setDestinataire(uti2);
		  tran1.setMontantDemande(20);
		  tran1.setMontantCommision(1);
		  tran1.setTypeTransaction("virement");

		  Transaction tran2 = new Transaction();
		  tran2.setDescription("Transaction 2");
		  tran2.setEmmeteur(uti);
		  tran2.setDestinataire(uti3);
		  tran2.setMontantDemande(40);
		  tran2.setMontantCommision(2);
		  tran2.setTypeTransaction("virement");
		  
			/*
			 * Transaction tran3 = new Transaction(); tran2.setDescription("Transaction 3");
			 * tran2.setEmmeteur(uti); tran2.setDestinataire(uti);
			 * tran2.setMontantDemande(60); tran2.setMontantCommision(3);
			 * tran2.setTypeTransaction("virement");
			 */
		  
		  transactionDao.save(tran1);
		  transactionDao.save(tran2);
			/*
			 * transactionDao.save(tran3);
			 */
		  
	}

}
