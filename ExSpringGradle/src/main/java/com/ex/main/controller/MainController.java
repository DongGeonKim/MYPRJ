package com.ex.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.customer.dto.CustomerDto;
import com.ex.customer.service.CustomerService;
import com.ex.test.dto.TestRestDto;

@Controller
public class MainController {
	
	private static Logger log = Logger.getLogger(MainController.class);
	
	@Value("#{serverProp['server.type']}")
	public String serverType;
	
	@Autowired
	private CustomerService customerServiceImpl;
	
	@RequestMapping(value = "/login")
	public String login(Model model, CustomerDto customerDto) {
		log.info("MainController...login");
		
		return "login";
	}
	
	@RequestMapping(value="/login.json")
	public @ResponseBody TestRestDto loginJson(Model model, CustomerDto customerDto) {
		log.info("MainController...loginJson");
		
    	//VO객체에 SET한후 vo객체자체를 return
    	TestRestDto test = new TestRestDto();
    	test.setId(1);
    	test.setTxt("textTxt");
    	
    	//가상의 배열및 리스트에 데이터 add
    	List<String> arraylist = new ArrayList<String>();
    	arraylist.add("a");
    	arraylist.add("b");
    	String[] array = {"a","b","c"};    	
    	test.setList(arraylist);
    	test.setArr(array);
    	
    	return test;
	}
	
	@RequestMapping(value="/login.xml")
	public @ResponseBody TestRestDto loginXml(Model model, CustomerDto customerDto) {
		log.info("MainController...loginXml");
		
    	//VO객체에 SET한후 vo객체자체를 return
    	TestRestDto test = new TestRestDto();
    	test.setId(1);
    	test.setTxt("textTxt");
    	
    	//가상의 배열및 리스트에 데이터 add
    	List<String> arraylist = new ArrayList<String>();
    	arraylist.add("a");
    	arraylist.add("b");
    	String[] array = {"a","b","c"};    	
    	test.setList(arraylist);
    	test.setArr(array);
    	
    	return test;
	}
	
	@RequestMapping(value = "/loginFail")
	public String loginFail(Model model) {
		log.info("MainController...loginFail");
		return "loginFail";
	}
	
	@RequestMapping(value = "/loginDuplicate")
	public String loginDuplicate(Model model) {
		log.info("MainController...loginDuplicate");
		return "loginDuplicate";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		log.info("MainController...logout");
		return "logout";
	}
	
	@RequestMapping(value = "/registProcess")
	public String registProcess(Model model, CustomerDto dto){
		log.info("MainController...registProcess");
		try{
			int resultCnt = customerServiceImpl.registCustomer(dto);
			log.info("Regist Customer Result Cnt : " + resultCnt);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "registResult";
	}
	
	@RequestMapping(value = "/")
	public String root(Model model) {
		log.info("MainController... root...");
		System.out.println("serverType : " + serverType);
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		log.info("MainController...main");
		return "main";
	}
	
	@RequestMapping(value = "/denied")
	public String denied(Model model) {
		log.info("MainController...denied");
		return "denied";
	}
	
	
}
