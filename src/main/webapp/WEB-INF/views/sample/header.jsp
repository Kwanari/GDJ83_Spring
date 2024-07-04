<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<nav class="navbar" style="background-color: #e3f2fd;">
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" href="/product/list">금융상품</a>
  </li>
  
  <c:if test="${not empty member}">
  
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
  
    </c:if>
</ul>
</nav>