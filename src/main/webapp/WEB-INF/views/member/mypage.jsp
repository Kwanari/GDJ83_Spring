<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>



	<h1> My Page </h1>
	

	<div class="container-md">
		<div class="row justify-content-center">
			<div class="table-responsive-md">
		  		<table class="table align-middle">
				    <thead>
				      <tr class="table-info">
				        <th>ID</th>
				        <th>Name</th>
				        <th>Phone</th>
				        <th>Email</th>
				      </tr>
				    </thead>
				    <tbody>
				      <tr class="align-middle">
				        <td>${member.member_id}</td>
						<td>${member.member_name}</td>
						<td>${member.member_phone}</td>
						<td>${member.member_email}</td>
				      </tr>
				    </tbody>
				</table>
			</div>
			
			<div>
			
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a class="btn btn-primary" href="update" role="button">정보 수정</a>
				</div>
				<br>
				
				<form action="delete" method="POST">
				
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				
					<input type="hidden" value="${member.member_id}" name="member_id">
					<input type="submit" value="회원탈퇴">
					<a class="btn btn-primary" href="delete" role="button">회원 탈퇴</a>
				</div>
				
				
				</form>
				
			
			</div>
		</div>
	</div>
	
		
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<a class="btn btn-primary" href="/" role="button">HOME</a>
		</div>
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>