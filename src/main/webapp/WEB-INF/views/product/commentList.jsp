<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

	<table class="table table-hover">
	  <tbody>
		  <c:forEach items="${pcDTO}" var="i">
		    <tr>
		      <td>${i.boardwriter}</td>
		      <td>${i.boardcontents}</td>
		      <td>${i.createdate}</td>
		    </tr>
		  </c:forEach>
	  </tbody>
	</table>

	<nav aria-label="Page navigation example">
		<ul class="pagination">
						  
					    <li class="page-item ${pager.pre?'':'disabled'}">
						      <a class="page-link" href="./list?page=${pager.startnum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						  
						    <!-- for(int i=0;i<=10;i=i+2) -->
						    <c:forEach begin="${pager.startnum}" end="${pager.lastnum}" step="1" var="i">
						    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
						    </c:forEach>
						    
						    <li class="page-item ${pager.next?'':'disabled'}">
						      <a class="page-link" href="./list?page=${pager.lastnum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						  </ul>
						</nav>