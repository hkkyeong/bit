<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Sharing Data</h1>
	</div>
</div>
<div class="row">
<form action="shareScrap">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th style="width: 10px;">No</th>
								<th>Type</th>
								<th>Title</th>
								<th>ID</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${sharedscrapList}" var="scrap">
							<tr>
								<td>${scrap.sno }</td>
								<td>scrap</td>
								<td><a href="scrap1?sno=${scrap.sno }&kind=pro">${scrap.stitle }</a></td>
								<td>${scrap.id }</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</form>
</div>


<jsp:include page="../footer.jsp" />