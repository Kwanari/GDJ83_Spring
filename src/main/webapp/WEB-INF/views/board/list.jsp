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
<!-- perPage 변환 start -->
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<div class="dropdown">
			  <a class="btn dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			    게시물 개수 변경
			  </a>
			
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="list?perPage=5&kind=${pager.kind}&search=${pager.search}">5개씩</a></li>
			    <li><a class="dropdown-item" href="list?perPage=10&kind=${pager.kind}&search=${pager.search}">10개씩</a></li>
			    <li><a class="dropdown-item" href="list?perPage=15&kind=${pager.kind}&search=${pager.search}">15개씩</a></li>
			  </ul>
			</div>
		</div>
		
<!-- perPage 변환 end -->	
	
<!-- justify-content-start start -->
	<div class="row justify-content-start">

<!-- 리스트 start -->
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
							<td>
								<c:if test="${list.del eq 0}">
								${list.boardnum}</td>
								</c:if>
							<td>
								<c:choose>
									<c:when test="${list.del eq 0}">
										<a class="btn" href="detail?boardnum=${list.boardnum}" role="button">
										<c:catch>
										<c:forEach begin="1" end="${list.depth}">--</c:forEach>
										</c:catch>
										${list.boardtitle}
										</a>
									</c:when>
									<c:otherwise>
										삭제된 글입니다
									</c:otherwise>
								</c:choose>
							</td>
							<td>${list.boardwriter}</td>
							<td>${list.createdate}</td>
							<td>${list.boardhit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
<!-- 리스트 end-->
	</div>
<!-- justify-content-start end -->

	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<c:if test="${member ne null}">
			<a class="btn btn-primary" href="add" role="button">글작성</a>
		</c:if>
		<a class="btn btn-primary" href="/" role="button">HOME</a>
	</div>
	
<!-- 검색 기능 start -->
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
			    <button type="submit" class="btn btn-primary">검색</button>
			  </div>
			</form>
		</div>
<!-- 검색 기능 end -->

<!-- 페이징 기능 start -->
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
<!-- 페이징 기능 end -->


</div>

<script>
const dropdownElementList = document.querySelectorAll('.dropdown-toggle')
const dropdownList = [...dropdownElementList].map(dropdownToggleEl => new bootstrap.Dropdown(dropdownToggleEl))
</script>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>


</body>
</html>