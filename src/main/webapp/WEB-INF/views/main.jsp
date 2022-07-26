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
	${userId}
	<button type="button" onclick='location.href="<c:url value='/account/add_account'/>"'>계좌신청</button>
	<button type="button" onclick='location.href="<c:url value='/account/view_my_accounts'/>"'>내계좌보기</button>
</body>
</html>