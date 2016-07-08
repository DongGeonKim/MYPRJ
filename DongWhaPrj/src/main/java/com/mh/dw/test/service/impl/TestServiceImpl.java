package com.mh.dw.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mh.dw.test.dao.TestDao;
import com.mh.dw.test.dto.DbTestDto;
import com.mh.dw.test.sap.TestSap;
import com.mh.dw.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Inject
	private TestDao testDao;
	
	@Inject
	private TestSap testSap;
	
	@Override
	public String selectSysdate() throws Exception {
		return testDao.selectSysdate();
	}
	
	@Override
	public List<DbTestDto> selectDbTestList() throws Exception {
		return testDao.selectDbTestList();
	}

	@Override
	public Map<String, Object> selectTestSapData() throws Exception {
		return testSap.selectTestSapData();
	}
	
}
