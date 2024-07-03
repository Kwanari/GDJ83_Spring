<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h1>Product Add</h1>

	<form action="add" method="POST">
		
		
		<label>상품명</label>
		<input type="text" name="item_name">
		<label>상품설명</label>
		<input type="text" name="item_detail">
		<label>이자율</label>
		<input type="text" name="item_rate">
		
		<button type="submit">추가</button>
	
	</form>


</body>
</html>