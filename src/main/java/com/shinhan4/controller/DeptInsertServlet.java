package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import dept.DeptService;

/**
 * Servlet implementation class DeptListServlet
 */
@WebServlet("/dept/insert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("deptInsert.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식은 parameter가 URI로 오지않고 요청문서의 body로 온다. encoding되지 않아 한글 깨짐
		request.setCharacterEncoding("utf-8");
		
		String hiddenTest = request.getParameter("phone");
		System.out.println("hiddenTest:" + hiddenTest);
		
		int deptId = Integer.parseInt(request.getParameter("department_id"));
	    String deptName = request.getParameter("department_name");
	    int mid = Integer.parseInt(request.getParameter("manager_id"));
	    int lid = Integer.parseInt(request.getParameter("location_id"));
		
		DeptService dService = new DeptService();
		//DeptDTO deptDTO = new DeptDTO(deptId, deptName, mid, lid);
		DeptDTO deptDTO = DeptDTO.builder()
					.department_id(deptId)
					.department_name(deptName)
					.manager_id(mid)
					.location_id(lid)
					.build();
		int dept = dService.insertService(deptDTO);
		System.out.println(dept + "건 입력");
		
		request.setAttribute("resultMessage",dept + "건 입력");
		RequestDispatcher rd = request.getRequestDispatcher("/auth/result.jsp");
		rd.forward(request, response);
	}

}
