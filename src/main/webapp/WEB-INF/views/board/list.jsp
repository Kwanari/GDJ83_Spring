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
<div class="container">
<h1>${board}</h1>
		<div class="row justify-content-center">
			<div class="dropdown">
			  <a class="btn dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			    개수
			  </a>
			
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="list?perPage=5">5개씩</a></li>
			    <li><a class="dropdown-item" href="list?perPage=10">10개씩</a></li>
			    <li><a class="dropdown-item" href="list?perPage=15">15개씩</a></li>
			  </ul>
			</div>
		</div>
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
		<div class="d-grid gap-2 d-md-flex justify-content-md-center">
			<form action="list" method="GET" class="row row-cols-lg-auto g-3 align-items-center">
			  <div class="col-2">
			    <label class="visually-hidden" for="search">검색어를 입력해 주세요.</label>
			    <div class="input-group">
			      <input type="text" class="form-control" id="search" name="search" placeholder="검색어를 입력해 주세요.">
			    </div>
			  </div>
			
			  <div class="col-2">
			    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
			    <select name="kind" class="form-select" id="inlineFormSelectPref">
			      <option value="k1">제목</option>
			      <option value="k2">내용</option>
			      <option value="k3">작성자</option>
			    </select>
			  </div>
		
			  <div class="col-2">
			    <button type="submit" class="btn btn-primary">Submit</button>
			  </div>
			</form>
		</div>
		
	<div class="mt-3 d-grid gap-2 d-md-flex justify-content-md-center">
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item ${pager.pre?'':'disabled'}">
		      <a class="page-link" href="list?page=${pager.startnum-1}&kind=${pager.kind}&search=${pager.search}&perPage=${pager.perPage}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <c:forEach begin="${pager.startnum}" end="${pager.lastnum}" step="1" var="i">
		    <li class="page-item"><a class="page-link" href="list?page=${i}&kind=${pager.kind}&search=${pager.search}&perPage=${pager.perPage}">${i}</a></li>
		    </c:forEach>
		    <li class="page-item ${pager.next?'':'disabled'}">
		      <a class="page-link" href="list?page=${pager.lastnum+1}&kind=${pager.kind}&search=${pager.search}&perPage=${pager.perPage}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</div>
</div>

<script>
const dropdownElementList = document.querySelectorAll('.dropdown-toggle')
const dropdownList = [...dropdownElementList].map(dropdownToggleEl => new bootstrap.Dropdown(dropdownToggleEl))
</script>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>


</body>
</html>