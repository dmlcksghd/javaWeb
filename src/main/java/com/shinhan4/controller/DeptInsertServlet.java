package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/dept/insert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청은 서블릿이 받고 응답은 jsp위임함   
		RequestDispatcher rd = request.getRequestDispatcher("deptInsert.jsp");
          rd.forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post방식은 parameter가 URI로 오지않고 요청문서의 body로 온다. encoding되지않아 한글깨짐 
		request.setCharacterEncoding("utf-8");
		
		String hiddenTest = request.getParameter("phone");
		System.out.println("hiddenTest:" + hiddenTest);
		
		int deptid = Integer.parseInt(request.getParameter("department_id"));
		String deptname = request.getParameter("department_name");
		int mid = Integer.parseInt(request.getParameter("manager_id"));
		int locid = Integer.parseInt(request.getParameter("location_id"));
		DeptDTO dept = DeptDTO.builder()
				.department_id(deptid)
				.department_name(deptname)
				.manager_id(mid)
				.location_id(locid)
				.build();
		DeptService dService = new DeptService();
		int count = dService.insertService(dept);
		System.out.println(count + "건 입력");
	
		request.setAttribute("resultMessage", count + "건 입력");
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);	
		
		
	}

}






