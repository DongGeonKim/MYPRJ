package com.ex.customer.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ex.customer.dao.CustomerDao;
import com.ex.customer.dto.CustomUser;

public class LoginServiceImpl implements UserDetailsService {
	
	@Resource(name="bcryptPasswordEncoder")
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Inject
	private CustomerDao customerDao;
	
	/**
	 * Spring Security Override
	 */
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		String password = customerDao.getCustomerPassword(userName);
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		System.out.println("request.password : " + request.getParameter("password"));
		
		if (password == null) {
			throw new UsernameNotFoundException("��й�ȣ�� �����ϴ�.");
		}
		
		//�Է¹��� ��ȣ�� 12�� ��� DB���� ������ ���� �н������ �´��� ��(������ true)
		System.out.println("bcryptPasswordEncoder.matches : " + bcryptPasswordEncoder.matches("12", password));
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_TELLER"));
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		//UserDetails user = new User(userName, password, roles);
		CustomUser user = new CustomUser(userName, password, roles);
		user.setUserText("Ŀ���� ������ ��������??");
		return user;
	}


}
