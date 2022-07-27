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
        <link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
	<main class="main-box flex-grow-1 visible-md-up">
    <section class="main-box-section con">
      <!-- 로그인 페이지 시작 -->
      <div class="section-login min-height-50vh flex flex-jc-c flex-ai-c">
        <form action="login" method="POST">
          <input type="hidden" name="loginPwReal">
          <div class="login-title">
           LOGIN
          </div>
          <div class="login_cell__title">
            <span>아이디</span>
          </div>
          <div class="login_cell__body">
            <input type="text" name="userId" maxlength="50" placeholder="ID">
          </div>
          <div class="login_cell__title">
            <span>비밀번호</span>
          </div>
          <div class="login_cell__body">
            <input type="password" name="passwd" maxlength="50" placeholder="Password">
          </div>
          <div class="loginInput_cell">
            <div>
            <button class="btn btn-go" type="submit"><i class="fas fa-sign-in-alt"></i> Login</button>
            <button class="btn btn-back" type="button" onclick='location.href="<c:url value='add_customer'/>"'><i class="fas fa-undo"></i> 회원가입</button>
            </div>
          </div>
        </form>
      </div>
      <!-- 로그인 페이지 끝 -->
    </section>
  </main>
</body>
</html>