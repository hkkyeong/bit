<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Mypage > Scrap & File Upload</h1>
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
								<th>No</th>
								<th>Type</th>
								<th>Title</th>
								<th>공유 여부</th>
								<th>#</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${scrapList}" var="scrap">
							<tr>
								<td>${scrap.sno }</td>
								<td>scrap</td>
								<td><a href="scrap1?sno=${scrap.sno }&kind=my">${scrap.stitle }</a></td>
								<c:if test="${scrap.pno eq 0 }">
									<td>공유 x</td>
								</c:if>
								<c:if test="${scrap.pno ne 0 }">
								<c:forEach items="${projectmenu }" var="plist">
									<c:if test="${plist.pno eq scrap.pno }">
										<td>${plist.name }</td>
									</c:if>
								</c:forEach>
								</c:if>
								<td><input type="checkbox" name="sno" value="${scrap.sno}"></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-12" style="text-align: right;">
		<select name ="pno">
			<c:forEach items="${projectmenu }" var="plist">
				<option value="${plist.pno }">${plist.name }</option>
			</c:forEach>
		</select>
		<input type="submit" value="공유">
	</div>
	<div class="col-md-12" style="text-align: right;">
	<br><br>
		<input type="button" id="file" value="파일  올리기">
		<input type="button" id="scrap" value="스크랩 올리기">
	</div>
</form>
</div>


<div id="element_to_pop_up">
<div class="b-close" style="color: #000;">x</div>
<form action="insertFile">
<h3>파일 업로드</h3><br>
title
	<input type="text" class="form-control" name="utitle" /><br><br>
	<input type="file" name="upload"><br>
	<button type='submit' class='btn btn-default'>확인</button>
</form>
</div>

<div id="element_to_pop_up2">
<div class="b-close" style="color: #000;">x</div>
<form action="insertScrap">
<h3>스크랩</h3><br>
titles
	<input type="text" class="form-control" name="stitle" /><br>
	url
	<input type="text" class="form-control" name="url"><br>
	<button type='submit' class='btn btn-default'>확인</button>
</form>
</div>

<jsp:include page="../footer_mypage.jsp" />