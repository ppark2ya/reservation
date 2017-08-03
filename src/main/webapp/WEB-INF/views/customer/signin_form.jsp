<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<jsp:include page="../myResource.jsp"/>
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
		margin-bottom: 25px;
	}
	.create-account{
		width: 340px;
		padding: 15px 20px;
	    text-align: center;
	    border: 1px solid #d8dee2;
	    border-radius: 5px;
	    background-color: #fff;
	}
	#checkbox{
		margin: 0 5px 0 130px;
	}
</style>
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
		<c:choose>
		<c:when test="${empty param.url }">
			<form action="signin.do" method="post" id="myForm">
		</c:when>
		<c:otherwise>
			<form action="signin.do?url=${param.url }" method="post" id="myForm">
		</c:otherwise>
		</c:choose>
				<div class="box form-group">
					<div class="form-group">
						<label for="id" class="control-label">ID</label>
						<input type="checkbox" id="checkbox" name="isSave" value="yes"/>Remember your ID
						<input type="text" class="form-control input-block" id="id" name="id" value="${savedId }">
						<label for="pwd" class="control-label">Password</label>
						<a href="forgetpasswordform.do" style="padding-left: 80px;">Forget password?</a>
						<input type="password" class="form-control input-block" id="pwd" name="pwd">
						<button type="submit" class="btn btn-primary btn-block" tabindex="3">Sign in</button>
					</div>
				</div>	
			</form>
			<p class="create-account">New to Reservation.com?&nbsp;<a href="signupform.do">Create an account</a></p>
		</div>
		<div class="col-xs-2"></div>
	</div>
</body>
</html>