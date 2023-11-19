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
/**
 * class allowing the construction of different functionalities on users
 */
@Service
public  class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository utilisateurDao;

	/**
	 * method allowing locates the user based on the email
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserDto user = utilisateurDao.findByEmail(email);	
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
		return new User(user.getEmail(), user.getPassword(), getGrantedAuthorities("USER"));
		
	}
	
	
	/**
     * method allowing to give authorities for different users
	 * @param role type of autority for user
	 * @return
	 */
	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}


	/**
	 * method to add a user to another's friends list
	 * @param userConnect user who wants add user
	 * @param userFriend  user who will be added for user's friends list
	 */
	public void addFriend(UserDto userConnect,UserDto userFriend) {
		if ( !userConnect.getFriends().contains(userFriend)) {
			userConnect.getFriends().add(userFriend);
			utilisateurDao.save(userConnect);
		}
		
	
	}


	
	
	
	

}
