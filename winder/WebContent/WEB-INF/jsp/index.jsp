<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header_basic.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_basic.jsp" />
<form class="rr">
<input type="hidden" name="imgSrc" id="imgSrc" />
<div class="row">
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m1.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m2.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m3.png" style="width: 90%;">
	</div>
</div>
<br><br>
<div class="row">
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m4.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m5.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m6.png" style="width: 90%;">
	</div>
</div>
<input type="button" onclick="capture()">
</form>
<jsp:include page="footer.jsp" />