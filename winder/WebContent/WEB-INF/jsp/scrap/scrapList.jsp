
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="winder.vo.TeamVO"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />
<div class="row">  
	<a href="scrapForm?pno=${pno}">scrap</a>

	<div class="col-md-6">
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">Scrap</div>
			<div class="panel-body">
			
				<form action="shareScrap">
					<!-- @@마이페이지의 스크랩리스트를  프로젝트의 스크랩으로 공유하기@@ -->
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>No</th>
									<th>Title</th>
									<th>ID</th>
									<th>PNO</th>
									<th>선택</th>
								</tr>
							</thead>

							<tbody id="div1">
								<c:forEach items="${scrapList}" var="scrap">
									<tr>
										<td>${scrap.sno }</td>
										<td><a href="scrap1?sno=${scrap.sno }">${scrap.url }</a></td>
										<td>${scrap.id }</td>
										<td>${scrap.pno }</td>
										<td>
										<c:choose>
										<c:when test="${scrap.pno==0}">
										<input type="checkbox" name="sno" value="${scrap.sno}">
										</c:when>
										<c:otherwise>
										공유됨
										</c:otherwise>
										</c:choose>
										</td> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<select name ="pno">
						<c:forEach items="${selectProject}" var="scrap">
							<option value="${scrap.pno}">${scrap.name}</option>
						</c:forEach>
					</select> 
					<input type="submit" value="공유">
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>
<jsp:include page="../footer.jsp" />