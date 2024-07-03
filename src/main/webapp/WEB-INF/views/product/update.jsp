<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h1>Product Update</h1>

	<form action="update" method="POST">
		<input type="hidden" name="item_id"  value="${dto.item_id}">
		
		<label>상품명</label>
		<input type="text" name="item_name" value="${dto.item_name}">
		<label>상품설명</label>
		<input type="text" name="item_detail" value="${dto.item_detail}">
		<label>이자율</label>
		<input type="text" name="item_rate" value="${dto.item_rate}">
		
		<button type="submit">수정</button>
	
	</form>


</body>
</html>