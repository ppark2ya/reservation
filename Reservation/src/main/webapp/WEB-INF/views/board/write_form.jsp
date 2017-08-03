<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../myResource.jsp"></jsp:include>
<script src="${pageContext.request.contextPath }/SmartEditor/js/HuskyEZCreator.js"></script>
<style>
	.page-header{
		margin-top: 0;
		border-bottom: 0px;
	}
	#headerlogo{
		margin : 50px 0px 0px 0px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="page-header text-center">
       	<a href="${pageContext.request.contextPath }/home.do">
       		<img src="${pageContext.request.contextPath }/resources/images/reservation.PNG" id="headerlogo">
       	</a>
    </div>
	<form action="write.do" method="post" id="myForm">
		<table style="width:100%">
			<tr>
				<td><label for="category">카테고리</label></td>
				<td>
					<select name="category" id="category">
						<option value="ticket" selected="selected">ticket</option>
						<option value="hotel">hotel</option>
						<option value="rent">rent</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" id="title" name="title" style="width:500px;"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" id="content" cols="100" rows="10" style="width:756px; height:412px;"></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="button" id="saveBtn" value="저장" />
					<input type="button" id="cancleBtn" value="취소" />
				</td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "content",
		//SmartEditor2Skin.html 파일이 존재하는 경로
		sSkinURI : "${pageContext.request.contextPath}/SmartEditor/SmartEditor2Skin.html",
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,
			fOnBeforeUnload : function() {
			}
		},
		fOnAppLoad : function() {
		//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
			oEditors.getById["content"].exec("PASTE_HTML", [ "" ]);
		},
		fCreator : "createSEditor2"
	});
	
	//네이버 에디터 작성 데이터 전송하기 
	$("#saveBtn").click(function() {
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		// 에디터의 내용이 textarea에 적용됩니다.
		
		// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
		$("#myForm").submit();
	});
	
	$("#cancleBtn").click(function(){
		location.href="../boardlist.do";
	})
		
// 		$("#submitModifyBoardBtn").click(function() {
// 			oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
// 		});

</script>
</body>
</html>