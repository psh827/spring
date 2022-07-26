<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>송금</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/css/transfer.css'/>" rel="stylesheet" />
        <script type="text/javascript"	src="<c:url value='/resources/js/common.js'/>"></script>
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <jsp:include page="../incl/header.jsp"/>
        </nav>
        <form action="transfer" method="post">
		<div class="container transfer_container filteringbox" style="padding : 100px;">
			<div class="row" style="padding-top:10px;">
				<div class="col-sm-3">
					<label for="withdrawAccountNumSelect">보낼계좌</label>
					<select id="withdrawAccountNumSelect" name="withdrawAccountNum" required>
			          <option value="">선택하세요.</option>
			          <c:forEach var="text" items="${myAccountList}">
				          <option>${text.accountNum}</option>
			          </c:forEach>
			        </select>
				</div>
				
				<div class="col-sm-3 relative-position">
		     	   <label for="state">금액</label>
		    	    <input type="text" onkeyup="inputNumberFormat(this)" name="sendMoney" required="required" />
		    	    <span class="won">원</span>
		        <div class="invalid-feedback">
		          Please provide a valid state.
		        </div>
		      </div>			
						
				<div class="col-sm-3">
		        	<label for="state">받으시는분 계좌</label>
		       		<input type="text" name="depositAccountNum" placeholder="xxx-xx-xxx"/>
		        <div class="invalid-feedback">
		          Please provide a valid state.
		        </div>
		      </div>
		      
				
			</div>
		</div>
			<div class="row" style="justify-content:center;">
				<button type="submit" style="width:250px;">송금</button>
			</div>
		</div>
</form>
  
</body>
</html>


