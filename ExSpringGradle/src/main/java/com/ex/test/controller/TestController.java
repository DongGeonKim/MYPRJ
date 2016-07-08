package com.ex.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.test.service.TestService;

@Controller
public class TestController {
	
	private static Logger log = Logger.getLogger(TestController.class);
	
	@Autowired
	private TestService testServiceImpl;
	
	@RequestMapping(value = "/test")
	public String test(Model model) {
		try{
			log.info("TestController...test");
			System.out.println(testServiceImpl.getSysdate());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "login";
	}
		
	@RequestMapping(value = "/test.json")
	public @ResponseBody Map<String, String> testJson(Model model) {
		Map<String,String> map = new HashMap<String,String>();
		try{
			log.info("TestController...testJson");
			Thread.sleep(3000);	//3√  ∏ÿ√„
			map.put("value", testServiceImpl.getSysdate());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return map;
	}
	
	@RequestMapping(value = "/test/test")
	public String testtest(Model model) {
		Map<String,String> map = new HashMap<String,String>();
		try{
			log.info("TestController...testtest");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "testtest";
	}
}
