package com.ex.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static Logger log = Logger.getLogger(UserLoginSuccessHandler.class);
	
	/**
	 * 인증성공 후 프로세스
	 */
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		log.info("UserLoginSuccessHandler... onAuthenticationSuccess...");
		/*log.info(auth.getName());
		log.info(auth.getAuthorities().toString());
		log.info(auth.getDetails().toString());
		log.info(auth.getPrincipal().toString());
		for (GrantedAuthority a : auth.getAuthorities()) {
			log.info(a.getAuthority());
		}

		UserDetails u = (UserDetails) auth.getPrincipal();

		log.info(String.valueOf(u.isAccountNonExpired()));
		log.info(String.valueOf(u.isAccountNonLocked()));
		log.info(String.valueOf(u.isCredentialsNonExpired()));
		log.info(String.valueOf(u.isEnabled()));*/
		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
