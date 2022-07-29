<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>계좌신청</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/add_account.css'/>" rel="stylesheet" />
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
  	 background: linear-gradient(90deg, #39459B 0%, #39459B 100%);
     color: white;
     width: 300px;
     position: relative;
     left: 25%;
     }
  </style>
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
 <div class="input-form-backgroud row" style="padding: 0;">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-31">계좌신청</h4>
        <form class="validation-form" action="add_account" method="post">
          <div class="row">
             <div class="col-md-6 mb-3 text_center">
              <label for="accTypeSelect">계좌타입을 선택해 주세요.<br>(S / C 중 하나 입력(대문자))</label>
              <select id="accTypeSelect" name="accType" required="required">
				<option>선택하세용</option>
				<option>S</option>
				<option>C</option>              
              </select>
              <div class="invalid-feedback">
                계좌타입을 입력하세요
              </div>
            </div>
           
          </div>
            <button class="btn" type="submit">신청</button>
        </form>
      </div>
    </div>
</form>
</body>
</html>