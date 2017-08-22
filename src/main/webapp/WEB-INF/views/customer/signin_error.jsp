<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	alert("아이디 혹은 패스워드가 잘못되었습니다.");
	if("${param.url}" == ""){
		location.href = "signinform.do";
	}else if("${param.url}" == "/board/writeform.do"){
		location.href = "signinform.do?url=${param.url}";
	}else if("${param.url}" == "/board/detail.do"){
		location.href = "signinform.do?url=${param.url}&boardSeq=${param.boardSeq}&keyword=${param.keyword}&condition=${param.condition}";
	}else if("${param.url}" == "/reservation/reservationForm.do"){
		location.href = "signinform.do?url=${param.url}&roomSeq=${param.roomSeq}&checkIn=${param.checkIn}&checkOut=${param.checkOut}";
	}
</script>