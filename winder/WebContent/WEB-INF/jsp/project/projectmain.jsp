<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />
<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">project</h4>
	</div>
</div>
<div class="row">
	<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">Project</div>
			<div class="panel-body">
			<a href="todo?pno=${pno }"><img src="img/pic01.png" style=" width: 100%;"></a> 
			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
	<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">Project Management</div>
			<div class="panel-body">
			<a href="projectmanage?pno=${pno }"><img src="img/pic02.png" style=" width: 100%;"></a> 
			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
	<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">Sharing Data</div>
			<div class="panel-body">
			<a href="sharedscrapList?pno=${pno }"><img src="img/pic03.png" style=" width: 100%;"></a> 

			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
</div>

<jsp:include page="../footer.jsp" />