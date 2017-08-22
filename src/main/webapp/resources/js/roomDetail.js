function showRoom(obj){
	var roomSeq = $(obj).attr("data-seq");
	$.ajax({
		url:"detail.do",
		method:"get",
		data:{roomSeq:roomSeq},
		success:function(data){
			$(".carousel-inner>input").attr('value', roomSeq);
			$(".modal-title").text(data.dto.roomName);
			var roomImg = data.dto.imgSrc.split('+');
			$(".room").attr('src', roomImg[0]);
			$(".bath").attr('src', roomImg[1]);
			$(".living").attr('src', roomImg[2]);
			$(".description").text(data.dto.roomDesc);
			// modal 띄우기
			$("#myModal").modal('show');
		}
	})
}

// URL 쿼리스트링을 파싱하여 JSON 형태로 리턴
function getUrlParams() {
	// 쿼리스트링 받아오기
	// var queryString = window.location.search;
    var params = {};
    window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str, key, value) { params[key] = value; });
    return params;
}

function reservation(){
	var roomSeq = $('.carousel-inner>input').attr("value");
	var params = getUrlParams();
	console.log(params);
	location.href = "/reservation/reservationForm.do?roomSeq="+roomSeq
			+"&checkIn="+params.checkIn
			+"&checkOut="+params.checkOut;
}