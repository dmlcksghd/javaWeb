<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>application/session/request에 Bind연습1</h1>
<p>myName을 읽음 : ${myName}</p>
<p>myName2을 읽음 : ${myName2}</p>
<p>myName3을 읽음 : ${myName3}</p>
<h2>PC에 저장하기</h2>
<button onclick="f_local()">Loval Stroage에 저장</button>
<button onclick="f_session()">session Strage에 저장</button>
<script>
	function f_local() {
		localStorage.setItem("myname","JJ");
		localStorage.setItem("mymajor","computer");
		localStorage.setItem("myscore","99");
	}
	function f_session() {
		localStorage.setItem("myname2","JJ2");
		localStorage.setItem("mymajor2","computer2");
		localStorage.setItem("myscore2","98");
	}
</script>
</body>
</html>