package com.global.bsg.test.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.global.bsg.test.dao.TestDao;
import com.global.bsg.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Inject
	private TestDao testDao;
	
	@Override
	public String getSysdate() throws Exception {
		return testDao.getSysdate();
	}

}
