package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTML,JSP절대경로? http://localhost:9090
 * servelt 절대경로? http://localhost:9090/bananaShop
 * 현재경로? http://localhost:9090/bananaShop/jsp/second
 * 1. 주소 /second요청=====> 파일위치 /jsp/second.jsp
 * 2. 주소 /jsp/second요청=====>파일위치 second.jsp
 */
//@WebServlet("/jsp/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		System.out.println("ContextPath():" + request.getContextPath());
		
		//위임하기 Browser요청--->Servlet...로직수행후 --->응답은 JSP넘기기  
		RequestDispatcher rd = request.getRequestDispatcher("second.jsp");
		rd.forward(request, response);
		
	}

	 

}
