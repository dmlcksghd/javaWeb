<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<a class="btn btn-success" href="insert.do">신규등록(이동)</a>
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#myModal">신규등록(모달)</button>
	<hr>
	<h1>부서목록</h1>
	<table class="table table-bordered border-secondary">
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>메니저번호</td>
			<td>지역번호</td>
			<td></td>
			<td></td>
		</tr>
		<%--items===>List<DeptDTO> deptlist = getAttribute("deptDatas") 
         for(DeptDTO dept:deptlist){ }
           DeptDTO()/setter()
           DeptDTO(int, String, int, int)
      --%>
		<c:forEach items="${deptDatas}" var="dept">
			<tr>
				<td><a href="detail.do?deptid=${dept.department_id}">${dept.department_id}</a>
				</td>
				<td>${dept.department_name}</td>
				<td>${dept.manager_id}</td>
				<td>${dept.location_id}</td>
				<td>
					<button
						onclick="location.href='delete.do?depid=${dept.department_id}'">삭제</button>
				</td>
				<td>
					<form action="delete.do" method="post">
						<input type="hidden" name="deptid" value="${dept.department_id}">
						<input type="submit" value="삭제2">
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
</div>

	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Modal Heading</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="insert.do" method="post">
						<div class="input-group mb-3">
							<span class="input-group-text">부서번호</span> <input type="number"
								required="required" class="form-control" placeholder="숫자입력"
								name="department_id">
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text">부서이름</span> <input type="text"
								required="required" class="form-control" name="department_name">
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text">부서장</span> <input type="number"
								required="required" class="form-control" value="101"
								name="manager_id">
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text">지역번호</span> <input type="number"
								required="required" class="form-control" value="1700"
								name="location_id">
						</div>
						 

						<button type="submit" class="btn btn-primary">신규부서 등록</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
      $(function(){

         $("form").on("submit", function(event){
        	 
        	 event.preventDefault();
 			console.log({"department_id":$('[name="department_id"]').val(),
				"department_name":$('[name="department_name"]').val(),
				"manager_id":$('[name="manager_id"]').val(),
				"location_id":$('[name="location_id"]').val()
			});
 			 $.ajax({
				url:"insert.do",
				type:"post",
				data:{"department_id":$('[name="department_id"]').val(),
					"department_name":$('[name="department_name"]').val(),
					"manager_id":$('[name="manager_id"]').val(),
					"location_id":$('[name="location_id"]').val()
				},
				success:function(){
					$("#myModal").hide();
					location.reload();
				}
			}); 
         })
      });
    </script>

</body>
</html>







