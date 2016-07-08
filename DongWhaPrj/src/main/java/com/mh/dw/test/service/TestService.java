package com.mh.dw.test.service;

import java.util.List;
import java.util.Map;

import com.mh.dw.test.dto.DbTestDto;

public interface TestService {
	
	public String selectSysdate() throws Exception;
	
	public List<DbTestDto> selectDbTestList() throws Exception;
	
	public Map<String, Object> selectTestSapData() throws Exception;
}
