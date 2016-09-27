








<%@page import="winder.vo.TeamVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_team.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Mypage > Scrap & File Upload</h1>
	</div>
</div>
<div class="row">
<form>
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>No</th>
								<th>Type</th>
								<th>Title</th>
								<th>공유 여부</th>
								<th>#</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><input type="radio" name="" value="" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-12" style="text-align: right;">
		<select name ="pno">
<%-- 						<c:forEach items="${selectProject}" var="scrap">
							<option value="${scrap.pno}">${scrap.name}</option>
						</c:forEach> --%>
		</select>
		<input type="submit" value="공유">
	</div>
	<div class="col-md-12" style="text-align: right;">
	<br><br>
		<input type="button" value="파일  올리기">
		<input type="button" value="스크랩 올리기">
		<!-- <form action="upload">
	<input type="file" name="upload">
	</form> -->
	</div>
</form>
</div>

<jsp:include page="../footer_mypage.jsp" />