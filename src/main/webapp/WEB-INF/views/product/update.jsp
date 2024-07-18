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
		                	<h6 class="m-0 font-weight-bold text-primary">상품수정</h6>
		                </div>
		                <div class="card-body">
							<form action="add" method="post">
								<input type="hidden" name="item_id" value="${dto.item_id}">
								<div class="mb-3">
									<label for="bookName" class="form-label">상품명</label>
									<input type="text" name="item_name" value="${dto.item_name}" class="form-control" id="bookName">
								</div>
								<div class="mb-3">
									<label for="bookRate" class="form-label">이자율</label>
									<input type="text" name="item_rate" value="${dto.item_rate}" class="form-control" id="bookRate">
								</div>				
								<div class="mb-3">
									<label for="bookDetail" class="form-label">상품설명</label>
								  	<textarea name="item_detail" class="form-control" id="bookDetail" rows="3">${dto.item_detail}</textarea>
								</div>
								
								<div class="mb-3">
									<button class="btn btn-primary">수정</button>
								</div>
								
							</form>			                   
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