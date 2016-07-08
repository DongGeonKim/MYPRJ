package com.mh.dw.main.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger logger = LogManager.getLogger(MainController.class);
	
	@RequestMapping(value = "/")
	public String root(Model model) {
		
		logger.info("MainController... root...");
		
		return "main";
	}
	
}
