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
			<!-- 검색어 입력 -->
				<form action="list" method="GET" class="row row-cols-lg-auto g-3 align-items-center mb-3">
				  <div class="col-12">
				    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
				    <select name="kind" class="form-select" id="inlineFormSelectPref">
				      <option value="k1" selected>상품명</option>
				      <option value="k2">상품내용</option>
				    </select>
				  </div>
				
				  <div class="col-12">
				    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
				    <div class="input-group">
				      <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Username">
				    </div>
				  </div>
				  
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Submit</button>
				  </div>
				</form>
		
		
			<!-- list start -->
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
			<!-- list end -->
		
			<!-- Page start -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			 <%--  <c:if test="${map.pre}"> --%>
			    <li class="page-item ${map.pre?'':'disabled'}">
			      <a class="page-link" href="list?page=${map.startnum-1}&kind=${map.kind}&search=${map.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			 <%--  </c:if> --%>
			    	<c:forEach begin="${map.startnum}" end="${map.lastnum}" step="1" var="i">
			    		<li class="page-item"><a class="page-link" href="list?page=${i}&kind=${map.kind}&search=${map.search}">${i}</a></li>
					</c:forEach>
			    <li class="page-item ${map.next?'':'disabled'}">
			      <a class="page-link" href="list?page=${map.lastnum+1}&kind=${map.kind}&search=${map.search}" aria-label="Next">
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