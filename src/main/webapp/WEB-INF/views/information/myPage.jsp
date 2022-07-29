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
<link href="<c:url value='/resources/css/mypage.css'/>" rel="stylesheet" />
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>>

    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-31">My page</h4>
        <form class="validation-form" action="myPage" method="post">
          <div class="row">
             <div class="col-md-6 mb-3 text_center">
              <label for="passwd">비밀번호</label>
              <input type="password" class="form-control" id="passwd" placeholder="비밀번호" name="passwd" required>
              <div class="invalid-feedback">
                비밀번호를 입력해주세요.
              </div>
            </div>
           
          </div>
            <button class="btn" type="submit">조회하기</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2022 PSH</p>
    </footer>
	

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>	
</body>
</html>