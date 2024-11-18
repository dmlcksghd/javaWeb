<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>

	<div class="container mt-3">
		<h2>부서등록</h2>

		<form action="${path}/dept/insert.do" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text">부서번호</span> <input type="number" required="required"
					class="form-control" name="department_id">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">부서이름</span> <input type="text" required="required"
					class="form-control" name="department_name">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">부서장</span> <input type="number" required="required"
					class="form-control" value="101" name="manager_id">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">지역번호</span> <input type="number" required="required"
					class="form-control" value="1700" name="location_id">
			</div>
			<input type="hidden" name="phone" vlaue="010-1234-5678">


			<button type="submit" class="btn btn-primary">신규부서 등록</button>
		</form>
	</div>

</body>
</html>
