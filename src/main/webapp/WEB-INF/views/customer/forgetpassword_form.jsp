<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="myApp">
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
<body ng-controller="Ctrl">
	<div class="container">
		<div class="col-xs-8 col-xs-offset-4">
			<a href="../home.do">
				<img src="/resources/images/reservation.PNG" id="headerlogo">
			</a>
		</div>
		<div class="col-xs-2"></div>

		<div class="col-xs-2"></div>
		<div class="col-xs-8 col-md-offset-4">
		<!-- name 속성사용, novalidate : 브라우저 기본 기능을 제한함 -->
		<c:if test="${empty param.url }">
			<form action="resetpassword.do" method="post" id="myForm" name="myForm" novalidate>
		</c:if>
		<c:if test="${param.url eq '/board/writeform.do' }">
			<form action="resetpassword.do?url=${param.url }" method="post" id="myForm" name="myForm" novalidate>
		</c:if>
		<c:if test="${param.url eq '/board/detail.do' }">
			<form action="resetpassword.do?url=${param.url }" method="post" id="myForm" name="myForm" novalidate>
			<input type="hidden" name="boardSeq" value="${param.boardSeq }"/>
			<input type="hidden" name="keyword" value="${param.keyword }"/>
			<input type="hidden" name="condition" value="${param.condition }"/>
		</c:if>
		<c:if test="${param.url eq '/reservation/reservationForm.do' }">
			<form action="resetpassword.do?url=${param.url }" method="post" id="myForm" name="myForm" novalidate>
			<input type="hidden" name="roomSeq" value="${param.roomSeq }"/>
			<input type="hidden" name="checkIn" value="${param.checkIn }"/>
			<input type="hidden" name="checkOut" value="${param.checkOut }"/>
		</c:if>
				<div class="text-center">
					<h2 style="margin-bottom: 30px;">Reset your password</h2>
				</div>
				<div class="box form-group">
					<!-- 이미 존재하는 ID 일 경우 success -->
					<div class="form-group has-feedback"
						ng-class="{'has-success': myForm.id.$valid && !canUse, 'has-error': (myForm.id.$invalid && myForm.id.$dirty) || (myForm.id.$dirty && canUse) }">
						<label for="inputInfo" class="control-label">Enter your ID and new password</label>
						<input type="text" class="form-control input-block" id="id" name="id" placeholder="Enter your ID"
							ng-model="checkId.inputId"
							ng-required="true"
							ng-keyup="getId()">
					</div>
					<div class="form-group has-feedback"
						ng-class="{'has-success':myForm.pwd.$valid, 'has-error':myForm.pwd.$invalid && myForm.pwd.$dirty}">
						<input type="password" class="form-control input-block" id="pwd" name="pwd" placeholder="Reset your password"
							ng-model="pwd"
							ng-required="true"
							ng-pattern="/^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{6,20}$/">
		          		<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="myForm.pwd.$valid"></span>
						<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="myForm.pwd.$invalid && myForm.pwd.$dirty"></span>
		        		<p class="help-block" ng-show="myForm.pwd.$invalid && myForm.pwd.$dirty ">Use at least one special letter, one numeral, and six characters.</p>
					</div>
					<div class="form-group has-feedback"
						ng-class="{'has-success':myForm.pwd2.$valid, 'has-error':myForm.pwd2.$invalid && myForm.pwd2.$dirty}">
						<input type="password" class="form-control input-block" id="pwd2" name="pwd2" placeholder="Re-Enter your password"
							ng-model="pwd2"
							ng-required="true"
							ng-pattern="/^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{6,20}$/">
		          		<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="myForm.pwd2.$valid"></span>
						<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="myForm.pwd2.$invalid && myForm.pwd.$dirty"></span>
		        		<p class="help-block" ng-show="myForm.pwd2.$invalid && myForm.pwd2.$dirty ">Use at least one special letter, one numeral, and six characters.</p>
					</div>
		            <button type="submit" ng-disabled="myForm.$invalid" class="btn btn-block btn-primary" tabindex="3">Send new password</button>
				</div>
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
<script src="/resources/js/checkId.js"></script>
<script src="/resources/js/equalPwd.js"></script>
</body>
</html>