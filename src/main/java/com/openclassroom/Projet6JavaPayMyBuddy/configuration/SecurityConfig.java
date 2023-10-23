
  package com.openclassroom.Projet6JavaPayMyBuddy.configuration;
  
  
  import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean; 
  import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration. EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
  import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager; 
  import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.openclassroom.Projet6JavaPayMyBuddy.service.UserService;
  
  @Configuration
  
  @EnableWebSecurity
  
  public class SecurityConfig {
	  
	  @Autowired
	  private UserService userService;
	  
  
  @Bean
  
  
  public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		
		  http.authorizeRequests() .requestMatchers("/static/**").permitAll()
		  .requestMatchers("/login")
		  .permitAll() 
		  .anyRequest()
		  .authenticated()
		  .and() 
		  .formLogin()
		  
		  .loginPage("/login") 
		  .defaultSuccessUrl("/home")
		  .failureUrl("/login?error=true")
		  .usernameParameter("email")
          .passwordParameter("password")
		  .successHandler(this.loginSuccessHandler())
		  .permitAll() 
		  .and() 
		  .logout() 
		  .permitAll();
		  
		  return http.build();
		 
	  
		/*
		 * http .authorizeRequests((auth) -> auth
		 * .requestMatchers("/transfer").authenticated()
		 * 
		 * .requestMatchers("/home").hasAnyRole("ADMIN", " USER")
		 * .requestMatchers("/transfer").hasAnyRole(" ADMIN", " USER")
		 * .requestMatchers("/profil").hasAnyRole(" ADMIN", " USER")
		 * 
		 * .anyRequest() .authenticated() ) .httpBasic(); return http.build();
		 * 
		 */
  }
  
	/*
	 * @Bean
	 * 
	 * public InMemoryUserDetailsManager userDetailsService() {
	 * 
	 * return new InMemoryUserDetailsManager( new User("toto",
	 * passwordEncoder().encode("password"), Collections.emptyList()) );
	 */
		/*
		 * UserDetails user = User.builder() .username("toto")
		 * .password(passwordEncoder().encode("password")) .roles("USER") .build();
		 * 
		 * return new InMemoryUserDetailsManager(user);}
		 */
  
  
  
	
	  @Bean
	  
	  public BCryptPasswordEncoder  passwordEncoder() { 
		  return new  BCryptPasswordEncoder();
	  
	  
	  }

		/*
		 * @Bean public AuthenticationManager payMyBuddySecurity (HttpSecurity http ,
		 * BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception{
		 * AuthenticationManagerBuilder authentificationManagerBuilder = http
		 * .getSharedObject(AuthenticationManagerBuilder.class);
		 * authentificationManagerBuilder.userDetailsService(utilisateurService)
		 * .passwordEncoder(bCryptPasswordEncoder); return
		 * authentificationManagerBuilder.build(); }
		 */
		
		  @Bean public AuthenticationSuccessHandler loginSuccessHandler() { return new
		  CustumAuthentificationSuccessHandler(); }
		 
	  
	  
	  
  } 
	  
  


  
 