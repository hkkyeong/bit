<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header_basic.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_basic.jsp" />
<div class="row">
<div class="form-group" style="background-image:url(img/guest.jpg);height: 400px;" >
	<a href="login" style="text-align: center; margin: auto; display: block; padding-top: 100px;">
		<button type="submit" class="btn btn-default">&nbsp;&nbsp;&nbsp;&nbsp;로그인&nbsp;&nbsp;&nbsp;&nbsp;</button>
	</a>
	<br>
	<a href="signupForm" style="text-align: center; margin: auto; display: block;">
		<button type="submit" class="btn btn-default">&nbsp;&nbsp;회원가입&nbsp;&nbsp;</button>
	</a>
</div>
</div>


<jsp:include page="footer.jsp" />