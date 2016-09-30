<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="winder.vo.TeamVO"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />


 

<div class="row">
	<div class="col-md-6">
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">File Upload List</div>
			<div class="panel-body">
				<form action="">
						<table class="table">
							<thead>
								<tr>
									<th>No</th>
									<th>Name</th>
									<th>size</th>
									<th>date</th>
								</tr>
							</thead>
							<tbody id="div1">
								<c:forEach items="${list }" var="list" varStatus="index">
									<tr>
										<td>${index.count }</td>
										<td><a href="uploadDetail?uno=${list.UNO}&storedname=${list.STOREDNAME}">${list.ORIGINALNAME }</a></td>
										<td>${list.USIZE }</td>
										<td>${list.UDATE}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />