package com.shinhan4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import dept.DeptService;

/**
 * 
404 : 요청주소 잘못됨
405 : 
500 : 
 */
@WebServlet("/dept/select.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAllService();
		System.out.println(request.getRemoteAddr() + "접속, " + deptlist.size() + "건 조회");
		
		request.setAttribute("deptDatas", deptlist);
		//요청(Browser) -> Servlet받음 -> 로직처리 -> JSP 위임 -> Browser
		request.getRequestDispatcher("deptList.jsp").forward(request, response);
	}


}
