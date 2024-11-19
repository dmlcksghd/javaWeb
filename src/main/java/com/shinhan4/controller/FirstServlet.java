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
 * Servlet : 클라이언트의 요청을 받아서 처리가능한 자바 서버프로그램 = JAVA(O) + HTML가능(권장안함)
   HttpServlet : HTTP프로토콜에서 실행가능한 서블릿 
   요청 : http://localhost:9090/bananaShop/first
   요청 : http://localhost:9090/bananaShop/first2
   @WebServlet("/first")이 수행된다.
   servlet의 메서드들은 callback이다. 개발자가 정의, WAS(Web Application Server)가 호출한다. 
   최초요청시 생성자(), init()실행됨 
   요청에 따라 get방식이면 doGet(), post방식이면 doPost()실행됨 
   web browser에서 요청(request)--->web서버---->WAS(web Application Server:Tomcat서버)--->response-->Browser 
   기본경로(절대경로) ./ => http://localhost:9090/bananaShop   
 *
 */
@WebServlet({"/first","/first2", "/aa/first3"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FirstServlet() {
        System.out.println("FirstServlet생성자...최초요청시1회 생성된다.");
    }
 	public void init(ServletConfig config) throws ServletException {
 		System.out.println("FirstServlet init초기화...최초요청시1회 실행된다.");
	}
	public void destroy() {
		System.out.println("FirstServlet destroy는 서버중지시 실행된다.");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Get요청시마다 발생 " + request.getRemoteAddr());
	    display(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post요청시마다 발생 " + request.getRemoteAddr());
		display(request, response);
	}
	
	private void display(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.print("<h1>get요청에 대한 응답</h1>");
	    out.print("<hr>");
	    
	    out.print("<p>LocalAddr:" + request.getLocalAddr() + "</p>");
	    out.print("<p>LocalName:" + request.getLocalName() + "</p>");
	    out.print("<p>RemoteAddr:" + request.getRemoteAddr() + "</p>");
	    out.print("<p>RemoteHost:" + request.getRemoteHost()+ "</p>");
	}

}
