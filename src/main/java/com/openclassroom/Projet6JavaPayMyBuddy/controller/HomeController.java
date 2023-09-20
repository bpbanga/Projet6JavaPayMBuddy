
  package com.openclassroom.Projet6JavaPayMyBuddy.controller;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; import
  org.springframework.ui.Model; import
  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UtilisateurRepository;
  
  
  @Controller 
  public class HomeController {
	  @Autowired
	  UtilisateurRepository utilisateurDao;
  
  @GetMapping("/home") 
  public String showHome(Model model) {
	  model.addAttribute("utiList", utilisateurDao.findAll());
	  model.addAttribute("utilisateur" , new Utilisateur());
	  model.addAttribute("testAttribute", "mon attribut");
  
  return "Home";
  }
  
  @PostMapping("/home")
  public String getHome(@ModelAttribute  Utilisateur newUtilisateur) {
	  
	 
	  
	  return "redirect:home" ;
  }
  
  
  
  
  
  }
  
  
  
  
  
  
 