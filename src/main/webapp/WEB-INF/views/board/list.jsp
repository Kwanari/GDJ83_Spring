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
						        <option value="k1">제목</option>
						        <option value="k2">내용</option>
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
         				
						     				
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성날짜</th>
									<th>조회수</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${list}" var="dto">
									<tr>
										<td>${dto.boardnum}</td>
										<c:if test="${dto.del==1}">
											<td>삭제된 게시물</td>
										</c:if>
										<c:if test="${dto.del==0}">
											<td><a href="./detail?boardnum=${dto.boardnum}">${dto.boardtitle}</a></td>
										</c:if>
										<td>${dto.boardwriter}</td>
										<td>${dto.createdate}</td>
										<td>${dto.boardhit}</td>
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
						
						<div class="row">
							<div >
								<a href="./add" class="btn btn-danger">글작성</a>
							</div>
						</div>
         			
         			</div>
         		</div>
         	</div><!-- end row -->
         	
         	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
         </div>
    </div>
    
    <c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>