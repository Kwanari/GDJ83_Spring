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
		                	<h6 class="m-0 font-weight-bold text-primary">
		                		<c:if test="${dto.boardnum eq null}">
		                			글작성
		                		</c:if>
		                		<c:if test="${dto.boardnum ne null}">
		                			글수정
		                		</c:if>
		                	</h6>
		                </div>
		                <div class="card-body">
		                	<c:if test="${dto.boardnum eq null}">
								<form method="post" enctype="multipart/form-data">
		                	</c:if>
		                	<c:if test="${dto.boardnum ne null}">
		                		<form method="post" enctype="multipart/form-data">
		                	</c:if>
								<input type="hidden" name="boardnum" value="${param.boardnum}">
								<div class="mb-3">
									<label for="boardtitle" class="form-label">제목</label>
									<input type="text" name="boardtitle" value="${dto.boardtitle}" class="form-control" id="boardtitle">
								</div>	
								<div class="mb-3">
									<label for="boardcontents" class="form-label">내용</label>
								  	<textarea name="boardcontents" class="form-control" id="boardcontents" rows="3">${dto.boardcontents}</textarea>
								</div>
								<div class="mb-3">
									<button type="button" id="add" class="btn btn-primary">파일추가</button>	
								</div>
								<div id="result">

								</div>
								
								<div class="mb-3">
									<button class="btn btn-primary">등록</button>
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
	<script src="/resources/js/commons/files.js"></script>
	<script>
		setMax(5);
	</script>
</body>
</html>