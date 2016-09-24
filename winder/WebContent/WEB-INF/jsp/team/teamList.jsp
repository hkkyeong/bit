<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="winder.vo.TeamVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />
<div class="row">   

<!-- <a href="scrapForm">sc</a>
<a href="scrap1">sc1</a>  -->

	<div class="col-md-12">
		<h4 class="page-head-line">Team List</h4>
		
		<div class="col-md-4 col-sm-4"	style="padding-left: 30px; padding-right: 30px;">
			<div class="panel panel-success">
				<div class="panel-heading">
					<a href="teamCreateform">팀 신청</a>
			 	</div>
				<br> <br> <br> <br> <br>
				<div class="panel-body"></div>
				<br><br>
				<div class="panel-footer">&nbsp;</div>
			</div>
		</div>

		<c:forEach items="${teamList}" var="members">
			<div class="col-md-4 col-sm-4" style="padding-left: 30px; padding-right: 30px;">
				<div class="panel panel-success">
					<div class="panel-heading">
						<a href="projectlist?tno=${members.tno }">${members.name}</a>
					</div>  
					<div class="panel-body"><img src="img/${members.timg}" style=" width: 100%;"> 
					</div>
					<div class="panel-footer">
					<center>
						<a href="teamDelete?tno=${members.tno}">삭제 </a> 
						<a href="teamUpdateform?tno=${members.tno}">수정 </a>
					</center>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<jsp:include page="../footer.jsp" />