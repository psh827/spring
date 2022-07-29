<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container px-lg-5">
	<a class="navbar-brand" href="/banking/main">Paak's Bank</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
     	<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
         	<li class="nav-item"><a class="nav-link active" aria-current="page" href="<c:url value='/account/transfer'/>">송금</a></li>
        	 <li class="nav-item"><a class="nav-link" href="<c:url value='/account/deposit'/>">입금</a></li>
    	     <li class="nav-item"><a class="nav-link" href="<c:url value='/account/view_my_accounts'/>">내계좌 조회</a></li>
	         <li class="nav-item"><a class="nav-link" href="<c:url value='/information/view_all_customers'/>">전체회원조회</a></li>
    	     <%if(session.getAttribute("userId")== null){ %>
	         <li class="nav-item"><a class="nav-link" href="<c:url value='/login_add/login'/>">로그인</a></li>
	         <%} else{ %>
	         <li class="nav-item"><a class="nav-link" href="<c:url value='/login_add/logout'/>">로그아웃</a></li>
	         <li class="nav-item"><a class="nav-link" href="<c:url value='/information/myPage'/>">${name}님 환영합니다.</a></li>
	         <%} %>
        </ul>
   </div>
</div>