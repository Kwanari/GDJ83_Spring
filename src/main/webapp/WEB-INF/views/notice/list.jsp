<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
<h1>notice list</h1>
<div class="container">
	<div class="row justify-content-start">

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
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.boardnum}</td>
							<td><a class="btn" href="detail?boardnum=${list.boardnum}" role="button">${list.boardtitle}</a></td>
							<td>${list.boardwriter}</td>
							<td>${list.createdate}</td>
							<td>${list.boardhit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!--list end-->
	</div>
	<!-- justify-content-start end -->
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<a class="btn btn-primary" href="add" role="button">글작성</a>
	</div>
</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>