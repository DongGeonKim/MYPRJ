package com.global.bsg.user.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class TestUserDto implements Serializable {
	
	private Integer seq;
	private String id;
	private String pw;
	private String userName;
	private Timestamp regDate;
	
	private Timestamp modDate;
		
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getModDate() {
		return modDate;
	}
	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}
	
}
