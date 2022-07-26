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
${userId}님 계좌타입을 선택해 주세요.
<form action="add_account" method="post">
	<input type="text" name="accType"/>
	<input type="submit" value="신청"/>
</form>
</body>
</html>