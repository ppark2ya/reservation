<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- section start -->
<section style="background: url(${pageContext.request.contextPath }/resources/images/background.jpg) center; background-color:#333;">
	<div class="container clearfix">
		<div class="row">
			<div class="col-md-12">
				<div class="home-search-main heading-block center" style="margin:150px 0px;">
					<div style="font-size:22px; font-weight:bold; color:#fff;"></div>
					<h1 data-animate="fadeInUp" data-delay="200" class="" style="font-size: 80px; color:#fff;">Reserve Your Hotel</h1>
					<span data-animate="fadeInUp" data-delay="300" style="margin-bottom:50px;"><strong style="color:#fff;">Compare prices and deal for over 18000 hotels <br/>All over the World!</strong></span>

					<form action="" id="homeSearch" method="POST">
						<input type="hidden" id="rc-ro" name="rc-ro" value="1" />
						<input type="hidden" id="rc-lo" name="rc-lo" value="" class="rc-cl-lo"/>
						<input type="hidden" id="rc-lt" name="rc-lt" value="" class="rc-cl-lt"/>
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<div class="input-group">
									<input type="text" id="checkIn" name="checkIn" data-val="true" data-val-required=""   value="" class="sm-form-control tleft past-enabled not-dark datepicka" placeholder="Check in date">
									<span class="input-group-addon" style="padding: 9px 12px;">
										<i class="fa fa-calendar" aria-hidden="true"></i>
									</span>
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<input type="text" id="checkOut" name="checkOut" data-val="true" data-val-required=""  value="" class="sm-form-control tleft past-enabled not-dark datepicka" placeholder="Check out date">
									<span class="input-group-addon" style="padding: 9px 12px;">
										<i class="fa fa-calendar" aria-hidden="true"></i>
									</span>
								</div>
							</div>
							<div class="col-md-3"></div>
						</div>
					</form>
					<div class="row">
						<div class="col-12 center">
							<div class="topmargin-sm">
								<div class="btn-group">
									<button type="submit" id="searchBtn" class="btn btn-lg btn-danger" style="margin-right:10px;">Search</button>
									<button type="submit" id="cheapBtn" class="btn btn-lg btn-danger">Cheap</button>
									<button type="submit" id="popBtn" class="btn btn-lg btn-danger">Popular</button>
									<button type="submit" id="luxuryBtn" class="btn btn-lg btn-danger">Luxury</button>
								</div>&nbsp;&nbsp;
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
