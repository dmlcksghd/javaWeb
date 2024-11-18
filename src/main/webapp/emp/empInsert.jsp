<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>직원등록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
[required] {
	background-color: lightgreen;
}
</style>	
</head>
<body>

<select>
	<option>A1</option>
	<option>A2</option>
	<option>A3</option>
	<option selected>A4</option>
</select>
	<c:set var="path"
		value="${pageContext.request.servletContext.contextPath}"></c:set>

	<div class="container mt-3">
		<h2>신규 직원 등록</h2>

		<form action="${path}/emp/insert.do" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text">직원번호</span> <input type="number"
					required="required" class="form-control" name="employee_id">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">이름</span> <input type="text"
					 class="form-control" name="first_name">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">성</span> <input type="text"
					required="required" class="form-control" name="last_name">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">이메일</span> <input type="text"
					 class="form-control" name="email" value="user@example.com">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">전화번호</span> <input type="text"
					 class="form-control" name="phone_number" value="010-1234-1234">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">직책</span>
					<select required="required" class="form-control" name="job_id" value="IT_PROG">
					<c:forEach items="${joblist}" var="job">
					<option ${job.job_id=='IT_PROG'?'selected':'' } value="${job.job_id}">					
					${job.job_id}/${job.job_title}
					</option>
					</c:forEach>
					</select>
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">입사일</span> <input type="date"
					required="required" class="form-control" name="hire_date">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">커미션</span> <input type="text" pattern="[0]\.[0-9]{1, 2}"
					 class="form-control" name="commission_pct">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">급여</span> <input type="number" value="10000"
					 class="form-control" name="salary">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">매니저번호</span>
					<select required="required" class="form-control" name="manager_id" value="103">
					<option value="-1">매니저없음</option>
					<c:forEach items="${managerlist}" var="manager">
						<option value="${manager.manager_id}">${manager.first_name} ${manager.last_name}</option>
					</c:forEach>
					</select>
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">부서번호</span>
					<select required="required" class="form-control" name="department_id">
					<option value="-1">부서없음</option>
					<c:forEach items="${deptlist}" var="dept">
						<option value="${dept.department_id}">
						${dept.department_name}
						</option>
					</c:forEach>
					</select>
			</div>
			<button type="submit" class="btn btn-primary">신규 직원 등록</button>
		</form>
	</div>
	<script>
		var d = new Date().toISOString().split("T")[0];
		document.querySelector("input[name='hire_date']").value = '2000-01-01';
	</script>

</body>
</html>