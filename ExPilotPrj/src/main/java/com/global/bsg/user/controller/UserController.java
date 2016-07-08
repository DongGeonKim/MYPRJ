package com.global.bsg.user.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@RequestMapping(value = "/login")
	public String login(Model model){
		
		logger.info("UserController... login...");
		
		return "user/login";
	}
	
	@RequestMapping(value = "/loginDuplicate")
	public String loginDuplicate(Model model) {
		logger.info("UserController... loginDuplicate...");
		
		return "user/loginDuplicate";
	}
}
