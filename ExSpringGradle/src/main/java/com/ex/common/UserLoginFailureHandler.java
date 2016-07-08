package com.ex.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class UserLoginFailureHandler implements AuthenticationFailureHandler {
	
	private static Logger log = Logger.getLogger(UserLoginFailureHandler.class);
	
	/**
	 * 인증실패 후 프로세스
	 */
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		log.info("UserLoginFailHandler... onAuthenticationFailure...");
		/*log.info(exception.getLocalizedMessage());
		log.info(exception.getMessage());
		for (StackTraceElement s : exception.getStackTrace()) {
			log.info(s.getClassName());
			log.info(s.getFileName());
			log.info(s.getMethodName());
			log.info(s.getLineNumber() + "");
			log.info(s.isNativeMethod() + "");
		}*/
		request.setAttribute("errMsg", exception.getMessage());
		request.getRequestDispatcher("/WEB-INF/views/loginFail.jsp").forward(request, response);
	}

}
