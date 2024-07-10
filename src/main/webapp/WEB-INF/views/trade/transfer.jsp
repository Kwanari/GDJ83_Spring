<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체</title>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>

</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<h1>계좌 이체</h1>
	<h3>1720398751182 입금 ㄱㄱ</h3>
	
	<div class="container-md">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form action="transfer" method="POST">
				<input type="hidden" value="${param.bank_id}" name="bank_id">
				<input type="hidden" value="${param.balance}" name="balance">
					<div class="row d-grid gap-2 d-md-block">
					<div class="p-1">
						<button type="button" class="btn btn-primary btn-sm" data-bs-toggle="popover" data-bs-title="잔액" data-bs-content="${acdto.balance}원">
							잔액확인
						</button>
					</div>
					</div>
					<div class="mb-3 row">
					   	<label for="account_u" class="col-sm-2 col-form-label">계좌번호</label>
					    <div class="col-sm-5  p-auto" >
					    	<input type="text" id="account_u" name="account_u" placeholder="총 13자리">
					    </div>
					</div>
					<div class="mb-3 row">
					   	<label for="difference" class="col-sm-2 col-form-label">이체금액</label>
						<div class="col-sm-5 p-auto">
					    	<input type="text" id="difference" name="difference" >
					    </div>
					    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
					    	<button type="submit" class="btn btn-primary">이체</button>
					    </div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))

</script>

</body>
</html>