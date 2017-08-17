<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
					<td>
						<c:set var="image" value="${tmp.imgSrc }"/>
						<c:set var="imageRpic" value="${fn:split(image,'+') }"/>
						<img src="${imageRpic[0]}" style="width:200px; height:150px;" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="row text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${startPageNum ne 1 }">
					<li>
						<a href="roomList.do?checkIn=${checkIn }&checkOut=${checkOut }&pageNum=${startPageNum-1 }">&laquo;</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="disabled">
						<a href="javascript:">&laquo;</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${i eq pageNum }">
						<li class="active">
							<a href="roomList.do?checkIn=${checkIn }&checkOut=${checkOut }&pageNum=${i }">${i }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="roomList.do?checkIn=${checkIn }&checkOut=${checkOut }&pageNum=${i }">${i }</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${endPageNum lt totalPageCount }">
					<li>
						<a href="roomList.do?checkIn=${checkIn }&checkOut=${checkOut }&pageNum=${endPageNum+1 }">&raquo;</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="disabled">
						<a class="muted" href="javascript:">&raquo;</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
</body>
</html>