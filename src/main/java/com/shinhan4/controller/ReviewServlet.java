package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet: 사용자의 요청을 받아서 서버에서 실행가능한 자바class
 * HttpServlet : http프로토콜 처리가능 
 * @WebServlet : 사용자의 요청의 주소 정의 : 주의는 반드시 /로 시작
 */
@WebServlet("/tv/tvProductMain.gs")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReviewServlet() {
       System.out.println("ReviewServlet생성자(1회)");
    }
	@Override
	public void init() throws ServletException {
		 System.out.println("ReviewServlet init..초기화작업(1회)"); 
	}
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReviewServlet doGet()..get요청시마다 실행");  
		
		System.out.println("요청방식:" + request.getMethod() );
		System.out.println("path:" + request.getContextPath() );
		System.out.println("client ip주소:" + request.getRemoteAddr() );
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter()
		.append("<h1>!!!!환영합니다.</h1>")
		.append("<h2>서버의 ip는 " + request.getLocalAddr() + "</h2>")
		.append("<h2>서버의 이름은 " + request.getLocalName() + "</h2>")
		.append("<h2>당신의 ip는 " + request.getRemoteAddr() + "</h2>")
		;
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReviewServlet doPost()..post요청시마다 실행");  
	}

}
