<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />
<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">project management</h4>
	</div>
</div>
<div class="row">
<div class="col-md-12">
	<div class="alert alert-info">
		<strong>NAME :</strong>
		${p.name }<br>
		<strong>CONTENT :</strong>
		${p.content }<br>
		<strong>EXPIRE DATE :</strong>
		${p.exdate }<br>
	</div>
</div>

</div>

<jsp:include page="../footer.jsp" />