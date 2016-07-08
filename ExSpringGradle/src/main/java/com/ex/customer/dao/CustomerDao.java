package com.ex.customer.dao;

import org.springframework.dao.DataAccessException;

import com.ex.customer.dto.CustomerDto;

public interface CustomerDao {
	
	public String getCustomerPassword(String userName) throws DataAccessException;
	
	public int registCustomer(CustomerDto customerDto) throws DataAccessException;
}
