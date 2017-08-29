<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app>
<head>
<meta charset="UTF-8">
<title>update your info</title>
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
<body>
      <article class="container">
        <div class="col-md-12">
        <div class="page-header text-center">
        	<a href="/home.do">
        		<img src="/resources/images/reservation.PNG" id="headerlogo">
        	</a>
        	<h2>Modify your information</h2>
        </div>
        <form action="update.do" method="post" id="myForm" class="form-horizontal" name="myForm" novalidate>
        	<div class="form-group">
	            <label class="col-sm-3 control-label" for="id">ID</label>
	          	<div class="col-sm-6">
	            	<input class="form-control hidden" id="id" name="id" value="${dto.id }" type="text">
	            	<input class="form-control" value="${dto.id }" name="id" type="text" disabled="disabled">
	          	</div>
	        </div>
	       	<div class="form-group">
	            <label class="col-sm-3 control-label" for="name">Name</label>
	          	<div class="col-sm-6">
	            	<input class="form-control hidden" id="name" name="name" value="${dto.name }" type="text">
	            	<input class="form-control" value="${dto.name }" name="name" type="text" disabled="disabled">
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
		        	<p class="help-block" ng-show="myForm.pwd.$invalid && myForm.pwd.$dirty ">Use at least one special letter, one numeral, and six characters.</p>
		        </div>
	        </div>
	        <div class="form-group has-feedback"
	        	ng-class="{'has-success':myForm.pwd2.$valid, 'has-error':myForm.pwd2.$invalid && myForm.pwd2.$dirty}">
	          <label class="col-sm-3 control-label" for="pwd2">Password</label>
		        <div class="col-sm-6">
		        	<input class="form-control" id="pwd2" name="pwd2" type="password" placeholder="re-Enter your password"
		        		ng-model="pwd2"
						ng-required="true"
						ng-pattern="/^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{6,20}$/">
		        	<p class="help-block" ng-show="myForm.pwd.$invalid && myForm.pwd.$dirty ">Use at least one special letter, one numeral, and six characters.</p>
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
	          	<button type="submit" ng-disabled="myForm.$invalid" class="btn btn-primary">Modify your info</button>
	          </div>
	        </div>
        </form>
          <hr>
        </div>
      </article>
<script src="/resources/js/equalPwd.js"></script>
</body>
</html>