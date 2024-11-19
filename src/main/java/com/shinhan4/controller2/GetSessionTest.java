package com.shinhan4.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.member.MemberDTO;
import com.firstzone.member.MemberService;

/**
 * Servlet implementation class SetSessionTest
 */
@WebServlet("/session/get")
public class GetSessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 있으면 얻고 없으면 새로 생성
		HttpSession session = request.getSession(true);
		
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		System.out.println("isNew? " + session.isNew());
		System.out.println("id? " + session.getId());
		System.out.println("CreationTime? " + session.getCreationTime());
		System.out.println("LastAccessedTime? " + session.getLastAccessedTime());
		System.out.println("유효시간? " + session.getMaxInactiveInterval());
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>쿠키 저장 완료</h1>").append("<p>" + member + "</p>");
	}

}
