package com.openclassroom.Projet6JavaPayMyBuddy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;


/**
 * interface for generic CRUD operations on an application transaction repository 
 */
@Repository
public interface TransactionRepository extends CrudRepository<TransactionDto, Integer> {

	List<TransactionDto> findByIssuer(UserDto issuer);
	
}
