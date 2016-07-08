package com.global.bsg.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.bsg.test.service.TestService;

@Controller
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	
	@Autowired
	private TestService testServiceImpl;
	
	@RequestMapping(value = "/test")
	public String test(Model model) {
		logger.info("TestController... test...");
		
		return "test/test";
	}
	
	@RequestMapping(value = "/testSysdate.json")
	public @ResponseBody Map<String, String> testSysdateJson(Model model) {
		logger.info("TestController... testSysdateJson...");
		
		Map<String,String> map = new HashMap<String,String>();
		try{
			Thread.sleep(3000);	//3√  ∏ÿ√„
			map.put("value", testServiceImpl.getSysdate());
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
}
