<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link href="<c:url value='/resources/css/add_customer.css'/>" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
	<form action="add_customer" method="POST" class="joinForm">
                                                                                               
      <h2>회원가입</h2>
      <div class="textForm">
        <input name="userId" type="text" class="id" placeholder="아이디">
        </input>
      </div>
      <div class="textForm">
        <input name="passwd" type="password" class="pw" placeholder="비밀번호">
      </div>
       <div class="textForm">
        <input name="passwdConfirm" type="password" class="pw" placeholder="비밀번호 확인">
      </div>
      <div class="textForm">
        <input name="name" type="text" class="name" placeholder="이름">
      </div>
      <div class="textForm">
        <input name="ssn" type="text" class="cellphoneNo" placeholder="123456-1234567">
      </div>
      <div class="textForm">
        <input name="phone" type="text" class="cellphoneNo" placeholder="010-1234-1234">
      </div>
      <input type="submit" class="btn" value="J O I N"/>
    </form>
</body>
</html>