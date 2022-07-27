<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${name}님의 ${accountNum} 계좌의 잔고는 ${balance}원입니다.</h3>
	<button type="button" onclick='location.href="<c:url value='/main'/>"'>메인으로</button>
</body>
</html>