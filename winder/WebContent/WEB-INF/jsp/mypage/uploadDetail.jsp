<%@page import="winder.vo.TeamVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_team.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Mypage > File Upload</h1>
	</div>
	Uno : ${map.UNO }<br> 
	id : ${map.ID } <br> 
	<input type="hidden" id="UNO" name="UNO" value="${map.UNO }">
	 <%-- file name :<a href="downloadFile?uno=${map.UNO}&storedname=${map.STOREDNAME}&originalname=${map.ORIGINALNAME}&id=${map.ID}&udate=${map.UDATE}&boardno=${map.BOARDNO}&delfile=${map.DELFILE}&usize=${map.USIZE}" name="file">${map.ORIGINALNAME }</a> (${map.USIZE }kb) --%>
	file name :<a href="#this" name="file">${map.ORIGINALNAME }</a> (${map.USIZE }kb)

</div>

<jsp:include page="../footer.jsp" /> 