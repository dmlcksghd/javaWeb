package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet : 클라이언트에 요청을 받아서 처리가능한 자바 서브프로그램 = JAVA(o) + HTML 가능(권장안함)
 * HttpServlet : HTTP 프로토콜에서 실행가능한 서블릿
 * 요청 : http://localhost:9090/bananaShop/first
 * @WebServlet("/first")이 수행된다.
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        System.out.println("FirstServlet 생성자 -> 최초 요청시 1회 생성");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init초기화 -> 최초 요청시 1회 실행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("FirstServlet destroy는 서버중지 시 실행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get요청시 마다 발생" + request.getRemoteAddr());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post요청시 마다 발생" + request.getRemoteAddr());
	}

}
