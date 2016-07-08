package com.mh.dw.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LogManager.getLogger(SessionInterceptor.class);
	
	/**
	 * ��Ʈ�ѷ��� ȣ��Ǳ� ���� ����ȴ�.
	 *  - ���� ���� true �̸� �ڵ鷯 ���� ü���� ���� �ܰ�� ���������, false ��� �۾��� �ߴ��ϰ� �����ϹǷ� ��Ʈ�ѷ��� ���� ���ͼ��͵��� ������� �ʴ´�.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("SessionInterceptor... preHandle...");
		return true;
	}

	/**
	 * ��Ʈ�ѷ��� �����ϰ� �� �Ŀ� ȣ��ȴ�.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("SessionInterceptor... postHandle...");
	}
	
	/**
	 * Ŭ���̾�Ʈ ��û ó���� Ŭ���̾�Ʈ�� �並 ���� ������ �����ѵ� ���� �ȴ�. �並 �����׶� ���ܰ� �߻��ص� ����ȴ�.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("SessionInterceptor... afterCompletion...");
	}

}
