<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>application/session/request에 Bind연습2</h1>
<p>myName을 읽음 : ${myName}</p>
<p>myName2을 읽음 : ${myName2}</p>
<p>myName3을 읽음 : ${myName3}</p>

<h2>Browser에 저장된 정보 읽기</h2>
<button onclick="f_local()">Loval Stroage에 저장</button>
<button onclick="f_session()">session Strage에 저장</button>
<hr>
<div id="here"></div>
<script>
	function f_local() {
		let a = localStorage.getItem("myname","JJ");
		let b = localStorage.getItem("mymajor","computer");
		let c = localStorage.getItem("myscore","99");
		document.querySelector("#here").innerHTML = a + "<br>" + b + "<br>" + c + "<br>";
	}
	function f_session() {
		let a =localStorage.getItem("myname2","JJ2");
		let b = localStorage.getItem("mymajor2","computer2");
		let c = localStorage.getItem("myscore2","98");
		document.querySelector("#here").innerHTML = a + "<br>" + b + "<br>" + c + "<br>";
	}
</script>
</body>
</html>