<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
<h1>notice list</h1>
<div class="container">
	<div class="row justify-content-start">
		<div class="dropdown">
		  <a class="btn dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		    개수
		  </a>
		
		  <ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="#">5개씩</a></li>
		    <li><a class="dropdown-item" href="#">10개씩</a></li>
		    <li><a class="dropdown-item" href="#">15개씩</a></li>
		  </ul>
		</div>

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
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	    <li class="page-item">
	      <a class="page-link" href="list?page=${pager.startnum-1}&perPage=10" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <c:forEach begin="${pager.startnum}" end="${pager.lastnum}" step="1" var="i">
	    <li class="page-item"><a class="page-link" href="list?page=${i}&perPage=10">${i}</a></li>
	    </c:forEach>
	    <li class="page-item">
	      <a class="page-link" href="list?page=${pager.lastnum+1}&perPage=10" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
</div>

<script>
const dropdownElementList = document.querySelectorAll('.dropdown-toggle')
const dropdownList = [...dropdownElementList].map(dropdownToggleEl => new bootstrap.Dropdown(dropdownToggleEl))
</script>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>


</body>
</html>