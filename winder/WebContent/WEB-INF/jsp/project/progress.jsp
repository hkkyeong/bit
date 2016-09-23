<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />

<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">progress</h4>
	</div>
	<div class="col-md-12">
		<a href="todomanagepage?pno=${pno }"
			style="text-align: right; margin: auto; display: block;">
			<h4>to do list 관리 -></h4>
		</a>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<br>
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">TO DO</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Dead Line</th>
								<th>Title</th>
								<th>Content</th>
								<th>ID</th>
							</tr>
						</thead>
						<tbody ondrop="drop(this, event);" ondragenter="return false;"
							ondragover="return false;">
							<tr draggable="true" id="tr1"
								ondragstart="drag(this, event); tlnosend($(this));">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<c:forEach items="${todo }" var="todo">
								<c:if test="${todo.state eq '1' }">
									<tr draggable="true" id="${todo.tlno }"
										ondragstart="drag(this, event); tlnosend($(this));">
										<td>${todo.tldate }</td>
										<td>${todo.title }</td>
										<td>${todo.content }</td>
										<td>${todo.id }</td>
									</tr>
								</c:if>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-6">
		<br>
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">DONE</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Dead Line</th>
								<th>Title</th>
								<th>Content</th>
								<th>ID</th>
							</tr>
						</thead>
						<tbody ondrop="drop2(this, event);" ondragenter="return false;"
							ondragover="return false;">
							<tr draggable="true" id="tr2"
								ondragstart="drag2(this, event); tlnosend($(this));">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<c:forEach items="${todo }" var="todo">
								<c:if test="${todo.state eq '2' }">
									<tr draggable="true" id="${todo.tlno }"
										ondragstart="drag2(this, event); tlnosend($(this));">
										<td>${todo.tldate }</td>
										<td>${todo.title }</td>
										<td>${todo.content }</td>
										<td>${todo.id }</td>
									</tr>
								</c:if>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<!-- Donut chart -->
		<div class="panel panel-default">
			<div class="panel-heading">DONUT CHART</div>
			<h4 id="per">&nbsp;&nbsp;&nbsp;진행률: ${per } %</h4>

			<div class="box-body">
				<div id="donut-chart" style="height: 300px;"></div>
				<br>
			</div>
			<!-- /.box-body-->
		</div>
	</div>





	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">TO DO PROGRESS BARS</div>
			<div class="panel-body" id="progressbar">
				<div class="alert alert-danger">
					<strong>기간 지난 목록</strong><br>
					<table class="table" id="pasttable">
						<c:forEach items="${past}" var="past">
							<c:if test="${past.state eq '1' }">
								<tr>
									<td style="border-top: none;">${past.title }</td>
									<td style="border-top: none;">${past.content }</td>
									<td style="border-top: none;">${past.tldate }</td>
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</div>
				<div class="alert alert-info">
					<strong>7일 이내의 기간이 남은 목록</strong><br>
					<table class="table" id="ddaytable">
						<c:forEach items="${dday}" var="dday">
							<c:if test="${dday.state eq '1' }">
								<tr>
									<td style="border-top: none;">${dday.title }</td>
									<td style="border-top: none;">${dday.content }</td>
									<td style="border-top: none;">${dday.tldate }</td>
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>


</div>

<jsp:include page="../footer_todo.jsp" />