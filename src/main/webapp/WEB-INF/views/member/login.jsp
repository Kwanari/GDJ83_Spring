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

<div class="container-md">
	<div class="row justify-content-center">
		<div class="w-50">
		<form action="login" method="POST">
		  <div class="mb-3">
		    <label for="member_id" class="form-label">ID</label>
		    <!-- id value에  -->
		    <input type="text" value="${id}" class="form-control" id="member_id" name="member_id">
		  </div>
		  <div class="mb-3">
		    <label for="member_pw" class="form-label">Password</label>
		    <input type="password" class="form-control" id="member_pw" name="member_pw">
		  </div>
		  <div class="mb-3 form-check">
    		<input type="checkbox" class="form-check-input" name="remember" id="exampleCheck1">
    		<label class="form-check-label" for="exampleCheck1">ID 기억하기</label>
  		  </div>
		
		
		  <button type="submit" class="btn btn-primary">로그인</button>
		</form>
		  </div>
		
	</div>
</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>