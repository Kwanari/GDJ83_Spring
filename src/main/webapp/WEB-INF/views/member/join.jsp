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
		                	<h6 class="m-0 font-weight-bold text-primary">회원가입</h6>
		                </div>
		                <div class="card-body">
								
						<form method="post" id="frm">
							<div class="mb-3">
			    	            <label for="userName" class="form-label">ID</label>
			                    <input type="text" class="form-control ch" id="userName" name="member_id">
			                </div>
			                <div class="mb-3">
			                     <label for="password" class="form-label">PASSWORD</label>
			                     <input type="password" class="form-control ch" id="password" name="member_pw">
								 <div id="password-error" class="text-danger"></div>
			                 </div>
			
				             <div class="mb-3">
			    	             <label for="name" class="form-label">NAME</label>
			                     <input type="text" class="form-control ch" id="name" name="member_name">
			                 </div>
			
			                 <div class="mb-3">
				                 <label for="phone" class="form-label">PHONE</label>
			                     <input type="text" class="form-control ch" id="phone" name="member_phone">
			                 </div>
			
			                 <div class="mb-3">
			                     <label for="email" class="form-label">EMAIL</label>
			                     <input type="email" class="form-control ch" id="email" name="member_email">
			                 </div>

					 		<div class="mb-3">
								<button type="button" id="add" class="btn btn-primary">사진파일추가</button>
								
							</div>	
							
							<div id="result">


							</div>
			
			                 
					 		<div class="mb-3">
								<button type="button" id="btn" class="btn btn-primary">회원가입</button>
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
    <script type="text/javascript" src="../resources/js/member/memberJoinCheck.js"></script>
	<script type="text/javascript" src="../resources/js/commons/files.js"></script>
</body>
</html>