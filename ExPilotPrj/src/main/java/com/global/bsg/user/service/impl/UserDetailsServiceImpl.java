package com.global.bsg.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.global.bsg.common.session.SessionUserInfo;
import com.global.bsg.user.dao.UserDao;
import com.global.bsg.user.dto.TestUserDto;
import com.global.bsg.user.dto.TestUserRoleDto;



public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource(name="bcryptPasswordEncoder")
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Inject
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		TestUserDto testUserDto = new TestUserDto();
		testUserDto.setId(id);
		testUserDto = userDao.selectTestUser(testUserDto);
		
		if (testUserDto == null || testUserDto.getPw() == null) {
			throw new UsernameNotFoundException("인증 실패...");
		}
		
		String pw = testUserDto.getPw();
		
		List<TestUserRoleDto> testUserRoleDtoList = userDao.selectTestUserRole(testUserDto);
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		if(testUserRoleDtoList != null && testUserRoleDtoList.size() > 0){
			for(TestUserRoleDto roleDto : testUserRoleDtoList){
				roles.add(new SimpleGrantedAuthority(roleDto.getUserRole()));
			}
		}
		
		SessionUserInfo user = new SessionUserInfo(id, pw, roles);
		user.setUserName(testUserDto.getUserName());
		user.setRegDate(testUserDto.getRegDate());
		user.setModDate(testUserDto.getModDate());
		return user;
	}
	

}
