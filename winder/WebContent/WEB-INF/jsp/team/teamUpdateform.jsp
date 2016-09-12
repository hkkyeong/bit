<%@page import="winder.vo.TeamVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_team.jsp" />

<%
int tno =Integer.parseInt(request.getParameter("tno"));
request.setAttribute("tno",tno);
System.out.println(tno);
%>
<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Team create Form</h1>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">Team create</div>
			<div class="panel-body">
				<form action="teamUpdate?tno=${tno }" method="post"	enctype="multipart/form-data">
					<div class="form-group">
						<label for="exampleInputEmail1">Team name</label> 
						<input	type="text" class="form-control" name="name" id="name" placeholder="Input teamname" />
					</div>

					<div class="form-group">
						<label for="exampleInputFile">Team Img</label> <input type="file" name="timg" />
					</div>
					<button type="submit" class="btn btn-default">Update</button>
				</form>
			</div>
		</div>
	</div>

</div>

<jsp:include page="../footer.jsp" />