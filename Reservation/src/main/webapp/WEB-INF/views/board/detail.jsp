<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/view.jsp</title>
<jsp:include page="../myResource.jsp"></jsp:include>
<style>
	.page-header{
		margin-top: 0;
	}
	#headerlogo{
		margin : 50px 0px 50px 0px;
	}
	#myForm .help-block{
		display: none;
	}
	#myForm{
		height:500px;
	}
	.form-control-feedback{
		display: none;
		padding-right: 15px;
	}
	.col-md-12{
		padding: 0;
	}
	.box{
		border: 1px solid #808080;
	}
	span{
		display: inline-block;
		border-right: 1px solid #cecece;
	}
	hr{
		margin-top: 0;
	}
	.comment textarea{
		width:80%;
		background-color: #fff;
	}
	.comment form{
		display: none;
	}
	.comment{
		position: relative;
	}
	.comment .reply_icon{
		position: absolute;
		width: 20px;
		height: 20px;
		top:0;
		left:-20px;
		border-left: 2px solid green;
		border-bottom: 2px solid green;
	}
	.boardBtn{
		margin-top: 20px;
	}
</style>
</head>
<body>
<article class="container">
	<div class="col-md-12">
		<div class="text-center">
			<a href="${pageContext.request.contextPath }/home.do">
				<img src="${pageContext.request.contextPath }/resources/images/reservation.PNG" id="headerlogo">
			</a>
		</div>
		<a href="boardlist.do">
			<div class="col-xs-offset-11">
				목록<i class="fa fa-list" aria-hidden="true"></i>
			</div>
		</a>
		<form action="articleView" method="post" id="myForm" class="box form-horizontal">
			<div class="form-group" style="margin-bottom:0;">
				<div class="padd col-md-12 text-center">
					<span class="col-xs-4">${dto.title }</span>
					<span class="col-xs-2">${dto.category }</span>
					<span class="col-xs-3">${dto.writer }</span>
					<span class="col-xs-3" style="border-right:0px;">${dto.regdate }</span>
				</div>
			</div>
			<hr align="center"/>
			<div class="form-group">
				<div style="padding-left:20px;">${dto.content }</div>
			</div>	
		</form> 
		
		<!-- 댓글 UI -->
		<div class="comments">
			<c:forEach var="tmp" items="${commentList }">
				<div class="comment" <c:if test="${tmp.boardSeq ne tmp.commentGroup }">style="margin-left:100px"</c:if> >	
					<c:if test="${tmp.boardSeq ne tmp.commentGroup }">
						<div class="reply_icon"></div>
					</c:if>
					<div>		
						<strong>from ${tmp.writer }</strong>
						${tmp.regdate }<br/>
						<strong>to ${tmp.targetId }</strong>
						<a href="javascript:">답글</a>
					</div>
					<textarea rows="5" disabled>${tmp.content }</textarea><br/>
					<form action="comment_insert.do" method="post">
						<!-- 덧글 작성자 -->
						<input type="hidden" name="writer" value="${id }"/>
						<!-- 덧글 그룹 -->
						<input type="hidden" name="refGroup" value="${dto.boardSeq }" />
						<!-- 덧글 대상 -->
						<input type="hidden" name="targetId" value="${tmp.writer }" />
						<input type="hidden" name="commentGroup" value="${tmp.commentGroup }" />
						<textarea name="content"></textarea>
						<button type="submit">등록</button>
					</form>
				</div>
				
			</c:forEach>
		
			<div class="comment_form">
				<form action="comment_insert.do" method="post">
					<!-- 덧글 작성자 -->
					<input type="hidden" name="writer" value="${id }"/>
					<!-- 덧글 그룹 -->
					<input type="hidden" name="refGroup" value="${dto.boardSeq }" />
					<!-- 덧글 대상 -->
					<input type="hidden" name="targetId" value="${dto.writer }" />
					<textarea name="content"></textarea>
					<button type="submit">등록</button>
				</form>
			</div>
		</div>
		<!-- button UI -->
		<c:if test="${sessionScope.id eq dto.writer }">
			<div class="boardBtn">
		    	<div class="col-sm-12 text-center">
		        	<a class="btn btn-info" href="members/updateform.do?board_num=${dto.board_num }&writer=${dto.writer}&title=${dto.title}&content=${dto.content}">Modify</a>
		          	<a class="btn btn-danger" href="#" onclick="dropOut(); return;">Delete</a>
		        </div>
			</div>
		</c:if>
	</div>
</article>
<script>
	var isLogin=${isLogin};
	
	//덧글 전송 이벤트가 일어 났을때 실행할 함수 등록 
	$(".comment_form > form, .comment form").submit(function(){
		if(!isLogin){//만일 로그인 하지 않았다면 
			alert("로그인이 필요 합니다.");
			//로그인 페이지로 이동 
			location.href="${pageContext.request.contextPath}"+
			"/customer/signinform.do"+
			"?url=${pageContext.request.contextPath}"+
			"/board/detail.do?boardSeq=${dto.boardSeq}";
			
			return false; //폼전송 막기 
		}
	});
	
	//덧글 달기 혹은 취소 버튼을 눌렀을때 실행할 함수 등록 
	$(".comment a").click(function(){
		if($(this).text()=="답글"){
			$(this)
			.text("취소")
			.parent()
			.parent()
			.find("form")
			.slideToggle();	
		}else{
			$(this)
			.text("답글")
			.parent()
			.parent()
			.find("form")
			.slideToggle();
		}
	});
	var dropOut = function(){
		var isDelete = confirm("삭제하시겠습니까?");
		if(isDelete){
			location.href = "delete.do?boardSeq=${dto.boardSeq}";
		}
	}
</script>
</body>
</html>