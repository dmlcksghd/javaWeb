package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptService;

/**
 * Servlet implementation class DeptDeleteServlet
 */
@WebServlet("/dept/delete.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_dept = request.getParameter("deptid");
		int dept_id = 0;
		if(str_dept != null) {
			dept_id = Integer.parseInt(str_dept);
		}
		
		System.out.println(dept_id + "삭제할예정");
		
		DeptService dService = new DeptService();
		dService.deleteService(dept_id);
		
		response.sendRedirect("select.do");
	}
}
