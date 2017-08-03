<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<jsp:include page="../myResource.jsp"></jsp:include>
<style>
	.page-header{
		margin-top: 0;
	}
	#headerlogo{
		margin : 50px 0px 0px 0px;
	}
	#myForm .help-block{
		display: none;
	}
	.form-control-feedback{
		display: none;
		padding-right: 15px;
	}
</style>
</head>
<body>
      <article class="container">
        <div class="col-md-12">
        <div class="page-header text-center">
        	<a href="${pageContext.request.contextPath }/home.do">
        		<img src="${pageContext.request.contextPath }/resources/images/reservation.PNG" id="headerlogo">
        	</a>
        </div>
        <form action="signup.jsp" method="post" id="myForm" class="form-horizontal">
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="id">ID</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" value="${sessionScope.id }" id="id" disabled="disabled" type="text">
	          	</div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="name">Name</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" value="${dto.name }" id="name" disabled="disabled" type="text">
	          	</div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="phone">Phone number</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" value="${dto.phone }" id="phone" disabled="disabled" type="text" >
	            	<span class="glyphicon glyphicon-ok form-control-feedback"></span>
		          	<p class="help-block">Please re-enter your phone number</p>
	          	</div>
	        </div>
	       <div class="form-group">
	          <label class="col-sm-3 control-label" for="email">Email Address</label>
		        <div class="col-sm-6">
		          <input class="form-control" value="${dto.email }" id="email" disabled="disabled" type="email">
		          <span class="glyphicon glyphicon-ok form-control-feedback"></span>
		          <p class="help-block">Please re-enter your email</p>
		        </div>
	        </div> 
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="regdate">Regdate</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" value="${dto.regdate }" id="regdate" disabled="disabled" type="text">
	          	</div>
	        </div>

	        <div class="form-group">
	          <div class="col-sm-12 text-center">
	          	<a class="btn btn-info" href="updateform.do">Modify your info</a>
	          	<a class="btn btn-danger" href="#" onclick="dropOut(); return;">Drop out account</a>
	          </div>
	        </div>
        </form>
          <hr>
        </div>
      </article>
<script>
	var dropOut = function(){
		var isDelete = confirm("탈퇴하시겠습니까?");
		if(isDelete){
			location.href = "dropout.do";
		}
	}
</script>
</body>
</html>