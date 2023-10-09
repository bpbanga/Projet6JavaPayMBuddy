
  package com.openclassroom.Projet6JavaPayMyBuddy.controller;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller; 
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.GetMapping; 
  import org.springframework.web.bind.annotation.ModelAttribute; 
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur;
	import
  com.openclassroom.Projet6JavaPayMyBuddy.repository.UtilisateurRepository;
  import com.openclassroom.Projet6JavaPayMyBuddy.service.UtilisateurService;
  
  import jakarta.servlet.http.HttpServletRequest; import
  jakarta.servlet.http.HttpSession;
  
  
  
  @Controller
  public class ConnexionController {
  
  @GetMapping("/login") 
  public String login(HttpServletRequest request){ 
	  HttpSession session = request.getSession(); // Store data in the session
  session.setAttribute("email", "toto");
  
  session.setAttribute("password", "password"); 
  
  return "Login"; 
  
  }
  
  
  }
 