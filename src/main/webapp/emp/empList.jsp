<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원List</h1>
	<table border="1">
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
		</tr>
		<%-- getAttribute방법 : items="${empDatas}" --%>
		<c:forEach items="${empDatas}" var="emp">
			<tr>
			<td>${emp.employee_id}</td>
			<td>${emp.first_name}</td>
			<td>${emp.last_name}</td>
			<td>${emp.email}</td>
			<td>${emp.phone_number}</td>
			<td>${emp.job_id}</td>
			<td>${emp.hire_date}</td>
			<td>${emp.commission_pct}</td>
			<td>${emp.salary}</td>
			<td>${emp.manager_id}</td>
			<td>${emp.department_id}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>