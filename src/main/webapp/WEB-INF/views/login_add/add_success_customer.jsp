<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>환영합니다.</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/view_balance_info.css'/>" rel="stylesheet" />
        <script type="text/javascript"	src="<c:url value='/resources/js/common.js'/>"></script>
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
	<div class="box">
        	<div class="box-content">
				<h3 class="box-content-text">${customerCommand.name}님 가입을 환영합니다.<span class="money">${depositMoney}</span>원 입금되었습니다.</h3>    	
				<button type="button" style="color:white;" class="submit-btn" onclick='location.href="<c:url value='login'/>"'>로그인하러 가기</button>	
        	</div>
    </div>
</body>
</html>

 		