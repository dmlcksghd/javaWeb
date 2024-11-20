<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>
<meta name="viewprot" content="width=device-width, initiial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<style>
loginInfo {
	
}
</style>
<div id="loginInfo">
	<p>${loginMember2}님이 접속중입니다.(session)</p>
	<a href="${path}/auth/logout.do" class="btn btn-danger">로그아웃</a>
</div>

<%
String myName = "AA";
%>