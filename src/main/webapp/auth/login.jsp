<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Sign In</h1>
<!-- 상대경로: http://localhost:9090 -->
<!-- 절대경로: http://localhost:9090/bananaShop/auth/login.do -->
<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>
<form action="${path}/auth/login.do" method="get">
    <label>사용자번호</label>
    <input type="text" name="userid" value="master"><br>
    <label>비밀번호</label>
    <input type="password" name="userpass" value="1234"><br>
    <input type="submit" value="로그인">
</form>

<!-- 전달받은 userid와 userpass 출력 -->
<p>사용자 ID: ${userId}</p>
<p>비밀번호: ${userPass}</p>
</body>
</html>