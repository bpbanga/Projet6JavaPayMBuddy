
  package com.openclassroom.Projet6JavaPayMyBuddy.configuration;
  
  
  import java.util.Collections;

import org.springframework.context.annotation.Bean; 
  import org.springframework.context.annotation.Configuration; 
  import org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration. EnableWebSecurity;
  import org.springframework.security.core.userdetails.User;
  import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager; 
  import org.springframework.security.web.SecurityFilterChain;
  
  @Configuration
  
  @EnableWebSecurity
  
  public class SecurityConfig {
  
  @Bean
  
  
  public SecurityFilterChain payMyBuddySecurity (HttpSecurity http) throws Exception{
	  return http.authorizeRequests()
			  .requestMatchers("/transfer").authenticated()
			  .anyRequest().permitAll()
			  .and()
			  .formLogin()
			  .and()
			  .build();		
	  
	  /*
		 * http .authorizeRequests((auth) -> auth
		 * .requestMatchers("/transfer").authenticated()
		 * 
		 * .requestMatchers("/home").hasAnyRole("ADMIN", " USER")
		 * .requestMatchers("/connexion").hasAnyRole(" ADMIN", " USER")
		 * .requestMatchers("/login").hasAnyRole(" ADMIN", " USER")
		 * 
		 * .anyRequest() .authenticated() ) .httpBasic(); return http.build();
		 */
	  
  }
  
  @Bean
  
  public InMemoryUserDetailsManager userDetailsService() {
	  
	  return new InMemoryUserDetailsManager(
			  new User("toto", passwordEncoder().encode("password"), Collections.emptyList())
			  );
		/*
		 * UserDetails user = User.builder() .username("toto")
		 * .password(passwordEncoder().encode("password")) .roles("USER") .build();
		 * 
		 * return new InMemoryUserDetailsManager(user);
		 */
  }
  
	
	  @Bean
	  
	  public PasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder();
	  
	  
	  }
	 
  
	  
 }
	  
  
	  
  


  
 