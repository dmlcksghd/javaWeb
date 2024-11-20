<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>알림: 주소가 존재하지않는 페이지입니다. 다시 확인하세요.</h1>
	<p><%=request.getRequestURL().toString()%></p>
	<p id="here"></p>
	<script type="text/javascript">
		document.querySelector("#here").innerHTML = location.href;
	</script>
	
</body>
</html>