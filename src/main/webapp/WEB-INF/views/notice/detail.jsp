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


<div class="container">
	<div class="row justify-content-start mt-5">

<!-- list start -->
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>${dto.boardnum}</td>
						<td>${dto.boardtitle}</td>
						<td>${dto.boardwriter}</td>
						<td>${dto.createdate}</td>
						<td>${dto.boardhit}</td>
					</tr>
				</tbody>
			</table>
			<!--list end-->
	</div>
	<!-- justify-content-start end -->
</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>