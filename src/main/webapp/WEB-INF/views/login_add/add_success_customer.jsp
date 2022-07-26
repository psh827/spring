<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>" />
</head>
<body>
	<h3>회원가입 성공</h3>
	<p class="add_user_success">${customerCommand.name}님 가입을 환영합니다.</p>
	<button type="button" onclick='location.href="<c:url value='login'/>"'>로그인하러 가기</button>
</body>
</html>