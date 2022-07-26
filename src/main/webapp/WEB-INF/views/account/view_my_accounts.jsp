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
	${userId}님의 계좌는 다음과 같습니다.
	<br>
	<c:forEach var="text" items="${accountList}">
		${text}
		<br>
	</c:forEach>
	<button type="button" onclick='location.href="<c:url value='/main'/>"'>메인으로</button>
</body>
</html>