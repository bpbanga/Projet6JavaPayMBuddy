
  package com.openclassroom.Projet6JavaPayMyBuddy.controller;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller; 
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.GetMapping; 
  import org.springframework.web.bind.annotation.ModelAttribute; 
  import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.Projet6JavaPayMyBuddy.model.TransactionDto;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
	import
  com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;
  import com.openclassroom.Projet6JavaPayMyBuddy.service.UserService;
  
  import jakarta.servlet.http.HttpServletRequest; import
  jakarta.servlet.http.HttpSession;
  
  
  
  @Controller
  public class LoginController {
	  
	  public UserService userService;
  
  @GetMapping("/login") 
  public String login(HttpSession session, Model model ){ 
	  
	  
	  model.addAttribute("connectForm", new UserDto());

  
	  return "Login"; 
  
  }
  
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String logUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@ModelAttribute UserDto connectForm) {
	
		
		return "/home";
	}
  
  
  }
 