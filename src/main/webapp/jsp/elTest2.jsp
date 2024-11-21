<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	EmpService eService = new EmpService();
	List<EmpDTO> emplist = eService.selectAllService();
	pageContext.setAttribute("empDatas", emplist);
	
	Map<String, List<EmpDTO>> map = new HashMap<>();
	map.put("empMap", emplist);
	pageContext.setAttribute("mymap", map);
	
	Date d1 = new Date();
	request.setAttribute("today", d1);
	request.setAttribute("salary", 123456789);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1. 스크립트릿 : <%=emplist.get(0).getFirst_name() %><br>
2. EL(list) : ${empDatas[0].first_name}
2. EL(list) : 
	<%-- <fmt:setLocale value="en_US"/> --%>
	<fmt:setLocale value="ko_KR"/>
	<h3>입사일 : 
	<fmt:formatDate value="${empDatas[0].hire_date}" pattern="yy/MM/dd h:mm:ss"/></h3>
	<h3>오늘 : <fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" /></h3>
	<h3><fmt:formatNumber value="${salary}" type="currency" groupingUsed="true" /></h3>
	
	
3. EL(map) : ${mymap["empMap"][0].first_name}
3. EL(map) : ${mymap["empMap"][1].first_name}

<!-- JSTL (JSP Standard Tag Livrary) -->
1. setAttribute(값 저장)<br>
<c:set var="major" value="컴퓨터공학과" scope="page"/>
<c:set var="path2" value="${pageContext.servletContext.contextPath}" />
2. getAttribute: ${major}<br>
2. getAttribute: ${path2}<br>
<%@ include file="header.jsp" %>
<%-- <jsp:include page="header.jsp"/> --%>
2. getAttribute: ${path}<br>

3. 조건문: 
<c:if test="${sessionScope.loginMember==null}">
	<h2>로그인 안된 사용자</h2>
	<ul>
		<li><a href="${path}/dept/select.do">부서조회</a></li>
		<li><a href="${path}/dept/insert.do">부서입력</a></li>
	</ul>
</c:if>
<c:if test="${loginMember!=null}">
	<h2>로그인된 사용자</h2>
	<ul>
		<li><a href="${path}/emp/emplist.do">직원조회</a></li>
		<li><a href="${path}/emp/insert.do">직원입력</a></li>
		<li><a href="${path}/dept/select.do">부서조회</a></li>
		<li><a href="${path}/dept/insert.do">부서입력</a></li>
	</ul>
</c:if>

4. choose:
<%
request.setAttribute("score", 99);
%>
<c:choose>
	<c:when test="${score>=90 && score<=100}">
		<p>A학점</p>
	</c:when>
	<c:when test="${score>=80 && score<90}">
		<p>B학점</p>
	</c:when>
	<c:otherwise>
		<p>노력요함</p>
	</c:otherwise>
</c:choose>

5. 반복(forEach): 
<c:set var="total" value="0"/>
<c:forEach begin="1" end="5" step="1" var="i">
	<p>for Each로 반복중...${i}</p>
	<c:set var="total" value="${total+i}"></c:set>
</c:forEach>
<p>1~5까지 합계: ${total}</p>
<ul>
	<c:forEach items="${empDatas}" var="emp" varStatus="loopStatus">
		<li>${loopStatus.index} / ${loopStatus.count} / ${loopStatus.first} / ${emp.first_name}</li>
	</c:forEach>
</ul>
6. url만들기: JSTL의 url태그는 default로 contextPath를 사용한다. /bananaShop
<c:url var="empDetail" value="/emp/detail.do">
	<c:param name="empid" value="100"></c:param>
</c:url>
<a href="${empDetail}">100번 직원 상세보기</a>

<c:forEach begin="1" end="6" var="i">
    <img alt="이미지" src="${path}/jsp/images/photo-${i}.jpg">
</c:forEach>
</body>
</html>