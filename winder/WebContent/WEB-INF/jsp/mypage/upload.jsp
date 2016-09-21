<%@page import="winder.vo.TeamVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_team.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Mypage > File Upload</h1>
	</div>
	<form action="upload">
	<input type="file" name="upload">
	</form>
</div>

<jsp:include page="../footer.jsp" />