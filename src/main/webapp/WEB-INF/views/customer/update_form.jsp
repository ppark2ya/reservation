<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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
        	<h2>Modify your information</h2>
        </div>
        <form action="update.do" method="post" id="myForm" class="form-horizontal">
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
	        <div class="form-group">
	          <label class="col-sm-3 control-label" for="pwd">Password</label>
		        <div class="col-sm-6">
		        	<input class="form-control" value="${dto.pwd }" id="pwd" name="pwd" type="password" placeholder="Enter your password">
		        	<p class="help-block">Use at least one lowercase letter, one numeral, and seven characters.</p>
		        </div>
	        </div>
	        <div class="form-group">
	          <label class="col-sm-3 control-label" for="pwd2">Password</label>
		        <div class="col-sm-6">
		        	<input class="form-control" value="${dto.pwd }" id="pwd2" name="pwd2" type="password" placeholder="re-Enter your password">
		        	<p class="help-block">Use at least one lowercase letter, one numeral, and seven characters.</p>
		        </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-3 control-label" for="phone">Phone number</label>
	          	<div class="col-sm-6">
	            	<input class="form-control" value="${dto.phone }" id="phone" name="phone" type="text" placeholder="Enter your phone number">
	            	<span class="glyphicon glyphicon-ok form-control-feedback"></span>
		          	<p class="help-block">Please re-enter your phone number</p>
	          	</div>
	        </div>
	       <div class="form-group">
	          <label class="col-sm-3 control-label" for="email">Email Address</label>
		        <div class="col-sm-6">
		          <input class="form-control" value="${dto.email }" id="email" name="email" type="email" placeholder="Enter your email address">
		          <span class="glyphicon glyphicon-ok form-control-feedback"></span>
		          <p class="help-block">Please re-enter your email</p>
		        </div>
	        </div> 

	        <div class="form-group">
	          <div class="col-sm-12 text-center">
	            <button type="submit" id="join" class="btn btn-info">Modify your info</button>
	          </div>
	        </div>
        </form>
          <hr>
        </div>
      </article>
<script>
	// 이메일을 검증할 정규표현식
	var reg = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	// 이메일 검증 통과 여부
	var isEmailValid = false;

	// 전화번호를 검증할 정규 표현식
	var reg2 = /^\d{3}-\d{3,4}-\d{4}$/;
	// 전화번호 검증 통과 여부
	var isNumberValid = false;

//    	$('#myForm').on('submit', function(){
//    		// 이메일 형식이 유효하지 않으면 
//    		if(!isEmailValid && !isNumberValid){
//    			// 폼전송 막기
//    			return false;
//    		}
//    	});
   	
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

   	$('#email').keyup(function(){
   		// 입력한 이메일을 읽어온다.
   		var inputEmail = $(this).val();

   		// 정규표현식으로 검증한다..
   		if(reg.test(inputEmail)){
   			// 성공 상태 표시하기
   			makeSuccess($(this));
   			isEmailValid = true;
   		}else{
   			// 실패 상태 표시하기
   			makeError($(this));
   			isEmailValid = false;
   		}

   		changeButtonState();
   	});

   	$('#phone').keyup(function(){
   		// 입력한 전화번호를 읽어온다.
   		var inputNumber = $(this).val();

   		// 정규표현식으로 검증한다.
   		if(reg2.test(inputNumber)){
   			makeSuccess($(this));
   			isNumberValid = true;
   		}else{
   			makeError($(this));
   			isNumberValid = false;
   		}
   		changeButtonState();
   	});

	function changeButtonState(){
		if(isEmailValid && isNumberValid){
			$('#join')
			.removeAttr('disabled');
		}else{
			$('#join')
			.attr('disabled', 'disabled');
		}
	}
   	// 성공 상태를 나타내주는 함수
	// .find() : 자식요소에서 해당되는 것을 찾음
		// .next() : $() 요소의 다음 요소
	function makeSuccess($elem){
		$elem		//input 요소
		// span 요소
		.next()
		.removeClass('glyphicon-remove')
		.addClass('glyphicon-ok')
		.show()
		// div 요소
		.parent()
		.removeClass('has-error')
		.addClass('has-success')
		// p 요소
		.find('.help-block')
		.hide();
	}

	// 실패 상태를 나타내주는 함수
	function makeError($elem){
		$elem		//input 요소
		// span 요소
		.next()
		.removeClass('glyphicon-ok')
		.addClass('glyphicon-remove')
		.show()
		// div 요소
		.parent()
		.removeClass('has-success')
		.addClass('has-error')
		// p 요소
		.find('.help-block')
		.show();
	}
</script>
</body>
</html>