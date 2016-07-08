package com.mh.dw.test.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mh.dw.test.dto.DbTestDto;

public interface TestDao {
	
	/**
	 * ���ó�¥ ��������
	 * @return
	 * @throws DataAccessException
	 */
	public String selectSysdate() throws DataAccessException;
	
	/**
	 * �׽�Ʈ DB ����Ʈ ��������
	 * @return
	 * @throws DataAccessException
	 */
	public List<DbTestDto> selectDbTestList() throws DataAccessException;
	
}
