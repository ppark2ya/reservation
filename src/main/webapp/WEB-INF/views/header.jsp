<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container" style="padding:0; margin-bottom:30px;">
	<div class="hideMenu">
		<div></div>
		<div></div>
		<div></div>
	</div>
	<div id="hideLogo" class="col-xs-6 col-xs-offset-3">
		<a href="home.do">
			<img src="/resources/images/reservation.PNG" alt="" />
		</a>
	</div>
	<div class="header">
		<div id="headerlogo" class="col-xs-5">
			<a href="home.do">
				<img src="${pageContext.request.contextPath }/resources/images/reservation.PNG" alt="" />
			</a>
		</div>
		<div class="col-xs-2"></div>
		<div id="topRightMenu" class="col-xs-5 text-center">
			<ul class="menu">
				<li class="subMenu">
					<a href="board/boardlist.do">
						<div class="menuBtn">Q&amp;A</div>
					</a>
				</li>

				<c:if test="${empty sessionScope.id }">
					<li class="signup">
						<a href="customer/signupform.do">
							<div class="menuBtn">SIGN UP</div>
						</a>
					</li>
					<li class="signin">
						<a href="customer/signinform.do">
							<div class="menuBtn">SIGN IN</div>
						</a>
					</li>
				</c:if>

				<c:if test="${not empty id }">
					<li class="signout">
						<a href="customer/signout.do">
							<div class="menuBtn">SIGN OUT</div>
						</a>
						<a href="customer/mypage.do">
							<i class="glyphicon glyphicon-user"></i>
						</a>
					</li>
				</c:if>

			</ul>
		</div>
	</div>
</div>