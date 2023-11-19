
  package com.openclassroom.Projet6JavaPayMyBuddy.configuration;
  
  

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration. EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

  
  @Configuration
  
  @EnableWebSecurity
  
  public class SecurityConfig {
	  
	  /**
	   * 
	   * @param http  value of session 
	   * @return 
	   * @throws Exception
	   */
	  @Bean
	  	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		
		  http.authorizeRequests()
		  .requestMatchers("/login","/register", "/css/**")
		  .permitAll() 
		  .anyRequest()
		  .authenticated() 
		  .and() 
		  .formLogin()
		  
		  .loginPage("/login") 
//		  .defaultSuccessUrl("/home")
		  .failureUrl("/login?error=true")
		  .usernameParameter("email")
          .passwordParameter("password")
		  .successHandler(this.loginSuccessHandler())
		  .permitAll() 
		  .and() 
		  .logout()
		  .logoutSuccessHandler(this.logoutSuccessHandler())
		  .logoutUrl("/logout")
		  .invalidateHttpSession(true)
		  .deleteCookies("JSESSIONID") ;
		  
		  return http.build();
		 
	
  }
  
	  
  
  
	
	  @Bean
	  public BCryptPasswordEncoder  passwordEncoder() { 
		  return new  BCryptPasswordEncoder();
	  }

		
		
	  @Bean public AuthenticationSuccessHandler loginSuccessHandler() {
		  return new CustumAuthentificationSuccessHandler();
		  }
	  
	  
	  @Bean
	  public LogoutSuccessHandler logoutSuccessHandler() {
	      return new CustumLogoutSuccessHandler();
	  }
		 
	  
	  
	  
  } 
	  
  


  
 