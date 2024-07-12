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
					<c:forEach items="${map.list}" var="list">
						<tr>
							<td>${list.item_id}</td>
							<td><a href="detail?item_id=${list.item_id}">${list.item_name}</td>
							<td>${list.item_rate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item ${map.pre?'':'disabled'}">
		      <a class="page-link" href="list?page=${map.start-1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <c:forEach begin="${map.start}" end="${map.fin}" step="1" var="i">
		    	<li class="page-item"><a class="page-link" href="list?page=${i}">${i}</a></li>
		    </c:forEach>

		    <li class="page-item ${map.next?'':'disabled'}">
		      <a class="page-link" href="list?page=${map.fin+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<a class="btn btn-primary" href="add" role="button">상품추가</a>
		</div>
		<br>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<a class="btn btn-primary" href="/" role="button">HOME</a>
		</div>
		
	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>