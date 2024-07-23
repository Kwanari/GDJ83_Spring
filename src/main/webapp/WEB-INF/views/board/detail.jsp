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
	                <div class="card shadow mb-4">
		                <div class="card-header py-3">
		                	<h6 class="m-0 font-weight-bold text-primary">${dto.boardtitle}</h6>
		                </div>
		                <div class="card-body">
										<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>작성날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>${dto.boardnum}</td>
						<td>${dto.boardwriter}</td>
						<td>${dto.createdate}</td>
						<td>${dto.boardhit}</td>
					</tr>
					<tr>
						<td colspan="4">${dto.boardcontents}</td>
					</tr>
					
				</tbody>
			</table>
			<div class="row">
				<div>
					<c:forEach items="${dto.boardFileDTOs}" var="i">
						<a href="fileDown?filenum=${i.filenum}" class="btn btn-info">${i.oriname}</a>
					</c:forEach>
					<a href="./reply?boardnum=${dto.boardnum}" class="btn btn-danger">답글</a>
					<a href="./update?boardnum=${dto.boardnum}" class="btn btn-danger">수정</a>
					<a href="./delete?boardnum=${dto.boardnum}" class="btn btn-primary">삭제</a>
				</div>
			</div>			                   
		                </div>
	                </div>         		
         		
         		</div>         		
         		
         		</div>
         	</div>
         	
         	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
         </div>
    </div>
    
    <c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>