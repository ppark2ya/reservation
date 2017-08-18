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
	.carousel-inner > .item > img{
	 	margin : 0 auto;
 		text-align: center;
    	display: block;
    	max-width: 100%;
    	height: 600px !important;

/* 		width : 500px; */
/* 		height: 200px; */
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
	   			<th></th>
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
					<td>
						<c:set var="image" value="${tmp.imgSrc }"/>
						<c:set var="imageRpic" value="${fn:split(image,'+') }"/>
						<img class="roomImg" src="${imageRpic[0]}" style="width:200px; height:150px;" />
					</td>
					<td>${tmp.roomSeq }</td>
					<td><a href="javascript:" onClick="showRoom(this); return false;" data-seq=${tmp.roomSeq }>${tmp.roomName }</a></td>
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
<!-- modal -->
<div class="modal fade" id="myModal">
	<!-- modal-lg  | default | modal-sm -->
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span>&times;</span><span class="sr-only">close</span></button>
        <h4 class="modal-title">모달의 제목</h4>
      </div>
      <div class="modal-body">
      	<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="1500">
			<!-- Carousel 하단의 동그란 nav 요소 -->
			<ol class="carousel-indicators">
				<!-- data-target="Carousel 전체의 선택자" -->
				<!-- data-slide-to="컨텐츠 인덱스" -->
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner text-center">
				<div class="item active">
					<img class="room" src=""/>
				</div>
				<div class="item">
					<img class="bath" src=""/>
				</div>
				<div class="item">
					<img class="living" src=""/>
				</div>
			</div>
			<!-- 이전, 다음 control UI -->
			<a href="#myCarousel" class="left carousel-control" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">이전</span>
			</a>
			<a href="#myCarousel" class="right carousel-control" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">다음</span>
			</a>
		</div>
        <p class="description">모달의 내용</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Reservation</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
	function showRoom(obj){
		var roomSeq = $(obj).attr("data-seq");
		$.ajax({
			url:"detail.do",
			method:"get",
			data:{roomSeq:roomSeq},
			success:function(data){
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
</script>
</body>
</html>