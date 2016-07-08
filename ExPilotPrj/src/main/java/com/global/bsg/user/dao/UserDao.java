package com.global.bsg.user.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.global.bsg.user.dto.TestUserDto;
import com.global.bsg.user.dto.TestUserRoleDto;

public interface UserDao {
	
	public TestUserDto selectTestUser(TestUserDto testUserDto) throws DataAccessException;
	
	public List<TestUserRoleDto> selectTestUserRole(TestUserDto testUserDto) throws DataAccessException;
	
}
