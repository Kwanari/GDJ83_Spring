<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Member Update</h1>
	
	<form action="update" method="POST">
	
	<label for="member_name">이름</label>
	<input type="text" value="${member.member_name}" id="member_name" name="member_name">
	<label for="member_phone">연락처</label>
	<input type="text" value="${member.member_phone}" id="member_phone" name="member_phone">
	<label for="member_email">이메일</label>
	<input type="text" value="${member.member_email}" id="member_email" name="member_email">
	
	<input type="submit" value="수정">
	</form>
	
</body>
</html>