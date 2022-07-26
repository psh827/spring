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
	<h3>회원가입</h3>
	<form action="add_customer" method="post">
		<label>E-mail</label><input type="text" name="email" required="required"><br>
		<label>비밀번호</label><input type="password" name="passwd" required="required"><br>
		<label>이름</label><input type="text" name="name" required="required"><br>
		<label>주민번호</label><input type="text" name="ssn" required="required"><br>
		<label>연락처</label><input type="text" name="phone" required="required"><br>
		<input type="submit" value="확인"/>
	</form>
</body>
</html>