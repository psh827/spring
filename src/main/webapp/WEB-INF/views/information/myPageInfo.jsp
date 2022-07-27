<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous" />
<link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/mypageInfo.css'/>" rel="stylesheet" />
<style>
  	.mb-31 {
	  text-align: center;
	  padding: 25px;
	  font-weight: bold;
  	}
    body {
      min-height: 100vh;
      background-color: linear-gradient(to left rgba(255,113,31,.8));
    }

    .input-form {
      max-width: 680px;
      margin : 65px 0;
      padding: 32px;
      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
    .btn {
  	 background: linear-gradient(90deg, rgba(255,113,31,1) 0%, rgba(255,202,155,1) 100%);
     color: white;
     width: 300px;
     position: relative;
     left: 25%;
     }
  </style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
        <div class="table-title">
	<h3 style="color:black;">내 정보</h3>
	</div>
	<table class="table-fill">
		<thead>
		<tr>
		<th class="text-left">Month</th>
		<th class="text-left">Sales</th>
		</tr>
	</thead>
	<tbody class="table-hover">
	<tr>
		<td class="text-left">이름</td>
		<td class="text-left">${customer.name}</td>
	</tr>
	<tr>
		<td class="text-left">아이디</td>
		<td class="text-left">${customer.email }</td>
	</tr>
	<tr>
		<td class="text-left">전화번호</td>
		<td class="text-left">${customer.phone}</td>
	</tr>
	<tr>
		<td class="text-left">보유계좌 수</td>
		<td class="text-left">${accountNum}개 <a class="nav-link" href="<c:url value='/account/view_my_accounts'/>">계좌 보러가기</a></td>
	</tr>
	<tr>
		<td class="text-left">가입일</td>
		<td class="text-left">${customer.regDate}</td>
	</tr>
	</tbody>
	</table>

   
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2022 YM</p>
    </footer>
	

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>	
</body>
</html>