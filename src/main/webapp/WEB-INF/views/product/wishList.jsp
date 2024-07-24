<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
    <div id="wrapper">
    	<c:import url="/WEB-INF/views/template/sidebar.jsp"></c:import>
    	        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
         	<div id="content">
         		<c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>
         		<div class="row justify-content-center">
         			<div class="col-md-8">
         				<!-- 검색어 입력 폼 -->
         				<form action="list">
						  <div class="form-row align-items-center mb-3">
						  	<div class="col-auto">
						      <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
						      <select name="kind" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
						        <option value="k1">상품명</option>
						        <option value="k2">상품내용</option>
						      </select>
						    </div>
						    <div class="col-sm-3 my-1">
						      <label class="sr-only" for="inlineFormInputName">Name</label>
						      <input type="text" name="search" class="form-control" id="inlineFormInputName" >
						    </div>
						    <div class="col-auto my-1">
						      <button type="submit" class="btn btn-primary">검색</button>
						    </div>
						  </div>
						</form>
         				<div>
						<button type="button" class="btn btn-danger" id="delAll">전체삭제</button>
						</div>				
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th>
										<input type="checkbox" id="chAll">
									</th>
									<th>번호</th>
									<th>상품명</th>
									<th>이자율</th>
									<th>삭제</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${wishlist}" var="dto" varStatus="i">
									<tr id="parentrow ${dto.item_id}"> <!--id="w${i.index}"-->
										<td>
											<input type="checkbox" class="ch" id="${dto.item_id}">
										</td>
										<td>${dto.item_id}</td>
										<td><a href="./detail?item_id=${dto.item_id}">${dto.item_name}</a></td>
										<td>${dto.item_rate}</td>
										<td>
											<button class="btn btn-danger btndel" data-del-id="${dto.item_id}">X</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<nav aria-label="Page navigation example">
						  <ul class="pagination">
						  
						    <li class="page-item ${pager.pre?'':'disabled'}">
						      <a class="page-link" href="./list?page=${pager.startnum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						  
						    <!-- for(int i=0;i<=10;i=i+2) -->
						    <c:forEach begin="${pager.startnum}" end="${pager.lastnum}" step="1" var="i">
						    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
						    </c:forEach>
						    
						    <li class="page-item ${pager.next?'':'disabled'}">
						      <a class="page-link" href="./list?page=${pager.lastnum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						  </ul>
						</nav>
         			
         			</div>
         		</div>
         	</div><!-- end row -->
         	
         	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
         </div>
    </div>
    
    <c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
    
    <script src="/resources/js/product/delwish.js"></script>
</body>
</html>