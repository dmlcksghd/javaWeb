package com.shinhan4.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;
import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;
import com.firstzone.emp.JobDTO;
import com.shinhan.util.DateUtil;

/**
 * 서블릿의 default주소==> http://localhost:9090/bananaShop 
 */
@WebServlet("/emp/insert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		DeptService dService = new DeptService();
		EmpService eService = new EmpService();
		
		List<DeptDTO> deptlist = dService.selectAllService();
		List<JobDTO> joblist = eService.selectAllJobService();
		List<EmpDTO> mlist = eService.selectAllService();
		//System.out.println("부서건수:" + deptlist.size());
		//System.out.println("직책건수:" + joblist.size());
		//System.out.println("메니저건수:" + mlist.size());
		
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", joblist);
		request.setAttribute("managerlist", mlist);
		
		//응답은 JSP에 위임한다.
		request.getRequestDispatcher("empInsert.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
         EmpDTO emp = makeEmp(request);
         System.out.println(emp);
         EmpService eService = new EmpService();
         int result = eService.insertService(emp);
         System.out.println(result + "건 입력");	
         
         //재요청(Browser의 요청 주소가 바뀐다.) 
         response.sendRedirect("emplist.do");
	}


	private EmpDTO makeEmp(HttpServletRequest request) {
		
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String phone = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		String email = request.getParameter("email");
		
		String str_empid = request.getParameter("employee_id");
		Integer empid = Integer.parseInt(str_empid);
		
		String str_deptid = request.getParameter("department_id");
		Integer deptid = Integer.parseInt(str_deptid);
		
		String str_manager = request.getParameter("manager_id");
		Integer mid = Integer.parseInt(str_manager);
		
		String str_commission = request.getParameter("commission_pct");	
		
		Double commission = 0.0;
		if(str_commission!="" && str_commission != null) {
			commission = Double.parseDouble(str_commission);
		}
		
		String str_salary = request.getParameter("salary");
		Double salary = 0.0;
		if(str_salary != "" && str_salary != null) {
			salary = Double.parseDouble(str_salary);
		}
		
		//String==>java.sql.Date
		Date hdate = DateUtil.convertSqlDate(
				DateUtil.convertDate(request.getParameter("hire_date")));
		
		return EmpDTO.builder()
				.commission_pct(commission)
				.department_id(deptid)
				.email(email)
				.employee_id(empid)
				.first_name(fname)
				.last_name(lname)
				.hire_date(hdate)
				.job_id(job_id)
				.manager_id(mid)
				.phone_number(phone)
				.salary(salary)
				.build();
	}

}












