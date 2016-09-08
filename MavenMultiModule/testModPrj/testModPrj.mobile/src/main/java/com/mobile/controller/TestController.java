package com.mobile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.service.TestService;

public class TestController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("testController1...");
		TestService testService = new TestService();
		request.setAttribute("str", testService.getStr());
		request.getRequestDispatcher("/WEB-INF/views/strResult.jsp").forward(request, response);
	}
	
}
