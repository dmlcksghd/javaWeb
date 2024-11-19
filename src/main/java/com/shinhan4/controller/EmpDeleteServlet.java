package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/delete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//service()메서드가 존재하면 먼저 선택되어 service()만 수행한다.
	//service()메서드가 없으면 요청방식에 따라 doGet() 또는 doPost() 수행된다.  
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get, post모두 수행된다.
		System.out.println("요청방식:" + request.getMethod() );
		
		String str_empid = request.getParameter("empid");
		int empid = Integer.parseInt(str_empid);
		
		EmpService eService = new EmpService();
		int result = eService.deleteService(empid);
		System.out.println(result + "삭제됨");
		
		response.sendRedirect("emplist.do");
		
	}
	/*service()메서드가 존재하므로 아래의 메서드는 무시된다. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("doGet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("doPost");
	}*/

}






