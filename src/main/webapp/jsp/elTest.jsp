<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Test)연습</h1>
<pre>
1. 산술연산자: ${1+2}
2. 비교연산자: ${10>20}
3. null무시: <%-- ${null + 10} --%>
3. null무시: <%-- ${null + "10"} --%>
4. empty: ${ empty "Hello" }
4. empty: ${ empty 10 }
4. empty: ${ empty null }
<jsp:useBean id="member" class="com.firstzone.member.MemberDTO"></jsp:useBean>
<jsp:setProperty property="member_id" value="zz" name="member"/>
4. empty: ${ empty member }
값확인: ${ member.member_id }
<jsp:useBean id="member2" class="java.util.ArrayList"></jsp:useBean>
4. empty: ${ empty member2 }
<%
//JSP내장객체를 이용해서 값을 저장하기
pageContext.setAttribute("score", 100);
request.setAttribute("score", 200);
session.setAttribute("score3", 300);
application.setAttribute("score4", 400);
%>
5. pageContext: ${score}
5. pageContext: ${sessionScope.score}
5. pageContext: ${applicationScope.score}


<!-- http://localhost:9090/bananaShop/jsp/elTest.jsp?myname=AAA -->
6. param읽기: ${param.myname}


<%
request.setAttribute("contextPath", "아무거나");
%>
</pre>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$("h1").css("background-color", "orange");
	var contextPath = "${pageContext.servletContext.contextPath}";
	
	var str = `현재어플리케이션의 path는 ==> \${contextPath}`; // \$는 톰캣(서버) 해석 안함, 브라우저가 해석함
	console.log(str);
</script>
</body>
</html>