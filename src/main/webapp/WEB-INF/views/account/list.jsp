<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<h1>거래내역 조회</h1>
	
		<div class="container">
		<div class="row justify-content-center">
			<table class="table table-hover">
				<thead>
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<div class="btn-group">
					  <a href="list?bank_id=${param.bank_id}&order=0" class="btn btn-primary">최신순</a>
					  <a href="list?bank_id=${param.bank_id}&order=1" class="btn btn-primary">과거순</a>
					  <a href="list?bank_id=${param.bank_id}&order=2" class="btn btn-primary">입금내역</a>
					  <a href="list?bank_id=${param.bank_id}&order=3" class="btn btn-primary">출금내역</a>
					  <a href="list?bank_id=${param.bank_id}&order=0" class="btn btn-primary">입출금</a>
					</div>
					</div>

				
					<tr>
						<th>거래일</th>
						<th>구분</th>
						<th>금액</th>
						<th>잔액</th>
					</tr>
				</thead>
				
				
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.timepoint}</td>
							<td class="${list.defference>'0'}?'text-primary':'text-danger'">
								<c:choose>
									<c:when test="${list.defference>'0'}">입금</c:when>
									<c:otherwise>출금</c:otherwise>
								</c:choose>
							</td>
							<td>${list.defference}</td>
							<td>${list.bal_result}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<a class="btn btn-primary" href="/" role="button">HOME</a>
		</div>
		
	</div>

</body>
</html>