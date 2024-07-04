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
	<h1>Member Join</h1>
<div class="container">
	<div class="row justify-content-center">
		<form class="row g-3 w-50" action="join" method="POST">
		  <div class="col-md-6">
		    <label for="member_id" class="form-label">ID</label>
		    <input type="text" class="form-control" id="member_id" name="member_id">
		  </div>
		  <div class="col-md-6">
		    <label for="member_pw" class="form-label">Password</label>
		    <input type="password" class="form-control" id="member_pw" name="member_pw">
		  </div>
		  <div class="col-12">
		    <label for="member_name" class="form-label">Name</label>
		    <input type="text" class="form-control" id="member_name" name="member_name" placeholder="KIM JAVA">
		  </div>
		  <div class="col-12">
		    <label for="member_phone" class="form-label">Phone</label>
		    <input type="text" class="form-control" id="member_phone" name="member_phone" placeholder="010-1234-5678">
		  </div>
		  <div class="col-md-6">
		    <label for="member_email" class="form-label">Email</label>
		    <input type="text" class="form-control" id="member_email" name="member_email" placeholder="example@example.com">
		  </div>
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">가입</button>
		  </div>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<a class="btn btn-primary" href="/" role="button">HOME</a>
		</div>
		</form>
	</div>
</div>
	
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>