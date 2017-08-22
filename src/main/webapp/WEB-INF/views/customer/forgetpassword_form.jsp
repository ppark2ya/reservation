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
	#myForm .help-block{
		display: none;
	}
	.form-control-feedback{
		display: none;
		padding-right: 15px;
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
		<c:if test="${empty param.url }">
			<form action="resetpassword.do" method="post" id="myForm">
		</c:if>
		<c:if test="${param.url eq '/board/writeform.do' }">
			<form action="resetpassword.do?url=${param.url }" method="post" id="myForm">
		</c:if>
		<c:if test="${param.url eq '/board/detail.do' }">
			<form action="resetpassword.do?url=${param.url }&boardSeq=${param.boardSeq}&keyword=${param.keyword}&condition=${param.condition}" method="post" id="myForm">
		</c:if>
		<c:if test="${param.url eq '/reservation/reservationForm.do' }">
			<form action="resetpassword.do?url=${param.url }&roomSeq=${param.roomSeq}&checkIn=${param.checkIn}&checkOut=${param.checkOut}" method="post" id="myForm">
		</c:if>
				<div class="text-center">
					<h2 style="margin-bottom: 30px;">Reset your password</h2>
				</div>
				<div class="box form-group">
					<div class="form-group">
						<label for="inputInfo" class="control-label">Enter your ID and new password</label>
						<input type="text" class="form-control input-block" id="id" name="id" placeholder="Enter your ID">
					</div>
					<div class="form-group">
						<input type="password" class="form-control input-block" id="pwd" name="pwd" placeholder="Reset your password">
		        		<p class="help-block">Use at least one special letter, one numeral, and six characters.</p>
	          			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
					</div>
					<div class="form-group">
						<input type="password" class="form-control input-block" id="pwd2" name="pwd2" placeholder="Re-Enter your password">
		        		<p class="help-block">Use at least one special letter, one numeral, and six characters.</p>
	          			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
					</div>
					<button id="join" type="submit" class="btn btn-primary btn-block" tabindex="3">Send new password</button>
				</div>
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
<script>
	// 비밀번호를 검증할 정규 표현식
	var reg = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{6,20}$/;
	// 비밀번호 검증 통과 여부
	var isPwdValid = false;

	$('#pwd').keyup(function(){
   		// 입력한 비밀번호를 읽어온다.
   		var inputPwd = $(this).val();

   		// 정규표현식으로 검증한다.
   		if(reg.test(inputPwd)){
   			makeSuccess($(this));
   			isPwdValid = true;
   		}else{
   			makeError($(this));
   			isPwdValid = false;
   		}
   		changeButtonState();
   	});

	function changeButtonState(){
		if(isPwdValid){
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

	//아이디 입력란에 keyup 이벤트가 발생했을때 실행할 함수 등록
	$("#id").on("keyup", function(){
		//입력한 아이디 읽어오기
		var inputId=$("#id").val();
		//ajax 요청을 이용해서 서버에 전송
		$.ajax({
			url:"checkid.do",
			method:"get",
			data:{inputId:inputId},

			success:function(data){
				console.log(data);
				$("#id").parent()
				.removeClass("has-success has-error");
				if(!data.canUse){
					$("#id")
					.parent()
					.addClass("has-success")
					.find(".help-block")
					.hide()
					.parent()
					.find(".glyphicon")
					.removeClass("glyphicon-remove")
					.addClass("glyphicon-ok");
				}else{
					$("#id")
					.parent()
					.addClass("has-error")
					.find(".help-block")
					.show()
					.parent()
					.find(".glyphicon")
					.removeClass("glyphicon-ok")
					.addClass("glyphicon-remove");
				}
			}
		});
	});
</script>
</body>
</html>