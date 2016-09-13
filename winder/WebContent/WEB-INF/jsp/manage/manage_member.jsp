<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header_basic.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_member.jsp" />

<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">Member Management</h4>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<h3>총 회원 수: &nbsp;${membercount }</h3>
		<h3>오늘의 가입자 수: &nbsp;${todayjoin }</h3>
	</div>
</div>
<br><br>
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
		<div class="panel-heading">MEMBER LIST</div>
			<div class="panel-body">
				<div class="table-responsive" style="max-height: 600px;">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>ID</th>
								<th>NAME</th>
								<th>JOIN DATE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${member }" var="member">
								<tr id="${member.id }">
									<td><input type="radio" name="tlno" value="${tllist.tlno }" /></td>
									<td>${member.id }</td>
									<td>${member.name }</td>
									<td>${member.joindate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="col-md-6">
		<div class="panel panel-default">
		<div class="panel-heading">OUT MEMBER LIST</div>
			<div class="panel-body">
				<div class="table-responsive" style="max-height: 600px;">
					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
								<th>JOIN DATE</th>
								<th>OUT DATE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${member }" var="member">
								<tr id="${member.id }">
									<td>${member.id }</td>
									<td>${member.name }</td>
									<td>${member.joindate }</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />