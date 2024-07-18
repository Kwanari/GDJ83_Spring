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
		                	<h6 class="m-0 font-weight-bold text-primary">상품상세</h6>
		                </div>
		                <div class="card-body">
										<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>이자율</th>
						
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>${result.item_id}</td>
						<td>${result.item_name}</td>
						<td>${result.item_rate}</td>
					</tr>
					<tr>
						<td colspan="3">${result.item_detail}</td>
					</tr>
					
				</tbody>
			</table>
			<div class="row">
				<div >
					<a href="../account/add?item_id=${result.item_id}" class="btn btn-info">상품가입</a>
					<a href="./update?item_id=${result.item_id}" class="btn btn-danger">상품수정</a>
					<a href="./delete?item_id=${result.item_id}" class="btn btn-primary">상품삭제</a>
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