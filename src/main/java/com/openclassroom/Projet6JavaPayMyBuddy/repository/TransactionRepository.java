package com.openclassroom.Projet6JavaPayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionDto, Integer> {

}
