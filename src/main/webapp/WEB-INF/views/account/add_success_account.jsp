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
${userId}님 계좌신청이 완료되었습니다.
계좌 번호는 ${accType}입니다.
<button type="button" onclick='location.href="<c:url value='/account/view_my_accounts'/>"'>내계좌보기</button>
<button type="button" onclick='location.href="<c:url value='main'/>"'>메인으로</button>
</body>
</html>