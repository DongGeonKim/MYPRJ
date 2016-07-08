package com.global.bsg.test.dao;

import org.springframework.dao.DataAccessException;

public interface TestDao {
	
	public String getSysdate() throws DataAccessException;
	
}
