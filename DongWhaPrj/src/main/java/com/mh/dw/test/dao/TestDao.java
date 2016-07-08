package com.mh.dw.test.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mh.dw.test.dto.DbTestDto;

public interface TestDao {
	
	/**
	 * 오늘날짜 가져오기
	 * @return
	 * @throws DataAccessException
	 */
	public String selectSysdate() throws DataAccessException;
	
	/**
	 * 테스트 DB 리스트 가져오기
	 * @return
	 * @throws DataAccessException
	 */
	public List<DbTestDto> selectDbTestList() throws DataAccessException;
	
}
