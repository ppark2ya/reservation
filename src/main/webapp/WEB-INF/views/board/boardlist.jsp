<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../myResource.jsp"></jsp:include>
<title>board/boardlist.jsp</title>
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
	.center{
		text-align: center;
	}
	#list{
		margin-top: 50px;
	}
	a{
		text-decoration: none !important;
	}
	#writeBtn{
		font-size: 10px;
		padding : 2px;
	}
	.page_display a{
		text-decoration:none;
		color: #000;
	}
	.page_display a.active{
		font-weight: bold;
		color: red;
		text-decoration: underline;
	}
	.page_display a.muted{
		color:#cecece;
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
  	<!-- 글쓰기 버튼 처리 -->
    <div class="col-xs-1 col-xs-offset-11">
       	<a class="btn" href="writeform.do">
       		<i id="writeBtn" class="glyphicon glyphicon-pencil" style="font-size:15px;">글쓰기</i>
       	</a>
<!--    <a class="btn" href="#" onClick="sendMsg(); return false;"> -->
<!--        <i id="writeBtn" class="glyphicon glyphicon-pencil" style="font-size:15px;">글쓰기</i> -->
<!--    </a> -->
    </div>

    <table class="table table-hover" id="list">
        <thead>
            <tr>
                <th class="center">번호</th>
                <th class="center">카테고리</th>
                <th class="center">제목</th>
                <th class="center">작성자</th>
                <th class="center">조회수</th>
                <th class="center">작성일</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="tmp" items="${list}">
        		<tr class="text-center">
        			<td>${tmp.boardSeq }</td>
        			<td>${tmp.category }</td>
        			<td>
       					<a href="detail.do?boardSeq=${tmp.boardSeq }&condition=${condition}&keyword=${keyword}">${tmp.title }</a>
        			</td>
        			<td>${tmp.writer }</td>
        			<td>${tmp.viewCount }</td>
        			<td>${tmp.regdate }</td>
        		</tr>
        	</c:forEach>
        </tbody>
    </table>
    <!-- 검색어 관련 form -->
	<div class="row text-center">
		<form action="boardlist.do" method="post" style="margin:0;">
			<label for="condition">검색조건</label>
			<select name="condition" id="condition">
				<option value="titlecontent" <c:if test="${condition eq 'titlecontent' }">selected</c:if>>제목+내용</option>
				<option value="title" <c:if test="${condition eq 'title' }">selected</c:if>>제목</option>
				<option value="writer" <c:if test="${condition eq 'content' }">selected</c:if>>작성자</option>
				<option value="category" <c:if test="${condition eq 'category' }">selected</c:if>>카테고리</option>
			</select>
			<input value="${keyword  }" type="text" name="keyword" placeholder="검색어"/>
			<button type="submit">검색</button>
		</form>
	</div>
    <!-- 페이징 처리에 관련된 UI -->
    <div class="row text-center">
	    <ul class="pagination">
			<c:choose>
				<c:when test="${startPageNum ne 1 }">
					<li>
						<a href="boardlist.do?pageNum=${startPageNum-1 }">&laquo;</a>
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
							<a href="boardlist.do?pageNum=${i }">${i }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="boardlist.do?pageNum=${i }">${i }</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${endPageNum lt totalPageCount }">
					<li>
						<a href="boardlist.do?pageNum=${endPageNum+1 }">&raquo;</a>
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
<script>
	var sendMsg = function(){
		alert("로그인 후 이용바랍니다");
		//location.href = "${pageContext.request.contextPath }/customer/signinform.do";
	}
	
</script>
</body>
</html>