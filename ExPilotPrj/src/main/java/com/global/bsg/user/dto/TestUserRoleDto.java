package com.global.bsg.user.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TestUserRoleDto implements Serializable{
	
	private Long testUserSeq;
	private String userRole;
	
	public Long getTestUserSeq() {
		return testUserSeq;
	}
	public void setTestUserSeq(Long testUserSeq) {
		this.testUserSeq = testUserSeq;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
