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
									<th>ID</th>
									<th>Name</th>
									<th>Phone</th>
									<th>Email</th>
								</tr>
							</thead>
							
							<tbody>
								<tr>
									<td>${member.member_id}</td>
									<td>${member.member_name}</td>
									<td>${member.member_phone}</td>
									<td>${member.member_email}</td>
								</tr>
								
							</tbody>
						</table>
		    
						
						<div>
							<a href="./update" class="btn btn-primary">회원수정</a>
							<a href="./delete" class="btn btn-danger">회원탈퇴</a>
							
						</div>
		                </div>
	                </div>  
	                
	                       		
         		
         		</div>         		
         		<div class="col-md-8">
	                <div class="card shadow mb-4">
		                <div class="card-header py-3">
		                	<h6 class="m-0 font-weight-bold text-primary">계좌정보</h6>
		                </div>
		                <div class="card-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>계좌번호</th>
									<th>총잔액</th>
								</tr>
							</thead>
							
							<tbody>
							<c:forEach items="${member.dtos}" var="ac">
								<tr>
									<td><a href="../account/detail?item_id=${ac.item_id}">${ac.item_id}</a></td>
									<td>${ac.balance}</td>
								</tr>
							</c:forEach>	
							</tbody>
						</table>
						
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