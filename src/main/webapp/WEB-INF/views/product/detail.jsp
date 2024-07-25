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
			<div>
				<div class="row justify-content-end">
					<c:forEach items="${result.productFileDTOs}" var="i">
						<a href="/resources/upload/products/${i.filename}" class="btn btn-info">${i.oriname}</a>
					</c:forEach>
					<a href="../account/add?item_id=${result.item_id}" class="btn btn-primary">상품가입</a>
					<a href="./update?item_id=${result.item_id}" class="btn btn-info">상품수정</a>
					<button type="button" id="addwish" data-product-id="${result.item_id}" class="btn btn-info">위시리스트 추가</button>
					<a href="./delete?item_id=${result.item_id}" class="btn btn-danger">상품삭제</a>
				 <div id="wishResult">
				 </div>
				
				<div>
					<!--댓글-->
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#commentModal">
						댓글 입력
					</button>
					<div> <!-- 댓글 입력 modal -->
						<div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Comment</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<textarea class="form-control" id="boardContents" rows="3"></textarea>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-dismiss="modal" id="commentClose">닫기</button>
										<button type="button" class="btn btn-primary" id="commentAdd">댓글 등록</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>		
				<!-- <textarea id="commentContents">


				</textarea>
				<button id="commentAdd" class="btn btn-primary" > 댓글 </button> -->
				<div id="commentList" class="row justify-content-center"> <!-- 댓글 목록 -->
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
    
    <script src="/resources/js/product/wish.js"></script>
	<script src="/resources/js/commons/comment.js"></script>
</body>
</html>