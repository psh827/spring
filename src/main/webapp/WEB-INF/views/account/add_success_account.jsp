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
        <title>Heroic Features - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/view_balance_info.css'/>" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
        <div class="box">
        	<div class="box-content">
				<h3 class="box-content-text">${name}님 계좌신청이 완료되었습니다.<br> 계좌 번호는 ${accType}입니다.</h3>
				<div class="btn-box">
					<button class="submit-btn" type="button" onclick='location.href="<c:url value='/account/view_my_accounts'/>"'>내계좌보기</button>
					<button class="submit-btn" type="button" onclick='location.href="<c:url value='main'/>"'>메인으로</button>	
				</div>
        	</div>
        </div>
</body>
</html>