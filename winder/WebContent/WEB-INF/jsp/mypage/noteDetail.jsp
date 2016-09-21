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
				<div class="table-responsive">
					<table class="table">
						<tr>
							<th>보낸 이</th>
							<td>${noteDetail.sid}</td>
							<th>받은 날짜</th>
							<td>${noteDetail.ndate}</td>
						</tr>
						<tr height="250px">
							<th>내용</th>
							<td colspan="3">${noteDetail.ncontent}</td>
						</tr>
					</table>
				</div>
			</div>

		</div>
	</div>
</div>


<jsp:include page="../footer.jsp" />