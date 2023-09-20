package com.openclassroom.Projet6JavaPayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.Projet6JavaPayMyBuddy.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
