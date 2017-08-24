<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../myResource.jsp"></jsp:include>
<title>/Reservation/reservation_form.jsp</title>
<style>
	.page-header{
		margin-top: 0;
		border-bottom: 0px;
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
<div class="container">
	<div class="page-header text-center">
       	<a href="/home.do">
       		<img src="/resources/images/reservation.PNG" id="headerlogo">
       	</a>
    </div>

    <form method="post" action="resvRoom.do" id="myForm" class="form-horizontal">
    	<input type="hidden" name="roomSeq" value="${roomDto.roomSeq }"/>
    	<input type="hidden" name="checkIn" value="${param.checkIn }"/>
    	<input type="hidden" name="checkOut" value="${param.checkOut }"/>
    	<div class="form-group has-feedback">
            <label class="col-sm-3 control-label" for="payment">Payment</label>
          	<div class="col-sm-6">
            	<input class="form-control" id="payment" name="payment" type="text" placeholder="payment(cash or card)">
            	<p class="help-block">can't use this payment</p>
          		<span class="glyphicon form-control-feedback"></span>
          	</div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label" for="numofRvcust">people</label>
	        <div class="col-sm-6">
	        	<input class="form-control" id="numofRvcust" name="numofRvcust" type="text" placeholder="number of people">
	        	<p class="help-block">Less than ${roomDto.availGuest+1 } </p>
          		<span class="glyphicon form-control-feedback"></span>
	        </div>
        </div>

        <div class="form-group">
          <div class="col-sm-12 text-center">
          	<button id="reservationBtn" type="submit" class="btn btn-primary">Reservation</button>
          </div>
        </div>
    </form>
</div>
<script>
	var isNumofRvcustVaild = false;

	$("#payment").keyup(function(){

		var payment = $(this).val();

		$("#payment").parent().removeClass("has-success has-error");
		if(payment == "cash" || payment == "card"){
			$("#payment")
			.parent()
			.addClass("has-success")
			.find(".help-block")
			.hide()
			.parent()
			.find(".glyphicon")
			.removeClass("glyphicon-remove")
			.addClass("glyphicon-ok");
		}else{
			$("#payment")
			.parent()
			.addClass("has-error")
			.find(".help-block")
			.show()
			.parent()
			.find(".glyphicon")
			.removeClass("glyphicon-ok")
			.addClass("glyphicon-remove");
		}
	});

	$("#numofRvcust").keyup(function(){
		var inputNum = $(this).val();
		var availGuest = ${roomDto.availGuest};
		if(inputNum <= availGuest && inputNum != 0 && inputNum != ""){
			makeSuccess($(this));
			isNumofRvcustVaild = true;
		}else{
			makeError($(this));
			isNumofRvcustVaild = false;
		}
		changeButtonState();
	});

	function changeButtonState(){
		if(isNumofRvcustVaild){
			$('#reservationBtn')
			.removeAttr('disabled');
		}else{
			$('#reservationBtn')
			.attr('disabled', 'disabled');
		}
	}

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

	$("#myForm").submit(function(){
		if(!isNumofRvcustValid) return false;
	});
</script>
</body>
</html>