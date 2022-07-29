<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>송금성공</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/view_balance.css'/>" rel="stylesheet" />
        <script type="text/javascript"	src="<c:url value='/resources/js/common.js'/>"></script>
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
        <div class="wrapper">
    <div class="form-container" style="text-align: center;">
        <h3>송금이 완료되었습니다.</h3>
        <p>보내시는 분 : ${name}님<br>
		금액 : <span class="money">${sendMoney}원</span><br>
		받으시는 분 : ${receiveName}님<br>
		계좌의 남은 금액 : <span class="money">${afterTransferMoney}</span>원</p>
		<div class="btn-group">
	        <button type="button" onclick='location.href="<c:url value='/account/transfer'/>"' style="color: black;">다시 송금하기</button>
			<button type="button" onclick='location.href="<c:url value='/main'/>"' style="color: black;">메인으로</button>
		</div>
     </div>
     </div>
</body>
</html>


<div class="wrapper">
    <div class="form-container">
        <h3>송금이 완료되었습니다.</h3>
        <p>보내시는 분 : ${name}님<br>
		금액 : <span class="money">${sendMoney}원</span><br>
		받으시는 분 : ${receiveName}님<br>
		계좌의 남은 금액 : <span class="money">${afterTransferMoney}</span>원</p>
        <button type="button" onclick='location.href="<c:url value='/account/transfer'/>"'>다시 송금하기</button>
		<button type="button" onclick='location.href="<c:url value='/main'/>"'>메인으로</button>
     </div>
     </div>