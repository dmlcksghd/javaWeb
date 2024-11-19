package com.shinhan4.controller2;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/set")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("userid", "hong");
		Cookie cookie2 = new Cookie("userpass", "1234");
		Cookie cookie3 = new Cookie("phone", request.getParameter("phone"));
		Cookie cookie4 = new Cookie("major", URLEncoder.encode("컴공", "utf-8"));
		cookie4.setMaxAge(60);
		cookie4.setMaxAge(2*60);
		cookie4.setMaxAge(4*60);
		cookie4.setMaxAge(5*60);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>쿠키 저장 완료</h1>");
		
		
	}

}