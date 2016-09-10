
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="winder.vo.TeamVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />
<div class="row">
	<div class="col-md-12">

			<h4 class="page-head-line">Team List</h4>

			<div class="col-md-4 col-sm-4"
				style="padding-left: 30px; padding-right: 30px;">
				<div class="panel panel-default">
					<br> <br> <br> <br> <br>
					<div class="panel-body">
						<center>
							<p>
								<a href="teamCreateform">팀 신청</a>
							</p>
						</center>
					</div>
					<br> <br> <br> <br> <br>
				</div>
			</div>

			<c:forEach items="${teamList}" var="members">
				<div class="col-md-4 col-sm-4"	style="padding-left: 30px; padding-right: 30px;">
					<div class="panel panel-default">
						<br> <br> <br> <br> <br>
						<div class="panel-body">
							<center>
								<p>
									<a href="projectlist?tno=${members.tno }">${members.name }</a>
									<a href="teamDelete?tno=${members.tno}">삭제 </a>
								</p>
							</center>
						</div>
						<br> <br> <br> <br> <br>
					</div>
					</div>
			</c:forEach>

		</div>

	</div>

</div>
</div>
</div>

</div>

<jsp:include page="../footer.jsp" />