<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />
<%int flag=0; %>
<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">progress</h4>
	</div>
</div>
<div class="row">
<div class="col-md-6">
	<!-- Donut chart -->
	<div class="panel panel-default">
			<div class="panel-heading">DONUT CHART</div>
			<h4 id="per">&nbsp;&nbsp;&nbsp;전체 진행률: ${per } %</h4>

			<div class="box-body">
				<div id="donut-chart" style="height: 300px;"></div><br>
			</div>
			<!-- /.box-body-->
	</div>
</div>

<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-heading">PROGRESS BARS</div>
		<div class="panel-body"  id="progressbar">
		<c:forEach items="${ab }" var="ab">
			${ab.key }&nbsp;(${ab.value }%)
			<div class="progress progress-striped">
			<c:choose>
			<c:when test="${ab.value eq 100 }">
				<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${ab.value }" aria-valuemin="0" aria-valuemax="100" style="width: ${ab.value}%;"></div>
			</c:when>
			<c:otherwise>
				<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${ab.value }" aria-valuemin="0" aria-valuemax="100" style="width: ${ab.value}%; background-color: #b5bbc8;"></div>
			</c:otherwise>
			</c:choose>
			</div>
		</c:forEach>
		</div>
	</div>
</div>
</div>






<div class="row">
<c:forEach items="${ab }" var="ab">
<div class="col-md-3">
	<br>
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<c:choose>
			<c:when test="${ab.value eq 100 }">
				<div class="panel-heading" style="background: aliceblue;">${ab.key}</div>
				<div class="panel-body" style="background: aliceblue;">
			</c:when>
			<c:otherwise>
				<div class="panel-heading">${ab.key}</div>
				<div class="panel-body">
			</c:otherwise>
			</c:choose>
				<c:forEach items="${plist }" var="plist">
					<c:if test="${ab.key eq plist.title }">
					<%flag=0; %>
						<c:if test="${plist.state eq '2' }">
							<div class="alert alert-info">
								<strong>${plist.content }</strong><br>
								${plist.tldate }<br>
								${plist.id }
							</div>
						</c:if>
						<c:if test="${plist.state eq '1' }">
						<c:forEach items="${past }" var="past">
							<c:if test="${past.tlno eq plist.tlno }">
								<div class="alert alert-danger">
									<strong>${plist.content }</strong><br>
									${plist.tldate }<br>
									${plist.id }
								</div>
								<%flag=1; %>
							</c:if>
						</c:forEach>
						<%if(flag==0){ %>
							<div class="alert alert-warning">
								<strong>${plist.content }</strong><br>
								${plist.tldate }<br>
								${plist.id }
							</div>
							
						<%} %>
						</c:if>
					</c:if>
				</c:forEach>
			</div>
		</div>
</div>
</c:forEach>
</div>







<%-- <div class="row">
<div class="col-md-12">
	<br>
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">TO DO</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Title (Subtitle)</th>
								<th>Dead Line</th>
								<th>ID</th>
								<th style="width: 40%;">Progress Bar</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${ab }" var="ab">
							<c:forEach items="${tdlist }" var="tdlist">
							<c:if test="${ab.key eq tdlist.content }">
								<tr>
									<td>${tdlist.content }</td>
									<td>${tdlist.tddate }</td>
									<td>&nbsp;</td>
									<td>
									<div class="progress" style="margin-bottom: 0px;">
										<c:choose>
										<c:when test="${ab.value eq 100 }">
											<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${ab.value }" aria-valuemin="0" aria-valuemax="100" style="width: ${ab.value}%;"></div>
										</c:when>
										<c:otherwise>
											<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${ab.value }" aria-valuemin="0" aria-valuemax="100" style="width: ${ab.value}%; background-color: #5bc0de;"></div>
										</c:otherwise>
										</c:choose>
									</div>
									</td>
								</tr>
							</c:if>
							</c:forEach>
							<c:forEach items="${plist }" var="plist">
							<c:if test="${ab.key eq plist.title }">
							<tr>
								<td>-&nbsp;&nbsp;${plist.content }</td>
								<td>&nbsp;&nbsp;${plist.tldate }</td>
								<td>&nbsp;&nbsp;${plist.id }</td>
								<td>
								<div class="progress" style="margin-bottom: 0px; margin-left: 10px;">
									<c:choose>
										<c:when test="${plist.state eq '2' }">
											<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>
										</c:when>
										<c:otherwise>
											<c:forEach items="${past }" var="past">
												<c:choose>
													<c:when test="${plist.tlno eq past.tlno}">
														<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; background-color: #d9534f;"></div>
													</c:when>
													<c:otherwise>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; background-color: #f0ad4e;"></div>
										</c:otherwise>
									</c:choose>
								</div>
								</td>
							</tr>
							</c:if>
							</c:forEach>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div> --%>

<jsp:include page="../footer_progress.jsp" />