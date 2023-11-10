package com.openclassroom.Projet6JavaPayMyBuddy.configuration;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustumAuthentificationSuccessHandler implements AuthenticationSuccessHandler {
	
	/**
	 * method allowing authentication success and create request session
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String userName = authentication.getName();
		request.getSession().setAttribute("username", userName);
		response.sendRedirect("/home");
		
}
	
}
