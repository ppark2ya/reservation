<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../myResource.jsp"></jsp:include>
<style>
	#headerlogo{
		margin : 50px 0px 50px 0px;
	}
	#myForm{
		width: 340px;
		display: block;
	}
	.box{
		background-color: #fff;
		padding: 20px;
		border: 1px solid #d8dee2;
		border-radius: 5px;
	}
	input{
		margin-top: 20px;
		margin-bottom: 15px;
	}
	.create-account{
		width: 340px;
		padding: 15px 20px;
	    text-align: center;
	    border: 1px solid #d8dee2;
	    border-radius: 5px;
	    background-color: #fff;
	}	
</style>
<title>Forget Password</title>
</head>
<body>
	<div class="container">
		<div class="col-xs-8 col-xs-offset-4">
			<a href="../home.do">
				<img src="${pageContext.request.contextPath }/resources/images/reservation.PNG" id="headerlogo">
			</a>
		</div>
		<div class="col-xs-2"></div>

		<div class="col-xs-2"></div>
		<div class="col-xs-8 col-md-offset-4">
			<form action="resetpassword.do" method="post" id="myForm">
				<div class="text-center">
					<h2 style="margin-bottom: 30px;">Reset your password</h2>
				</div>
				<div class="box form-group">
					<div class="form-group">
					<label for="inputInfo" class="control-label">Enter your ID and new password</label>
						<input type="text" class="form-control input-block" id="id" name="id" placeholder="Enter your ID">
						<input type="password" class="form-control input-block" id="pwd" name="pwd" placeholder="Reset your password">
						<input type="password" class="form-control input-block" id="pwd2" name="pwd2" placeholder="Re-Enter your password">
						<button type="submit" class="btn btn-primary btn-block" tabindex="3">Send new password</button>
					</div>
				</div>	
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
<script>
	document.querySelector("#myForm")
	.addEventListener("submit", function(event){
		var inputPwd = document.querySelector("#pwd").value;
		var inputPwd2 = document.querySelector("#pwd2").value;
		if(inputPwd != inputPwd2){
			alert("비밀번호를 확인하세요");
			document.querySelector("#pwd").value = "";
			document.querySelector("#pwd2").value = "";
			event.preventDefault();	// 폼 전송 막기
		}
	});
</script>
</body>
</html>