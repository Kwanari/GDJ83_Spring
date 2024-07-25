<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<div class="row col-md-8">
			<table class="table table-hover">
			<tbody>
				<c:forEach items="${pcDTO}" var="i">
					<tr>
					<td>${i.boardwriter}</td>
					<td>${i.boardcontents}</td>
					<td>${i.createdate}</td>
					<td><c:if test="${i.boardwriter eq member.member_id}"><button type="button" class="delbtn" id="${i.boardnum}">삭제</button></c:if></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
		
		<div class="row col-md-8">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
						  
					    <li class="page-item ${pager.pre?'':'disabled'}">
						      <a class="page-link pn" data-page-num="${pager.startnum-1}" href="#" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						  
						    <!-- for(int i=0;i<=10;i=i+2) -->
						    <c:forEach begin="${pager.startnum}" end="${pager.lastnum}" step="1" var="i">
						    <li class="page-item"><a class="page-link pn" data-page-num="${i}" href="#">${i}</a></li>
						    </c:forEach>
						    
						    <li class="page-item ${pager.next?'':'disabled'}">
						      <a class="page-link pn" data-page-num="page=${pager.lastnum+1}" href="#" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						  </ul>
						</nav>
							<button class="pn" type="button">Test</button>
							</div>
