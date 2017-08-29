/**
 * 	submit 이벤트 발생시 패스워드 2개가 같은지 확인하는 함수
 */
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