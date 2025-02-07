<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
	<%@include file="../jsp/header.jsp" %>
  <h2>부서등록</h2>
   <form action="insert.do" method="post">
    <div class="input-group mb-3">
      <span class="input-group-text">부서번호</span>
      <input type="number" required="required"  class="form-control" placeholder="숫자입력" name="department_id">
    </div>
	<div class="input-group mb-3">
      <span class="input-group-text">부서이름</span>
      <input type="text" required="required" class="form-control"  name="department_name">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">부서장</span>
      <input type="number" required="required" class="form-control" value="101" name="manager_id">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">지역번호</span>
      <input type="number" required="required" class="form-control" value="1700" name="location_id">
    </div>
    <input type="hidden" name="phone" value="010-1234-5678">
    
    <button type="submit" class="btn btn-primary">신규부서 등록</button>
    <button id="btn_ajax" type="button" class="btn btn-danger">신규부서 등록(Ajax)</button>
  </form>
</div>
<script>
$("#btn_ajax").on("click", f_jsonInsert);
function f_jsonInsert() {
	
	var obj={
			"dept_id":$('[name="department_id"]').val(),
			"deptname":$('[name="department_name"]').val(),
			"mid":$('[name="manager_id"]').val(),
			"locid":$('[name="location_id"]').val(),
			
	};
	var jsonStr = JSON.stringify(obj);
	console.log(obj);
	console.log(jsonStr);
	$.ajax({
		url:"${path}/json.do",
		type:"get",
		data:{"jsonInfo":jsonStr},
		success: function(responseData) {
			alert(responseData);
		},
		error: function(err) {
			alert(err);
		},
		complete: function() {
			alert("완료");
		}
	});
}

</script>

</body>
</html>
