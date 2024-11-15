package com.shinhan4.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		
		// GET 요청으로 전달된 파라미터 읽기
        String userId = request.getParameter("userid");
        String userPass = request.getParameter("userpass");

        // 파라미터를 JSP로 전달
        request.setAttribute("userId", userId);
        request.setAttribute("userPass", userPass);
		
		//위임 (받은요청을 전달)
		// forward: 주소창은 변하지않고 내용만 변경된다.
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>ㅎㅇ</h1>");
	}


}
