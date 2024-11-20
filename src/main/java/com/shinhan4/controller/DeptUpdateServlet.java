package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;

/**
 * Servlet implementation class DeptUpdateServlet
 */
@WebServlet("/dept/detail.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//detail.do?deptid
		
		String str_deptid = request.getParameter("deptid");
		int deptid = Integer.parseInt(str_deptid);
		DeptService dService = new DeptService();
		request.setAttribute("deptInfo", dService.selectByIdService(deptid));
		
		request.getRequestDispatcher("deptDetail.jsp").forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
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
		dService.updateService(dept);
		
		response.sendRedirect("select.do");
	
	}

}






