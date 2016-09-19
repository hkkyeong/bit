<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_community.jsp" />
<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">community</h4>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-success">
			<div class="panel-heading">Project</div>
			<div class="panel-body">
			<a href="todo?pno=${pno }"><img src="img/pic01.png" style=" width: 100%;"></a> 
			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
</div>

<jsp:include page="../footer.jsp" />