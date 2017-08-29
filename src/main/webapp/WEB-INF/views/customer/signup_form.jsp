<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="UTF-8">
<title>JOIN Reservation.com</title>
<jsp:include page="../myResource.jsp"></jsp:include>
<style>
	.page-header{
		margin-top: 0;
	}
	#headerlogo{
		margin : 50px 0px 0px 0px;
	}
</style>
</head>
<body ng-controller="Ctrl">
      <article class="container">
        <div class="col-md-12">
        <div class="page-header text-center">
        	<a href="/home.do">
        		<img src="/resources/images/reservation.PNG" id="headerlogo">
        	</a>
        </div>
        <c:if test="${empty param.url }">
			<form action="signup.do" method="post" id="myForm" class="form-horizontal" name="myForm" novalidate>
		</c:if>
		<c:if test="${param.url eq '/board/writeform.do' }">
			<form action="signup.do?url=${param.url }" method="post" id="myForm" class="form-horizontal" name="myForm" novalidate>
		</c:if>
		<c:if test="${param.url eq '/board/detail.do' }">
			<form action="signup.do?url=${param.url }" method="post" id="myForm" class="form-horizontal" name="myForm" novalidate>
			<input type="hidden" name="boardSeq" value="${param.boardSeq }"/>
			<input type="hidden" name="keyword" value="${param.keyword }"/>
			<input type="hidden" name="condition" value="${param.condition }"/>
		</c:if>
		<c:if test="${param.url eq '/reservation/reservationForm.do' }">
			<form action="signup.do?url=${param.url }" method="post" id="myForm" class="form-horizontal" name="myForm" novalidate>
			<input type="hidden" name="roomSeq" value="${param.roomSeq }"/>
			<input type="hidden" name="checkIn" value="${param.checkIn }"/>
			<input type="hidden" name="checkOut" value="${param.checkOut }"/>
		</c:if>
	        <div class="form-group has-feedback"
	        	ng-class="{'has-success': myForm.id.$valid && canUse, 'has-error': (myForm.id.$invalid && myForm.id.$dirty) || (myForm.id.$dirty && !canUse) }">
	            <label class="col-sm-3 control-label" for="id">ID</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" id="id" name="id" type="text" placeholder="Enter your ID"
	            		ng-model="checkId.inputId"
	            		ng-required="true"
	            		ng-keyup="getId()"
	            		ng-minlength="4"
	            		ng-maxlength="12">
	          		<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="myForm.id.$valid && canUse"></span>
					<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="(myForm.id.$invalid && myForm.id.$dirty) || (myForm.id.$dirty && !canUse)"></span>
	            	<p class="help-block" ng-show="myForm.id.$dirty && !canUse">이미 있는 ID 입니다</p>
	            	<p class="help-block" ng-show="myForm.id.$error.minlength ">4 글자 이상 입력하세요</p>
	            	<p class="help-block" ng-show="myForm.id.$error.maxlength ">12 글자 이하 입력하세요</p>
	          	</div>
	        </div>
	        <div class="form-group has-feedback"
	        	ng-class="{'has-success':myForm.pwd.$valid, 'has-error':myForm.pwd.$invalid && myForm.pwd.$dirty}">
	          	<label class="col-sm-3 control-label" for="pwd">Password</label>
		        <div class="col-sm-6">
		        	<input class="form-control" id="pwd" name="pwd" type="password" placeholder="Enter your password"
		        		ng-model="pwd"
		        		ng-required="true"
		        		ng-pattern="/^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{6,20}$/">
	          		<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="myForm.pwd.$valid"></span>
					<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="myForm.pwd.$invalid && myForm.pwd.$dirty"></span>
		        	<p class="help-block" ng-show="myForm.pwd.$invalid && myForm.pwd.$dirty ">Use at least one special letter, one numeral, and six characters.</p>
		        </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="name">Name</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" id="name" name="name" type="text" placeholder="Enter your name">
	          	</div>
	        </div>
	        <div class="form-group has-feedback"
	        	ng-class="{'has-success':myForm.phone.$valid, 'has-error':myForm.phone.$invalid && myForm.phone.$dirty}">
	            <label class="col-sm-3 control-label" for="phone">Phone number</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" id="phone" name="phone" type="text" placeholder="Enter your phone number"
	            		ng-model="phone"
	            		ng-required="true"
	            		ng-pattern="/^\d{3}-\d{3,4}-\d{4}$/">
	          		<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="myForm.phone.$valid"></span>
					<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="myForm.phone.$invalid && myForm.phone.$dirty"></span>
		          	<p class="help-block" ng-show="myForm.phone.$invalid && myForm.phone.$dirty">Please re-enter your phone number</p>
	          	</div>
	        </div>
	       <div class="form-group has-feedback"
	       	ng-class="{'has-success':myForm.email.$valid, 'has-error':myForm.email.$invalid && myForm.email.$dirty}">
	          <label class="col-sm-3 control-label" for="email">Email Address</label>
		        <div class="col-sm-6">
		          <input class="form-control" id="email" name="email" type="email" placeholder="Enter your email address"
		          	ng-model="email"
		          	ng-required="true"
		          	ng-pattern="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/">
	          	  <span class="form-control-feedback glyphicon glyphicon-ok" ng-show="myForm.email.$valid"></span>
				  <span class="form-control-feedback glyphicon glyphicon-remove" ng-show="myForm.email.$invalid && myForm.email.$dirty"></span>
		          <p class="help-block" ng-show="myForm.email.$invalid && myForm.email.$dirty">Please re-enter your email</p>
		        </div>
	        </div>

	        <div class="form-group">
	          <div class="col-sm-12 text-center">
	            <button type="submit" ng-disabled="myForm.$invalid" class="btn btn-primary">Create an account</button>
	          </div>
	        </div>
        </form>
          <hr>
        </div>
      </article>
<script src="/resources/js/checkId.js"></script>
</body>
</html>