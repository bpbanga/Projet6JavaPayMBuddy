package com.openclassroom.Projet6JavaPayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;


/**
 * interface for generic CRUD operations on an application transaction repository 
 */
@Repository
public interface TransactionRepository extends CrudRepository<TransactionDto, Integer> {

}
