package com.openclassroom.Projet6JavaPayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

	public Utilisateur findByEmail(String email);

}
