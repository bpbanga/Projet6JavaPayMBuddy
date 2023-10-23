package com.openclassroom.Projet6JavaPayMyBuddy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openclassroom.Projet6JavaPayMyBuddy.model.UserDto;
import com.openclassroom.Projet6JavaPayMyBuddy.repository.UserRepository;

@Service
public  class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserDto user = userRepository.findByEmail(email);	
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
		return new User(user.getEmail(), user.getPassword(), getGrantedAuthorities("USER"));
		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
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