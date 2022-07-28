<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link href="<c:url value='/resources/css/view_balance.css'/>" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
     <div class="wrapper">
    <div class="form-container">
	<form action="view_balance" method="post">
        <h3>잔고를 확인할 계좌를 선택해 주세요.</h3>
        <p>양식에 맞추어 회원 정보를 입력해주세요.</p>
        <div class="form-group">
          <select id="accountNumSelect" name="accountNum" required>
	          <option value="">선택하세요.</option>
	          <c:forEach var="text" items="${accountList}">
		          <option>${text.accountNum}</option>
	          </c:forEach>
          </select>
        </div>
        <button type="submit">잔고 확인</button>
      </form>
     </div>
     </div>
</body>
</html>
