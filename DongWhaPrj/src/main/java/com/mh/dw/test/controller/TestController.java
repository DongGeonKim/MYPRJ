package com.mh.dw.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mh.dw.test.dto.DbTestDto;
import com.mh.dw.test.service.TestService;

@Controller
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	
	@Autowired
	private TestService testServiceImpl;
	
	@Autowired
	private RestTemplate restTemplate;
	
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
	
	@RequestMapping(value = "/formTest")
	public String formTest(Model model){
		logger.info("TestController... formTest...");
		
		return "testResult";
	}
	
	@RequestMapping(value = "/restTest")
	public String restTest(Model model){
		logger.info("TestController... restTest...");
		
		Map<String, String> params = new HashMap<>();
		params.put("str", "restTestStr");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Map> entity = new HttpEntity<Map>(params, headers);
		
		ResponseEntity<Map> response = restTemplate.exchange("http://localhost/restDeleteTest/{str}", HttpMethod.DELETE, entity, Map.class, params);
		Map result = response.getBody();
		System.out.println(result.get("result"));
		model.addAttribute("str", result.get("result"));
		return "testResult";
	}
	
	@RequestMapping(value = "/restDeleteTest/{str}", method = RequestMethod.DELETE)
	public @ResponseBody Map restDeleteTest(@PathVariable String str){
		logger.info("TestController... restDeleteTest...");
		
		System.out.println("str : " + str);
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("result", Boolean.TRUE);
		
		return result;
	}
}
