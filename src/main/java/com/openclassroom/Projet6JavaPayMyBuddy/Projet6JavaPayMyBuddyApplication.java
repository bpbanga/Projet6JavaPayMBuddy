package com.openclassroom.Projet6JavaPayMyBuddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.openclassroom.Projet6JavaPayMyBuddy.model.*;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.TransactionRepository;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;

@SpringBootApplication
public class Projet6JavaPayMyBuddyApplication implements CommandLineRunner{

	  @Autowired
	  UserRepository utilisateurDao;
	  
		@Autowired
		private TransactionRepository transactionDao;	
		@Autowired
		private  PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Projet6JavaPayMyBuddyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		    
		
		//   utilisateur 1
		   UserDto uti =new UserDto();
		  uti.setEmail("titi@toto.com"); uti.setName("Titi");
		  uti.setPassword(passwordEncoder.encode("password")); uti.setRib("123456");
		  uti.setAccountBalance(100);
		  
		  // utilisateur 2 
		  UserDto uti2 =new UserDto();
		  uti2.setEmail("toto@titi.com"); uti2.setName("toto");
		  uti2.setPassword(passwordEncoder.encode("password")); uti2.setRib("654321");
		  uti2.setAccountBalance(200);
		  
		  // utilisateur 3
		  UserDto uti3 =new UserDto();
		  uti3.setEmail("tutu@titi.com"); uti3.setName("tutu");
		  uti3.setPassword(passwordEncoder.encode("password")); uti3.setRib("987654");
		  uti3.setAccountBalance(50);
		  
		  // amis 
		  uti.getAmis().add(uti2); uti.getAmis().add(uti3);
		  uti2.getAmis().add(uti); uti2.getAmis().add(uti3);
		  
		  utilisateurDao.save(uti); utilisateurDao.save(uti2);
		  
		  // transactions
		  TransactionDto tran1 = new TransactionDto();
		  tran1.setDescription("Transaction 1"); tran1.setEmmeteur(uti);
		  tran1.setDestinataire(uti2); tran1.setMontantDemande(20);
		  tran1.setMontantCommision(1); tran1.setTypeTransaction("virement");
		  
		  TransactionDto tran2 = new TransactionDto(); tran2.setDescription("Transaction 2");
		  tran2.setEmmeteur(uti); tran2.setDestinataire(uti3);
		  tran2.setMontantDemande(40); tran2.setMontantCommision(2);
		  tran2.setTypeTransaction("virement");
		  
		  transactionDao.save(tran1); transactionDao.save(tran2);
		 
		  
	}

}
