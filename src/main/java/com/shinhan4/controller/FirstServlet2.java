package com.shinhan4.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * servlet의 메서드들은 callback이다. 개발자가 정의, WAS (Web Application Server)가 호출된다.
 * 최초요청시 생성자(), init()실행됨
 * 요청에 따라 get방식이면 doGet(), post방식이면 doPost()실행됨
 * Web brower에서 요청(request) -> web서버 -> WAS(Web Application Server : Tomcat서버) -> response -> Browser
 * 기본경로(절대경로) ./ -> http://localhost:9090/bananaShop/first
 */
@WebServlet({"/first4","/first5","/aa/first6"})
public class FirstServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet2() {
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
		
		display(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post요청시 마다 발생" + request.getRemoteAddr());
	}
	
	private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>get요청에 대한 응답</h1>");
		out.print("<hr>");
		out.print("<p>LocalAddr: </p>" + request.getLocalAddr());
		out.print("<p>RemoteName: </p>" + request.getLocalName());
		out.print("<p>RemoteAddr: </p>" + request.getRemoteAddr());
		out.print("<p>RemoteUser: </p>" + request.getRemoteHost());
		
	}

}
