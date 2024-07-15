<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<nav class="navbar" style="background-color: #e3f2fd;">
<ul class="nav nav-tabs">
	<li class="nav-item">
    	<a class="nav-link" href="/notice/list?page=1&perPage=10">공지사항</a>
	</li>
		<li class="nav-item">
    	<a class="nav-link" href="/qna/list">QnA</a>
  	</li>
	<li class="nav-item">
    	<a class="nav-link" href="/product/list?page=1&perPage=10">금융상품</a>
  	</li>
  
  <%-- switch와 같은 개념 --%>
  <c:choose>
  	<c:when test="${ not empty member }">
	  <li class="nav-item">
	    <a class="nav-link" href="/member/mypage">회원정보</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="/member/logout">로그아웃</a>
	  </li>
  	</c:when>
  	
  	<%-- default --%>
  	<c:otherwise>
  	  <li class="nav-item">
	    <a class="nav-link" href="/member/join">회원가입</a>
	  </li>
	    <li class="nav-item">
	    <a class="nav-link" href="/member/login">로그인</a>
	  </li>
  	</c:otherwise>
  
  </c:choose>
  
  
  
  
  
<%--   <c:if test="${not empty member}">
  
   <li class="nav-item">
    <a class="nav-link" href="/">회원정보</a>
  </li>
    <li class="nav-item">
    <a class="nav-link" href="/">로그아웃</a>
  </li>
  
  </c:if>
  
   <c:if test="${empty member}">
  
  <li class="nav-item">
    <a class="nav-link" href="/member/join">회원가입</a>
  </li>
    <li class="nav-item">
    <a class="nav-link" href="/member/login">로그인</a>
  </li>
  
    </c:if> --%>
</ul>
</nav>