<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>" />
<script language="javascript">
//버튼클릭시 javascript 호출합니다.
function javascript(){
 
    //팝업창에서 부모창을 다른페이지로 이동합니다.
    window.opener.location.href="http://www.naver.com";
}
</script>
</head>
<body>
	보내시는 분 : ${userId}님<br>
	금액 : ${sendMoney}원<br>
	받으시는 분 : ${receiveName}님<br>
	맞습니까?
	<button type="button" onclick='location.href="<c:url value='/account/transfer_success'/>"'>예</button>
	<button type="button" onclick='location.href="<c:url value='/account/transfer'/>"'>아니요</button>
</body>
</html>

