package com.openclassroom.Projet6JavaPayMyBuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	public List<Utilisateur> getUtilisateurs() {
		return (List<Utilisateur>) utilisateurRepository.findAll();
	}
	
	
	
	/*
	 * public boolean verifUtilisateur(Utilisateur user) { boolean verif = false;
	 * 
	 * List<Utilisateur> utilisateurs =UtilisateurService.getUtilisateurs() ;
	 * 
	 * for (utilisateurs utilisateur : utilisateurs) { if (utilisateur.getEmail ==
	 * user.getEmail() && utilisateur.getPassword == user.getPassword()) { verif =
	 * true; }
	 * 
	 * }
	 * 
	 * return verif; }
	 */

}
