<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>계좌조회</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/view_my_accounts.css'/>" rel="stylesheet" />
        <script type="text/javascript"	src="<c:url value='/resources/js/common.js'/>"></script>
        
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
	<h2>${name}님의 계좌는 다음과 같습니다.</h2>
	<br>
	<table>
    <thead>
    <tr>
        <th style="width:5%;">No</th>
        <th style="width:20%;">계좌 번호</th>
        <th style="width:20%;">계좌 유형</th>
        <th style="width:20%;">잔고</th>
        <th style="width:20%;">개설일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" begin="0" end="${fn:length(accountList) - 1}">
	    <tr>
	        <td>${i + 1}</td>
	        <td>${accountList[i].accountNum}</td>
	        <td>${accountList[i].accType}</td>
	        <td><span class="money">${accountListBalance[i]}</span>원</td>
	        <td>${accountList[i].regDate}</td>
	    </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" onclick='location.href="<c:url value='/main'/>"'>메인으로</button>
	
	
</body>
</html>