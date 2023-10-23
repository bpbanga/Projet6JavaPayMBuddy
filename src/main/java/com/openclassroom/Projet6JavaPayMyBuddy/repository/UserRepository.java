package com.openclassroom.Projet6JavaPayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Integer> {

	UserDto findByEmail(String email);  

}
