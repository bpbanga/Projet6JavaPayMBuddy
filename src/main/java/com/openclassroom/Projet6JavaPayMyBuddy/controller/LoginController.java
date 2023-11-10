
package com.openclassroom.Projet6JavaPayMyBuddy.controller;
  
  
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
import com.openclassroom.Projet6JavaPayMyBuddy.service.UserService;
import jakarta.servlet.http.HttpSession;
  
  
  
/**
 * Controller for /login endpoint
 */
@Controller
public class LoginController {
	  
	
	public UserService userService;
	 
	
	/**
	 * Endpoint GET /login to return Login
	 * @param session attribute allowing to get a user connect
	 * @param model attribute who make link between the front and back end
	 * @return html page Login
	 */
	@GetMapping("/login") 
	public String login(HttpSession session, Model model ,  String error ){ 
		  
		  
		model.addAttribute("connectForm", new UserDto());
		model.addAttribute("error" ,error);
	
	  
	return "Login"; 
	  
	}
	 
	/**
	 * method allowing the login of a user to access at the application
	 * @param email value of the user connect email
	 * @param password value of the user connect password
	 * @param connectForm attribute allowing connect the back and the front end
	 * @return html page Home
	 */
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String logUser(@Validated  UserDto  user, @RequestParam("email") String email, @RequestParam("password") String password,
							@ModelAttribute UserDto connectForm ) {
		
		
		
			
	return "Home";
	}
  
  
}
 