<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>

</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<h1>Product List</h1>
	
	<div class="container">
		<div class="row justify-content-center">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>상품번호</th>
						<th>상품명</th>
						<th>이자율</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.item_id}</td>
							<td><a href="detail?item_id=${list.item_id}">${list.item_name}</td>
							<td>${list.item_rate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
			<!-- Page start -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li class="page-item"><a class="page-link" href="list?page=1">1</a></li>
			    <li class="page-item"><a class="page-link" href="list?page=2">2</a></li>
			    <li class="page-item"><a class="page-link" href="list?page=3">3</a></li>
			    <li class="page-item"><a class="page-link" href="list?page=4">4</a></li>
			    <li class="page-item"><a class="page-link" href="list?page=5">5</a></li>
			    <li class="page-item"><a class="page-link" href="list?page=6">6</a></li>
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			<!-- Page end -->
		
				
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a class="btn btn-primary" href="add" role="button">상품추가</a>
			</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end mt-2">
					<a class="btn btn-primary" href="/" role="button">HOME</a>
			</div>
		</div>
		<!-- row justify-content-center end -->
	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>