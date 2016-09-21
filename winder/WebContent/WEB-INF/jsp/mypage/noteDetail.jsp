<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />

<div class="row">
	<h4 class="page-head-line">Message</h4>
	<div class="col-md-6">
		<div class="panel panel-success">
			<div class="panel-heading">${noteDetail.ntitle}</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>보낸 이</th>
							<th>받은 시간</th>
						</tr>
						<tr>
							<th>내용</th>
						</tr>
					</thead>
					
					<tbody>
					<tr>
					<td>${noteDetail.sid}</td>
					<td>${noteDetail.ndate}</td>
					</tr>
					<tr>
					<td>${noteDetail.ncontent}</td>
					</tr>
					</tbody>
				</table>


				보낸 이 : ${noteDetail.sid} <br /> 받은 시간 : ${noteDetail.ndate} <br />

				${noteDetail.ncontent}
			</div>

		</div>
	</div>
</div>


<jsp:include page="../footer.jsp" />