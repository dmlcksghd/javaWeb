<%@page import="com.firstzone.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP에서 자바로 작성한 코드 권장하지 않음 -->
<%
MemberDTO member = new MemberDTO();
member.setMember_id("kim");
member.setMember_name("김ㅇㅇ");
member.setMember_email("user1@example.com");
member.setMember_pass("1234");
%>
<p>id: <%=member.getMember_id() %></p>
<p>name: <%=member.getMember_name() %></p>
<p>email: <%=member.getMember_email() %></p>
<p>pass: <%=member.getMember_pass() %></p>
<hr/>

<!-- JSP에서 자바빈스로 작성한 코드(action tag) -->
<jsp:useBean id="member2" class="com.firstzone.member.MemberDTO" scope="request"/>
<jsp:setProperty property="member_id" value = "kim2" name="member2"/>
<jsp:setProperty property="member_name" value = "김ㅇㅇ2" name="member2"/>
<jsp:setProperty property="member_email" value = "user2@example.com" name="member2"/>
<jsp:setProperty property="member_pass" value = "3333" name="member2"/>
<p>
	<jsp:getProperty property="member_id" name="member2"/>
	<jsp:getProperty property="member_name" name="member2"/>
	<jsp:getProperty property="member_email" name="member2"/>
	<jsp:getProperty property="member_pass" name="member2"/>
</p>
<jsp:include page="beanTest2.jsp"></jsp:include>
</body>
</html>