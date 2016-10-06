<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.springframework.ui.Model"%>
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
					<li class="active"><a href="#scrap2" data-toggle="tab">Scrap</a></li>
					<li class=""><a href="#file2" data-toggle="tab">File</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane fade active in" id="scrap2">
						<br>
						<div class="table-responsive">
							<form action="shareScrap">
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
												<td width="5%">${index.count }</td>
												<td width="30%"><a href="scrap1?sno=${scrap.sno }&kind=my">${scrap.stitle }</a></td>
												<td width="30%">${scrap.sdate}</td>
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
								<div class="col-md-12" style="text-align: right;">
									<select name="pno">
										<c:forEach items="${projectmenu }" var="plist">
											<option value="${plist.pno }">${plist.name }</option>
										</c:forEach>
									</select> 
									<input type="submit" value="공유">
								</div>


							</form>
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
											<th>File</th>
											<th>Date</th>
											<th>Size</th>
											<th>공유 여부</th>
											<th>#</th>
											<th>Download</th>
										</tr>
									</thead>
									<tbody id="div1">
										<c:forEach items="${list }" var="list" varStatus="index">
										<c:if test="${sessionScope.id eq list.ID}">
											<tr>
												<td width="3%">${index.count }</td>
												<td width="25%">${list.UTITLE }</a></td>
												<td width="25%">${list.ORIGINALNAME }</a></td>
												<td width="25%">${list.UDATE}</td>
												<td>${list.USIZE }kb</td>
												<c:if test="${list.BOARDNO eq 0 }">
													<td>공유 x</td>
												</c:if>
												<c:if test="${list.BOARDNO ne 0 }">
													<c:forEach items="${projectmenu }" var="plist">
														<c:if test="${plist.pno eq list.BOARDNO }">
															<td>${plist.name }</td>
								 						</c:if>
													</c:forEach>
												</c:if>
												<td><input type="checkbox" name="uno" value="${list.UNO}"></td>
												<td><a onclick="unosubmit($(this))" href="#this" name="file1" id="${list.UNO }"><label class="label label-success">download</label></a></td>
											</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
								
								<div class="col-md-12" style="text-align: right;">
									<select name="boardno">
										<c:forEach items="${projectmenu }" var="plist">
											<option value="${plist.pno }">${plist.name }</option>
										</c:forEach>
									</select> 
									<input type="submit" value="공유">
								</div>
								
							</form>
						</div>
					</div>
				</div> 




				<div class="col-md-12" style="text-align: right;">
					<br> <br>
					<input type="button" id="scrap" value="스크랩  올리기"> <input
						type="button" id="file" value="파일 올리기">
				</div>

			</div>
		</div>
	</div>
</div>


<div id="element_to_pop_up2">
	<form action="insertScrap">
		<div class="b-close" style="color: #000;">x</div>
		<br>
		<br> tile &nbsp;&nbsp;<input type="text" id="stitle"
			name="stitle" size="40"> <br>
		<br> url &nbsp;&nbsp; <input type="text" id="url" name="url"
			size="40"> <br>
		<br>
		<div class="col-md-12" style="text-align: right;">
			<input type="submit" value="올리기">
		</div>
	</form>
</div>

<div id="element_to_pop_up">
	<form action="insertFile" method="post" enctype="multipart/form-data">
		<div class="b-close" style="color: #000;">x</div>
		<br>
		<br> title &nbsp;&nbsp;<input type="text" name="utitle" id="utitle">
		<br>
		<br> file <input type="file" name="file"><br>
		<br>
		<div class="col-md-12" style="text-align: right;">
			<input type="submit" value="올리기">
		</div>
	</form>
</div>


<jsp:include page="../footer_mypage.jsp" />