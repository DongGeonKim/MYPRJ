package com.global.bsg.common.session;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class SessionUserInfo extends User {
	
	public SessionUserInfo(String id, String pw, Collection<? extends GrantedAuthority> auth) {
		super(id, pw, auth);
	}
	public String getId() {
		return super.getUsername();
	}
	
	private Integer seq;
	private String userName;
	private Timestamp regDate;
	private Timestamp modDate;
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
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
