<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

<c:if test="${not empty dto}">
<!-- update start -->
	<form action="update" method="POST">
		<div class="container">
			<div class="row justify-content-center">
				<div class="row col-md-8">
					<div class="mb-3 mt-5">
					<input type="hidden" name="boardnum" class="form-control" value="${dto.boardnum}">
					<label for="boardwriter">작성자</label>
					  <input type="text" name="boardwriter" class="form-control"value="${member.member_id}" disabled>
					</div>
					<div class="mb-3">
					  <input type="text" name="boardtitle" class="form-control" placeholder="제목" value="${dto.boardtitle}">
					</div>
					<div class="mb-3">
					  <textarea class="form-control" name="boardcontents" rows="20" placeholder="내용을 입력하세요" >${dto.boardcontents}</textarea>
					</div>
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
						<input type="submit" value="수정" class="btn btn-primary">
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- update end -->
</c:if>


<c:if test="${empty dto}">
	<!-- add start -->
	<form action="add" method="POST">
		<div class="container">
			<div class="row justify-content-center">
			<h1>${board} 작성</h1>
				<div class="row col-md-8">
					<div class="mb-3 mt-5">
					  <label for="boardwriter">작성자</label>
					  <input type="text" name="boardwriter" id="boardwriter" class="form-control" value="${member.member_id}" disabled>
					</div>
					<div class="mb-3">
					  <input type="text" name="boardtitle" class="form-control" placeholder="제목">
					</div>
					<div class="mb-3">
					  <textarea class="form-control" name="boardcontents" rows="20" placeholder="내용을 입력하세요"></textarea>
					</div>
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
						<input type="submit" value="등록" class="btn btn-primary">
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- add end -->
</c:if>




<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>