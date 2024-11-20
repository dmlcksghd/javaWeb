package com.shinhan4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;
import com.firstzone.member.MemberDTO;

@WebServlet("/dept/select.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인한 Member만 직원 정보를 볼 수 있다.
		// 세션은 Browser당 1개(1사람)
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		if (member == null) {
			// 멤버가 null이면 로그인 안한것 @WebServlet("/auth/login.do") 경로로 가야함.(다시 로그인하기 위해)
			String path = getServletContext().getContextPath();
			response.sendRedirect(path + "/auth/login.do");
			return;
		}

		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAllService();
		System.out.println(request.getRemoteAddr() + "접속..." + deptlist.size() + "건 조회됨");

		request.setAttribute("deptDatas", deptlist);
		// 요청(Browser)===>Servlet받음...로직처리====>JSP에게 위임===>Browser
		request.getRequestDispatcher("deptList.jsp").forward(request, response);

	}

}
