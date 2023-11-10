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
		    
		
		/*
		 * // user 1 UserDto uti =new UserDto(); uti.setEmail("hayley@gmail.com");
		 * uti.setName("Hayley"); uti.setPassword(passwordEncoder.encode("password"));
		 * uti.setRib("123456"); uti.setAccountBalance(100);
		 * 
		 * // user 2 UserDto uti2 =new UserDto(); uti2.setEmail("clara@gamil.com");
		 * uti2.setName("Clara"); uti2.setPassword(passwordEncoder.encode("password"));
		 * uti2.setRib("654321"); uti2.setAccountBalance(200);
		 * 
		 * // user 3 UserDto uti3 =new UserDto(); uti3.setEmail("smith@gmail.com");
		 * uti3.setName("Smith"); uti3.setPassword(passwordEncoder.encode("password"));
		 * uti3.setRib("987654"); uti3.setAccountBalance(50);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // friends uti.getFriends().add(uti2); uti.getFriends().add(uti3);
		 * uti2.getFriends().add(uti); uti2.getFriends().add(uti3);
		 * 
		 * utilisateurDao.save(uti); utilisateurDao.save(uti2);
		 * 
		 * // transactions TransactionDto tran1 = new TransactionDto(0, null, 0, 0,
		 * null, uti3, uti3); tran1.setDescription("Transaction 1");
		 * tran1.setIssuer(uti); tran1.setRecipient(uti2); tran1.setAmountAsked(20);
		 * tran1.setAmountCommission(1); tran1.setTypeTransaction("virement");
		 * 
		 * TransactionDto tran2 = new TransactionDto();
		 * tran2.setDescription("Transaction 2"); tran2.setIssuer(uti);
		 * tran2.setRecipient(uti3); tran2.setAmountAsked(40);
		 * tran2.setAmountCommission(2); tran2.setTypeTransaction("virement");
		 * 
		 * transactionDao.save(tran1); transactionDao.save(tran2);
		 */
		  
	}

}
