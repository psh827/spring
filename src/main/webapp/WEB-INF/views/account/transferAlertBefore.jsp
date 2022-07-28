<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>송금확인</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/transferAlertBefore.css'/>" rel="stylesheet" />
        <script type="text/javascript"	src="<c:url value='/resources/js/common.js'/>"></script>
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
		<div class="wrapper">
    		<div class="form-container">
				<form action="transfer_success" method="post">
					보내시는 분 : ${name}님<br>
					금액 : <span class="money">${sendMoney}</span>원<br>
					받으시는 분 : ${receiveName}님<br>
					맞습니까?<br>
					맞다면 비밀번호 입력하세요.<br>
					<input type="password" name="passwd" required="required"/>
					<div class="btn-group">
						<button class="submit-btn" type="submit">송금</button>
						<button class="submit-btn" type="button" onclick='location.href="<c:url value='/account/transfer'/>"'>아니요</button>
					</div>
		  		</form> 
			</div>
		</div>    
</body>
</html>
