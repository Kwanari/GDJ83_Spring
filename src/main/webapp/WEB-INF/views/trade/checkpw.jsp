<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 확인</h1>
	
	<form action="checkpw" method="POST">
		<input type="hidden" value="${dto.bank_id}" name="bank_id">
		<label for="bank_pw">계좌 비밀번호 입력 (4자리만 가능)</label>
		<input type="password" id="bank_pw" name="bank_pw">
	<button type="submit" class="btn btn-primary">비밀번호 입력</button>
	</form>
 
</body>
</html>