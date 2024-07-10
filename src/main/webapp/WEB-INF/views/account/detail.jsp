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
<div class="container">
	<div class="row justify-content-center">
		<h2>상품 상세 정보</h2>
		<div class="table-responsive-md">
		  	<table class="table align-middle">
				<thead>
					<tr class="table-info">
				        <th>상품명</th>
				        <th>이자율</th>
				    </tr>
				</thead>
				<tbody>
				<!-- AccountDTO의 멤버변수 ProductDTO에서 멤버변수를 꺼냄 -->
				   	<tr class="align-middle">
				    	<td>${acdto.productDTO.item_name}</td>
						<td>${acdto.productDTO.item_rate}</td>
					</tr>
				</tbody>
				
			</table>
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a class="btn btn-primary" href="/trade/checkpw" role="button">계좌이체</a>
					<a class="btn btn-primary" href="/trade/work" role="button">10000원 복권긁기</a>
				</div>
				<br>
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a class="btn btn-primary" href="/member/mypage" role="button">뒤로가기</a>
				</div>
		</div>
	</div>
</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>