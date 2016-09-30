<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Mypage > Scrap & File Upload</h1>
		<div class="panel panel-default">
			<div class="panel-heading">Basic Tabs</div>
			<div class="panel-body">

				<ul class="nav nav-tabs">
					<li class="active"><a href="#scrap" data-toggle="tab">Scrap</a></li>
					<li class=""><a href="#file" data-toggle="tab">File</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane fade active in" id="scrap">
					<br>
						<div class="table-responsive">
							<form>
								<table class="table">
									<thead>
										<tr>
											<th>No</th>
											<th>Title</th>
											<th>Date</th>
											<th>공유 여부</th>
											<th>#</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${scrapList}" var="scrap" varStatus="index">
											<tr>
												<td>${index.count }</td>
												<td><a href="scrap1?sno=${scrap.sno }&kind=my">${scrap.stitle }</a></td>
												<td>${scarp.sdate}</td>
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
												<td><input type="checkbox" name="sno"
													value="${scrap.sno}"></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>
					</div>


					<div class="tab-pane fade" id="file">
					<br>
						<div class="table-responsive">
							<form action="">
								<table class="table">
									<thead>
										<tr>
											<th>No</th>											
											<th>Title</th>
											<th>Date</th>
											<th>공유 여부</th>
											<th>#</th>
										</tr>
									</thead>
									<tbody id="div1">
										<c:forEach items="${list }" var="list" varStatus="index">
											<tr>
												<td>${index.count }</td>
												<td><a
													href="uploadDetail?uno=${list.UNO}&storedname=${list.STOREDNAME}">${list.ORIGINALNAME }</a></td>
												<td>${list.UDATE}</td>
												<td>${list.USIZE }</td>
												<td></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>


				<div class="col-md-12" style="text-align: right;">
					<select name="pno">
						<c:forEach items="${projectmenu }" var="plist">
							<option value="${plist.pno }">${plist.name }</option>
						</c:forEach>
					</select> <input type="submit" value="공유">
				</div>
				<div class="col-md-12" style="text-align: right;">
					<br>
					<br> <input type="button" id="file" value="파일  올리기"> <input
						type="button" id="scrap" value="스크랩 올리기">
				</div>


			</div>
		</div>
	</div>
</div>

<jsp:include page="../footer_mypage.jsp" />