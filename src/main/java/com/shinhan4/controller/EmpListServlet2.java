package com.shinhan4.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;

import util.DateUtil;

//Servlet : 사용자의 요청을 받아서 처리가능한 서버에서 실행되는 자바Class  
@WebServlet("/emp/emplist2.do")
public class EmpListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptid = request.getParameter("deptid");
		String jobid = request.getParameter("jobid");
		String salary = request.getParameter("salary");
		String hdate = request.getParameter("hdate");
		String chk = request.getParameter("chk");
		
		Map<String, Object> map = new HashMap<>();
		map.put("department_id", Integer.parseInt(deptid));
		map.put("job_id", jobid);
		map.put("salary", Double.parseDouble(salary));
		if(chk.equals("true")) hdate = "1900-01-01";
		map.put("hire_date", DateUtil.convertSqlDate(DateUtil.convertDate(hdate)));
		
		//System.out.println(hdate);
		EmpService eService = new EmpService();
		List<EmpDTO>emplist = eService.selectByCondition(map);
		System.out.println(emplist.size());
	}

}





