<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
<!-- import: 다른 jsp파일의 내용을 복사해옴 -->

</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<!-- BasePackage/product -->
	<!-- /product/ 상품목록 list?GET, 상품디테일 detail?GET, 상품추가 add?GET,POST, 수정 update?GET,POST, 삭제 delete?POST -->
	<!-- 회원가입, 로그인, 마이페이지, 수정, 탈퇴 -->
	<!-- 계좌생성, 조회, 이제 -->
	
<div class="container-fluid mt-5"> <!-- container 클래스: 양쪽에 약간의 여백제외하고 공간 차지 -->
<div class="row justify-content-center">
	<div class="row">
		<div id="carouselExampleAutoplaying" class="carousel slide col-md-6" data-bs-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="/resources/images/index/1.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/resources/images/index/2.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/resources/images/index/3.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
	</div>
</div>
</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
	
</body>
</html>