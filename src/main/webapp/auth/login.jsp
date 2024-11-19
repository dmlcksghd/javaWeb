<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h1>Sign In</h1>
<!-- HTML, JSP : http://localhost:9090
     상대경로: login.do 
     절대경로: httㄴp://localhost:9090/bananaShop/auth/login.do
     /bananaShop/auth/login.do
     ${pageContext.request.servletContext.contextPath}=>/bananaShop
    여기!!!!! ${aa}  
  -->
  <%--HTML작성시 무시된다.(JSP주석) ${!!!!!!ㄴㄴㄴㄴㄴㄴ} --%>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}" ></c:set>  
  
<form action="${path}/auth/login.do" method="post"  enctype="application/x-www-form-urlencoded">
  <label>사용자번호</label>
  <input type="text" name="userid" value="user1"><br>
  <label>비밀번호</label>
  <input type="password" name="userpass" value="1234">
  <input type="submit" value="로그인">
  <hr>
  <h2>parameter연습</h2>
  <input type="radio" name="food" value="감자탕">감자탕
  <input type="radio" name="food" value="김밥">김밥
  <input type="radio" name="food" value="피자">피자
  <div>
     <input type="checkbox" name="food2" value="메뉴1">메뉴1
     <input type="checkbox" name="food2" value="메뉴2">메뉴2
     <input type="checkbox" name="food2" value="메뉴3">메뉴3
     <input type="checkbox" name="food2" value="메뉴4">메뉴4
  </div>
  
  
</form>
</body>
</html>




