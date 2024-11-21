<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.servletContext.contextPath}" scope="application"></c:set>
<meta name="viewprot" content="width=device-width, initiial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
loginInfo {
	
}
</style>
<div id="loginInfo">
	<p>${loginMember2}님이 접속중입니다.(session)</p>
	<a href="${path}/auth/logout.do" class="btn btn-danger">로그아웃</a>
</div>

<%-- <!-- ScopeTest파일에 있음 처음에 request영역에서 찾음 -> session영역에서 찾음 -> applicatio영역에서 찾음 -->
<!-- EL(Expression Language)의 내장객체 -->
1. ${company}<br>
2. ${requestScope.company}<br>
3. ${sessionScope.company}<br>
4. ${applicationScope.company}<br>

<!-- JSP 내장객체이용 Expression Language -->
2. <%=request.getAttribute("company") %><br>
3. <%=session.getAttribute("company") %><br>
4. <%=application.getAttribute("company") %><br> --%>



<%!
// 멤버변수(instance field), 멤버메서드(instance method)를 만든다.
String field1 = "instance field";
%>


<%
//local 변수
String myName = "AA";

/*
class Test {
	String field1 = "instance field";
	
	void _service() {
		String myName = "AA";
		out.write(myName)
	}
	void method1() {
		
	}
}*/
%>
<%-- <%=myName %> --%>