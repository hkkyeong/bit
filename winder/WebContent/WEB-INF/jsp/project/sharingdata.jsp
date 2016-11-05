<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Sharing Data</h1>
	</div>
</div>
<div class="row">
	<form action="">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">


					<ul class="nav nav-tabs">
						<li class="active"><a href="#scrap2" data-toggle="tab">Scrap</a></li>
						<li class=""><a href="#file2" data-toggle="tab">File</a></li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane fade active in" id="scrap2">
							<br>
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th style="width: 10px;">No</th>
											<th>Title</th>
											<th>Date</th>
											<th>ID</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${sharedscrapList}" var="scrap"
											varStatus="index">
											<tr>
												<td>${index.count }</td>
												<td><a href="scrap1?sno=${scrap.sno }&kind=pro">${scrap.stitle }</a></td>
												<td>${scrap.sdate }</td>
												<td>${scrap.id }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>


						<div class="tab-pane fade" id="file2">
							<br>
							<div class="table-responsive">
								<form action="shareFile">
									<table class="table">
										<thead>
											<tr>
												<th>No</th>
												<th>Title</th>
												<th>Date</th>
												<th>Size</th>
												<th>ID</th>
												<th>Download</th>
											</tr>
										</thead>
										<tbody id="div1">
											<c:forEach items="${sharedFileList}" var="list"
												varStatus="index">
												<tr>
													<td>${index.count }</td>
													<td>${list.originalname}</td>
													<td>${list.udate}</td>
													<td>${list.usize }kb</td>
													<td>${list.id }</td>													
													<td><a onclick="unosubmit($(this))" href="#this" name="file1" id="${list.uno }">
													<label	class="label label-success">download</label></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>


								</form>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</form>
</div>



<jsp:include page="../footer.jsp" />