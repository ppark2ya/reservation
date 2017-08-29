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
				<img src="/resources/images/reservation.PNG" id="headerlogo">
			</a>
		</div>
		<div class="col-xs-2"></div>


		<div class="col-xs-2"></div>
		<div class="col-xs-8 col-md-offset-4">
		<c:choose>
			<c:when test="${empty param.url }">
				<form action="signin.do" method="post" id="myForm">
			</c:when>
			<c:when test="${param.url eq '/board/writeform.do' }">
				<form action="signin.do?url=${param.url }" method="post" id="myForm">
			</c:when>
			<c:when test="${param.url eq '/board/detail.do' }">
				<form action="signin.do?url=${param.url }" method="post" id="myForm">
				<input type="hidden" name="boardSeq" value="${param.boardSeq }"/>
				<input type="hidden" name="keyword" value="${param.keyword }"/>
				<input type="hidden" name="condition" value="${param.condition }"/>
			</c:when>
			<c:when test="${param.url eq '/reservation/reservationForm.do' }">
				<form action="signin.do?url=${param.url }" method="post" id="myForm">
				<input type="hidden" name="roomSeq" value="${param.roomSeq }"/>
				<input type="hidden" name="checkIn" value="${param.checkIn }"/>
				<input type="hidden" name="checkOut" value="${param.checkOut }"/>
			</c:when>
		</c:choose>
				<div class="box form-group">
					<div class="form-group">
						<label for="id" class="control-label">ID</label>
						<input type="checkbox" id="checkbox" name="isSave" value="yes"/>Remember your ID
						<input type="text" class="form-control input-block" id="id" name="id" value="${savedId }">
						<label for="pwd" class="control-label">Password</label>
						<c:choose>
							<c:when test="${empty param.url }">
								<a href="forgetpasswordform.do" style="padding-left: 80px;">Forget password?</a>
							</c:when>
							<c:when test="${param.url eq '/board/writeform.do' }">
								<a href="forgetpasswordform.do?url=${param.url }" style="padding-left: 80px;">Forget password?</a>
							</c:when>
							<c:when test="${param.url eq '/board/detail.do' }">
								<a href="forgetpasswordform.do?url=${param.url }&boardSeq=${param.boardSeq}&keyword=${param.keyword}&condition=${param.condition}" style="padding-left: 80px;">Forget password?</a>
							</c:when>
							<c:when test="${param.url eq '/reservation/reservationForm.do' }">
								<a href="forgetpasswordform.do?url=${param.url }&roomSeq=${param.roomSeq}&checkIn=${param.checkIn}&checkOut=${param.checkOut}" style="padding-left: 80px;">Forget password?</a>
							</c:when>
						</c:choose>
						<input type="password" class="form-control input-block" id="pwd" name="pwd">
						<button type="submit" class="btn btn-primary btn-block" tabindex="3">Sign in</button>
					</div>
				</div>
			</form>
			<p class="create-account">New to Reservation.com?&nbsp;
				<c:choose>
					<c:when test="${empty param.url }">
						<a href="signupform.do">Create an account</a>
					</c:when>
					<c:when test="${param.url eq '/board/writeform.do' }">
						<a href="signupform.do?url=${param.url }">Create an account</a>
					</c:when>
					<c:when test="${param.url eq '/board/detail.do' }">
						<a href="signupform.do?url=${param.url }&boardSeq=${param.boardSeq}&keyword=${param.keyword}&condition=${param.condition}">Create an account</a>
					</c:when>
					<c:when test="${param.url eq '/reservation/reservationForm.do' }">
						<a href="signupform.do?url=${param.url }&roomSeq=${param.roomSeq}&checkIn=${param.checkIn}&checkOut=${param.checkOut}">Create an account</a>
					</c:when>
				</c:choose>
			</p>
		</div>
		<div class="col-xs-2"></div>
	</div>
</body>
</html>