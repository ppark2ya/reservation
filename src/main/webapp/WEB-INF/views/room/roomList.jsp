<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../myResource.jsp"></jsp:include>
<title>views/room/roomList.jsp</title>
<style>
	.page-header{
		margin-top: 0;
		border-bottom: 0px;
	}
	#headerlogo{
		margin : 50px 0px 0px 0px;
	}
	.topics td{
		height: 100px;
	}
</style>
</head>
<body>
<div class="container">
	<div class="page-header text-center">
       	<a href="../home.do">
       		<img src="${pageContext.request.contextPath }/resources/images/reservation.PNG" id="headerlogo">
       	</a>
    </div>
   <table class="table table-hover">
	   <thead>
	   		<tr>
				<th>객실번호</th>
				<th>객실이름</th>
				<th>객실요금</th>
				<th>객실설명</th>
				<th>이용가능인원</th>
				<th>흡연여부</th>
				<th>세면도구여부</th>
				<th>무료와이파이</th>
				<th>조식여부</th>
			</tr>
		</thead>
		<tbody class="topics">
			<c:forEach var="tmp" items="${rooms }">
				<tr class="text-center">
					<td>${tmp.roomSeq }</td>
					<td>${tmp.roomName }</td>
					<td>${tmp.roomCharge }</td>
					<td>${tmp.roomDesc }</td>
					<td>${tmp.availGuest }</td>
					<td>${tmp.smokingYn }</td>
					<td>${tmp.bathAmenityYn }</td>
					<td>${tmp.wifiFreeYn }</td>
					<td>${tmp.breakfastYn }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>