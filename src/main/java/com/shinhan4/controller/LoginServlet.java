package com.shinhan4.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.member.MemberDTO;
import com.firstzone.member.MemberService;

/**
 * default경로:http://localhost:9090/bananaShop
 * 요청주소: @WebServlet("/auth/login.do")
 * 주소패턴: 
 * 	1. 이름까지 일치하는 방법
 * 	2. 디렉토리까지만 일치하는 경우 @WebServlet("/auth/*")
 * 	3. 확장자만 일치하는 경우 @WebServlet("*.do")
 * 	4. 모든 요청 @WebServlet("/*")
 */
@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		
//		System.out.println(request.getContextPath());	// /bananaShop
//		System.out.println(request.getRequestURL().toString());	// http://localhost:9090/bananaShop/auth/login.do
//		System.out.println(request.getRequestURI()); // /bananaShop/auth/login.do
//		
//		System.out.println(request.getQueryString()); // ?뒤에오는 parameter
		
		//위임 (받은 요청을 전달)
		//forward : 주소창은 변하지않고 내용만 변경된다. 
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		
		//request.setCharacterEncoding("utf-8");
		
		//1.각각의 파라메터를 읽기
		String uid = request.getParameter("userid");
		String upass = request.getParameter("userpass");
		
		//parameter읽기 연습
//		String food = request.getParameter("food");//1개
//		System.out.println(food);		
//		String[] food2 = request.getParameterValues("food2");//여러개 
//		System.out.println(Arrays.toString(food2));
//		System.out.println("-----getParameterNames이용---------------------------------------");
//		Enumeration<String> pNames = request.getParameterNames();
//		while(pNames.hasMoreElements()) {
//			String name = pNames.nextElement();
//			if(name.equals("food2")) {
//				String[] arr = request.getParameterValues(name);//여러개 
//				System.out.println(Arrays.toString(arr));
//			}else {
//				String value = request.getParameter(name);
//				System.out.println(value);
//			}
//		}
//		System.out.println("-------getParameterMap이용-------------------------------------");
//		Map<String,String[]> map = request.getParameterMap();
//		for(String key:map.keySet()) {
//			String[] arr2 = request.getParameterValues(key);
//			System.out.println(Arrays.toString(arr2));
//		}
		
		
		
		
		
		MemberService mService = new MemberService();
		MemberDTO member = mService.loginService(uid, upass);
		String message= "";
		
		if(member == null) {
			message = URLEncoder.encode("ID가 존재하지 않습니다.","utf-8");
			response.sendRedirect("login.do?"+message);
			return;
		}else if(member.getMember_id().equals("-1")) {
			message = "PASS error";
			response.sendRedirect("login.do?"+message);
			return;
		}else {
			message = member.getMember_name() + "님 환영합니다";
			
			//로그린성공시 로그인한 Member를 저장하기
			//1.context
			ServletContext app = getServletContext();
			app.setAttribute("loginMember3", member);
			//2.session
			HttpSession session = request.getSession();
			session.setAttribute("loginMember2", member);
			session.setAttribute("loginMember", member);
			//3.request
			request.setAttribute("loginMember1", member);
			
			
			// 쿠키에 저장하기
//			Cookie cookie_id = new Cookie("loginId", member.getMember_id());
//			Cookie cookie_name = new Cookie("loginName", URLEncoder.encode(member.getMember_name(),"utf-8"));
//			Cookie cookie_email = new Cookie("loginEmail", member.getMember_email());
//			
//			response.addCookie(cookie_id);
//			response.addCookie(cookie_name);
//			response.addCookie(cookie_email);
		}
	    //1.직접HTML문서를 만들어서 응답하기 
		//response.setContentType("text/html;charset=utf-8");
		//response.getWriter().append("<h1 style='color:green'>" + message  +"</h1>");
		
		//2.JSP에 위임하여 응답하기 
		request.setAttribute("resultMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	 

}



