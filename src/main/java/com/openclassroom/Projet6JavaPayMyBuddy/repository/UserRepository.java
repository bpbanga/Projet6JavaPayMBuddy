package com.openclassroom.Projet6JavaPayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;


/**
 * interface for generic CRUD operations on an application users repository 
 */
@Repository
public interface UserRepository extends CrudRepository<UserDto, Integer> {
	
	/**
	 * method allowing user search based on a given email
	 * @param email
	 * @return
	 */
	UserDto findByEmail(String email);  

}
