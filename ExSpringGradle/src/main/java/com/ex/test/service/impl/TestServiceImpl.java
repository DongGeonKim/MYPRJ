package com.ex.test.service.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ex.test.dao.TestDao;
import com.ex.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	private static Logger log = Logger.getLogger(TestServiceImpl.class);
	
	@Inject
	private TestDao testDao;
	
	public String getSysdate() throws Exception {
		log.info("TestServiceImpl... getSysdate...");
		return testDao.getSysdate();
	}

}
