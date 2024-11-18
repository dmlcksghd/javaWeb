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
	<h1>부서목록</h1>
	<table border="1">
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>매니저번호</td>
			<td>지역번호</td>
		</tr>
		<%-- 
			items =>List<DeptDTO> deptlist = getAttribute("deptDatas")
			for(DeptDTO dept :deptlist) { }
			DeptDTO() // 기본생성자로 생성된다. JavaBeans기술은 기본생성자로 생성
			dept.setDepartment_id(값)
		 --%>
		<c:forEach items="${deptDatas}" var="dept">
			<tr>
				<td>${dept.department_id}</td>
				<td>${dept.department_name}</td>
				<td>${dept.manager_id}</td>
				<td>${dept.location_id}</td>
				<td><button onclick="location.href='delete.do?deptid=${dept.department_id}'">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>