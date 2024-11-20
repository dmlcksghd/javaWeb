<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
 <div class="container">
 <!-- include 디렉티브태그는 jsp를 합쳐서 컴파일한다. -->
 <%@ include file="../jsp/header.jsp" %>
 <%=myName %>
 
 <%-- <p>로그인한 Member정보 request:${loginMember1.member_name}</p> --%>
 <p>로그인한 Member정보 session:${loginMember2.member_name}</p>
 <%-- <p>로그인한 Member정보 context:${loginMember3.member_name}</p> --%>
 
 <a href="${path}/auth/logout.do">로그아웃</a>
 <hr>
  <h1>직원List</h1>
  <table  class="table table-striped table-hover">
    <tr>
      <td>직원번호</td>
      <td>fname</td>
      <td>lname</td>
      <td>email</td>
      <td>phone</td>
      <td>job</td>
      <td>hiredate</td>
      <td>commission</td>
      <td>salary</td>
      <td>manager</td>
      <td>department</td>
      <td>get요청</td>
      <td>post요청</td>
    </tr>
    <c:forEach items="${empDatas}" var="emp">
	    <tr>
	      <td>
	      <a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.employee_id}</a>
	      </td>
	      <td>
	      <a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.first_name}</a>
	      </td>
	      <td>${emp.last_name}</td>
	      <td>${emp.email}</td>
	      <td>${emp.phone_number}</td>
	      <td>${emp.job_id}</td>
	      <td>${emp.hire_date}</td>
	      <td>${emp.commission_pct}</td>
	      <td>${emp.salary}</td>
	      <td>${emp.manager_id}</td>
	      <td>${emp.department_id}</td> 
	      <td>
		      <button class="btn btn-success"
		          onclick="location.href='${path}/emp/delete.do?empid=${emp.employee_id}'">
		         삭제(get)
		      </button>
	      </td>
	      <td>
	          <form action="${path}/emp/delete.do" method="post">
	            <input type="hidden" name="empid" value="${emp.employee_id}">
	            <button class="btn btn-success">삭제(post)</button>
	          </form>
	      </td>
	    </tr>
    </c:forEach>
  </table>
  </div>
</body>
</html>




