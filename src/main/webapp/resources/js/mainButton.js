function getCurrentDate() {
	var d = new Date();

	return leadingZeros(d.getFullYear(), 4) + '.' +
	    leadingZeros(d.getMonth() + 1, 2) + '.' +
	    leadingZeros(d.getDate(), 2);
}

function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();

	if (n.length < digits) {
    for (i = 0; i < digits - n.length; i++)
      zero += '0';
	}
	return zero + n;
}

var checkDate = function(checkIn, checkOut){
	if(checkIn == "" && checkOut == ""){
		alert("날짜를 선택해주세요");
		return;
	}else if(checkIn == ""){
		alert("체크인 날짜를 선택해주세요");
		return;
	}else if(checkOut == ""){
		alert("체크아웃 날짜를 선택해주세요");
		return;
	}else if(checkIn != "" && checkOut != ""){
		if(checkIn < getCurrentDate() || checkOut < getCurrentDate()){
			console.log(getCurrentDate())
			alert("현재 날짜보다 너무 이릅니다");
			$("#checkIn").val('');
			$("#checkOut").val('');
			return;
		}

		if(checkIn >= checkOut){
			alert("날짜를 재설정 해주세요");
			$("#checkIn").val('');
			$("#checkOut").val('');
			return;
		}
	}
	return true;
}

function showRoom(obj){
	var clickType = $(obj).attr("data-type");
	var checkIn = $("#checkIn").val();
	var checkOut = $("#checkOut").val();
	var isOk = checkDate(checkIn, checkOut);
	if(isOk){
		if(clickType == "all"){
			location.href = "room/roomList.do?checkIn="+checkIn+"&checkOut="+checkOut;
		}else if(clickType == "cheap"){
			location.href = "room/cheapList.do?checkIn="+checkIn+"&checkOut="+checkOut;
		}else if(clickType == "pop"){
			location.href = "room/popularList.do?checkIn="+checkIn+"&checkOut="+checkOut;
		}else if(clickType == "luxe"){
			location.href = "room/luxuryList.do?checkIn="+checkIn+"&checkOut="+checkOut;
		}
	}
}
