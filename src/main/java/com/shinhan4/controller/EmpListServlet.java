package com.shinhan4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;
import com.firstzone.member.MemberDTO;

import dept.DeptDTO;
import dept.DeptService;

//Servlet : 사용자의 요청을 받아서 처리가능한 서버에서 실행되는 자바Class  
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인한 Member만 직원 정보를 볼 수 있다.
		// 세션은 Browser당 1개(1사람)
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
		if(member==null) {
			// 멤버가 null이면 로그인 안한것 @WebServlet("/auth/login.do") 경로로 가야함.(다시 로그인하기 위해)
			String path = getServletContext().getContextPath();
			response.sendRedirect(path + "/auth/login.do");
			return;
		}
				
				
         EmpService empService = new EmpService();
         List<EmpDTO> emplist =  empService.selectAllService();
         System.out.println(emplist.size() + "건");
         
         com.firstzone.dept.DeptService dService = new com.firstzone.dept.DeptService();
         
         //request영역에 empDatas이름으로 emplist정보를 저장한다.  
         //request.setAttribute("empDatas", emplist);
         request.setAttribute("deptlist", dService.selectAllService());
         request.setAttribute("joblist", empService.selectAllJobService());

         
         //위임하다.  요청-->서블릿--->jsp응답 
         RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
         rd.forward(request, response);
         
         /*
         response.setContentType("text/html;charset=utf-8");
         PrintWriter out = response.getWriter();
         out.print("<h1>직원목록</h1>");
         for(EmpDTO emp:emplist) {
        	 out.print("<p>" + emp + "</p>");
         }*/
         
          
       
	}

}





