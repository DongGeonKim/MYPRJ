package com.mh.dw.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mh.dw.test.dto.DbTestDto;
import com.mh.dw.test.service.TestService;

@Controller
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	
	@Autowired
	private TestService testServiceImpl;
	
	@RequestMapping(value = "/selectSysdate.json")
	public @ResponseBody Map<String, String> selectSysdateJson(){
		logger.info("TestController... selectSysdateJson...");
		
		Map<String,String> map = new HashMap<String,String>();
		try{
			Thread.sleep(2000);	//2√  ∏ÿ√„
			map.put("value", testServiceImpl.selectSysdate());
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/selectDbTestList.ajax")
	public String selectDbTestListAjax(Model model) {
		logger.info("TestController... selectDbTestListAjax...");
		
		List<DbTestDto> list = null;
		try {
			list = testServiceImpl.selectDbTestList();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", e.getMessage());
		}
		model.addAttribute("list", list);
		return "test/testDbResultAjax";
	}
	
	@RequestMapping(value = "/selectSapTestList.ajax")
	public String selectSapTestListAjax(Model model){
		logger.info("TestController... selectSapTestListAjax...");
		
		Map<String, Object> list = new HashMap<String, Object>();
		try {
			list = testServiceImpl.selectTestSapData();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", e.getMessage());
		}
		model.addAttribute("list", list);
		return "test/testSapResultAjax";
	}
	
	
}
