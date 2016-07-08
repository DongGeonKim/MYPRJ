package com.ex.customer.service.impl;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ex.customer.dao.CustomerDao;
import com.ex.customer.dto.CustomerDto;
import com.ex.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static Logger log = Logger.getLogger(CustomerServiceImpl.class);
	
	@Resource(name="bcryptPasswordEncoder")
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Inject
	private CustomerDao customerDao;
	
	public int registCustomer(CustomerDto customerDto) throws Exception {
		customerDto.setPassword(bcryptPasswordEncoder.encode(customerDto.getPassword()));	//패스워드 암호화
		return customerDao.registCustomer(customerDto);
	}
	
}
