package com.shinhan4.controller2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig : 서블릿마다 존재
 */
@WebServlet(urlPatterns = {"/ServletContextTest", "/servlet/config"},
			initParams = {@WebInitParam(name="email", value="hh@naver.com")})
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet접근
		String email = getInitParameter("email");
		System.out.println(email);
		
		
		//context접근
		ServletContext app = getServletContext();
		
		String id = app.getInitParameter("username");
		String pass = app.getInitParameter("userpass");
		
		System.out.println(id + ":" + pass);
		 
		// 실행환경 defualt -> http://localhost:9090/bananaShop
		// 개발환경 defualt -> src/webapp
		// 파일 -> InputStream(1byte씩 읽음) -> InputStreamReader(2byte씩 읽음) -> BufferedReader(라인으로 읽음)
		// InputStream은 1바이트씩 읽음
		InputStream is = app.getResourceAsStream("/WEB-INF/resource/menu.txt");
		// InputStreamReader은 2바이트씩 읽고, BufferedReader는 한줄씩 읽음
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		
		while((line = br.readLine())!= null) {
			System.out.println(line);
		}
		
	}
}
