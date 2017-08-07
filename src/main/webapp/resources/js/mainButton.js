var getDate = function(){
	return [$("#checkIn").val(), $("#checkOut").val()];
}

var branch = function(checkIn, checkOut){
	if(checkIn == "" && checkOut == ""){
		alert("날짜를 선택해주세요");
	}else if(checkIn == ""){
		alert("체크인 날짜를 선택해주세요");
	}else if(checkOut == ""){
		alert("체크아웃 날짜를 선택해주세요");
	}
}

$("#searchBtn").click(function(){
	var checkIn = getDate()[0];
	var checkOut = getDate()[1];
	branch(checkIn, checkOut);
	if(checkIn != "" && checkOut != ""){
		location.href = "room/roomList.do?checkIn="+checkIn+"&checkOut="+checkOut;
	}
});

$("#cheapBtn").click(function(){
	var checkIn = getDate()[0];
	var checkOut = getDate()[1];
	branch(checkIn, checkOut);
	if(checkIn != "" && checkOut != ""){
		location.href = "room/cheapList.do?checkIn="+checkIn+"&checkOut="+checkOut;
	}
});

$("#popBtn").click(function(){
	var checkIn = getDate()[0];
	var checkOut = getDate()[1];
	branch(checkIn, checkOut);
	if(checkIn != "" && checkOut != ""){
		location.href = "room/popularList.do?checkIn="+checkIn+"&checkOut="+checkOut;
	}
});

$("luxuryBtn").click(function(){
	var checkIn = getDate()[0];
	var checkOut = getDate()[1];
	branch(checkIn, checkOut);
	if(checkIn != "" && checkOut != ""){
		location.href = "room/luxuryList.do?checkIn="+checkIn+"&checkOut="+checkOut;
	}
});
