<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<%@ include file="../jsp/header.jsp"%>
		<%=myName%>

		<%-- <p>로그인한 Member정보 request:${loginMember1.member_name}</p> --%>
		<p>로그인한 Member정보 session:${loginMember2.member_name}</p>
		<%-- <p>로그인한 Member정보 context:${loginMember3.member_name}</p> --%>

		<a href="${path}/auth/logout.do">로그아웃</a>
		<hr>
		<fieldset>
			<div class="input-group mt-3 mb-3">
				<span class="input-group-text">부서</span> <select
					class="form-control" name="department_id">
					<option value="-1">선택안함</option>
					<c:forEach items="${deptlist}" var="dept">
						<option value="${dept.department_id}">
							${dept.department_name}</option>
					</c:forEach>
				</select> <span class="input-group-text">직책</span> <select
					required="required" class="form-control" name="job_id">
					<option value="-1">선택안함</option>
					<c:forEach items="${joblist}" var="job">
						<option ${job.job_id=='IT_PROG'?'selected':''}
							value="${job.job_id}">${job.job_id}/${job.job_title}</option>
					</c:forEach>
				</select> <span class="input-group-text">급여(이상)</span> <input type="number"
					class="form-control" name="salary" value="5000"> <span
					class="input-group-text">입사일(이후)</span> <input type="date"
					required="required" class="form-control" name="hire_date">
				<div class="input-group-text d-flex align-items-center">
					<input type="checkbox" name="chkDate" value="1" id="chkDate"
						class="form-check-input me-2"> <label for="chkDate"
						class="form-check-label mb-0">모든일자</label>
				</div>
				<button id="btn_condition" class="btn btn-primary">조건조회</button>
			</div>
		</fieldset>

		<hr>
		<h1>직원List</h1>
		<table class="table table-striped table-hover">
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
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.employee_id}</a>
					</td>
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.first_name}</a>
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
							삭제(get)</button>
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
	<script type="text/javascript">
		$(function() {
			$("#btn_condition").on("click", f_ajax);
		});
		function f_ajax() {
			$.ajax({
				url : "${path}/emp/emplist2.do",
				type : "get",
				data : {
					"deptid" : $('[name="department_id"]').val(),
					"jobid" : $('[name="job_id"]').val(),
					"salary" : $('[name="salary"]').val(),
					"hdate" : $('[name="hire_date"]').val(),
					"chk" : $('[name="chkDate"]').prop('checked')

				},
				success : function() {
				},
				error : function(err) {
					alert(err);
				}
			});

		}
	</script>
</body>
</html>




