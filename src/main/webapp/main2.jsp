<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>JSP파일에서 절대경로 /는 http://localhost:9090</p>
	<li>
		<a href="/bananaShop /first2">a태그이용 get요청(절대)</a>
		<a href="first">a태그이용 get요청(상대)</a>
		<a href="./first">a태그이용 get요청(상대)</a>
		<a href="aa/first">a태그이용 get요청(상대)</a>
	</li>
</body>
</html>