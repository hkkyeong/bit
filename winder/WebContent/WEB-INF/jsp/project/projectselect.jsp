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
	<%
	if(request.getAttribute("plist")==null){
	%>
	<c:forEach items="${projectmenu }" var="projectmenu">
		<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">${projectmenu.name }</div>
			<div class="panel-body">
			<a href="projectmain?pno=${projectmenu.pno }"><img src="img/pic01.png" style=" width: 100%;"></a> 

			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
	</c:forEach>
	<%}else{ %>
	<c:forEach items="${plist }" var="plist">
		<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">${plist.name }</div>
			<div class="panel-body">
			<a href="projectmain?pno=${plist.pno }"><img src="img/pic01.png" style=" width: 100%;"></a> 

			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
	</c:forEach>
	<%} %>
</div>
<jsp:include page="../footer.jsp" />