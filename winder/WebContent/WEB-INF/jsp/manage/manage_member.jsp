<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header_manage.jsp" />
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
			<form action="">
				<div class="table-responsive" style="max-height: 1000px;">
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
							<c:forEach items="${member }" var="member" varStatus="status">
								<tr id="${member.id }">
									<c:if test="${status.index eq 0 }">
									<td><input type="radio" name="id" value="${member.id }" checked/></td>
									</c:if>
									<c:if test="${status.index ne 0 }">
									<td><input type="radio" name="id" value="${member.id }"/></td>
									</c:if>
									<td>${member.id }</td>
									<td>${member.name }</td>
									<td>${member.joindate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
					<a href="" style="text-align: right; margin: auto; display: block;">
					<button type="submit" id="my-button" class="btn btn-default" onclick="idsend(${id}, )">강제 탈퇴</button>
					</a>
				</form>
			</div>
		</div>
	</div>
	
	<div class="col-md-6">
		<div class="panel panel-default">
		<div class="panel-heading">OUT MEMBER LIST</div>
			<div class="panel-body">
				<div class="table-responsive" style="max-height: 1000px;">
					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
								<th>JOIN DATE</th>
								<th>OUT DATE</th>
								<th>REASON</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${outmember }" var="outmember">
								<tr id="${outmember.id }">
									<td>${outmember.id }</td>
									<td>${outmember.name }</td>
									<td>${outmember.joindate }</td>
									<td>${outmember.outdate }</td>
									<td>${outmember.reason }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="element_to_pop_up">
<div class="b-close" style="color: #000;">x</div>
<form action="memberout" id="out">

</form>
</div>

<jsp:include page="footer_manage.jsp" />