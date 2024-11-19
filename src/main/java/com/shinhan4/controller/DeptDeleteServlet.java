package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptService;

/**
 * Servlet implementation class DeptDeleteServlet
 */
@WebServlet("/dept/delete.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_dept = request.getParameter("depid");
		int dept_id = 0;
		if(str_dept != null ) {
			dept_id = Integer.parseInt(str_dept);
		}
		
		System.out.println(dept_id + "삭제할 예정");
		
		DeptService dService = new DeptService();
		int result = dService.deleteService(dept_id);
		System.out.println("삭제결과:" + result);
		response.sendRedirect("select.do");
	}

	 
}
