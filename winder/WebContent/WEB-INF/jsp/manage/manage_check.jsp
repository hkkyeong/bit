<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header_manage.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_check.jsp" />

<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">Check Management</h4>
	</div>
</div>

<div class="row">
	<div class="col-md-8">
	<h4>필터링</h4>
	<c:forEach items="${filter }" var="filter">
		<div class="alert alert-danger" style="float: left; padding: 5px;">
		&nbsp;${filter }&nbsp;
		</div>
	</c:forEach>
	</div>
	<div class="col-md-4">
	<form action="filter">
	<h4>&nbsp; </h4>
	<input type="text" name="fword" style="position: absolute;"/>
	<a href="filter" style="text-align: right; margin: auto; display: block;">
	<button type="submit" class="btn btn-default">추가</button>
	</a>
	<br>
	</form>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
	<div class="panel panel-default">
		<div class="panel-heading">FILE LIST</div>
			<div class="panel-body">
			<form action="">
				<div class="table-responsive" style="max-height: 1000px;">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>TITLE</th>
								<th>FILE NAME</th>
								<th>SIZE(byte)</th>
								<th>ID</th>
								<th>DATE</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${filterfile }" var="file">
								<tr style="background-color: #f2dede">
									<td><input type="radio" name="uno" value="${file.uno }"/></td>
									<td>${file.utitle }</td>
									<td>${file.originalname }</td>
									<td>${file.usize }</td>
									<td>${file.id }</td>
									<td>${file.udate }</td>
								</tr>
							</c:forEach>
							<c:forEach items="${filelist }" var="file">
								<tr>
									<td><input type="radio" name="uno" value="${file.uno }"/></td>
									<td>${file.utitle }</td>
									<td>${file.originalname }</td>
									<td>${file.usize }</td>
									<td>${file.id }</td>
									<td>${file.udate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
					<a href="" style="text-align: right; margin: auto; display: block;">
					<button type="submit" id="my-button" class="btn btn-default" onclick="idsend()">강제 탈퇴</button>
					</a>
				</form>
			</div>
		</div>
	</div>
	
	
</div>

<jsp:include page="footer.jsp" />