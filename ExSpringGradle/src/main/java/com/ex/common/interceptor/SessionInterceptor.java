package com.ex.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor{

	private Logger log = Logger.getLogger(SessionInterceptor.class);
	
	/**
	 * ��Ʈ�ѷ��� ȣ��Ǳ� ���� ����ȴ�.
	 *  - ���� ���� true �̸� �ڵ鷯 ���� ü���� ���� �ܰ�� ���������, false ��� �۾��� �ߴ��ϰ� �����ϹǷ� ��Ʈ�ѷ��� ���� ���ͼ��͵��� ������� �ʴ´�.
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("SessionInterceptor... preHandle...");
		return true;
	}

	/**
	 * ��Ʈ�ѷ��� �����ϰ� �� �Ŀ� ȣ��ȴ�.
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info("SessionInterceptor... postHandle...");
	}
	
	/**
	 * Ŭ���̾�Ʈ ��û ó���� Ŭ���̾�Ʈ�� �並 ���� ������ �����ѵ� ���� �ȴ�. �並 �����׶� ���ܰ� �߻��ص� ����ȴ�.
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("SessionInterceptor... afterCompletion...");
	}

}
