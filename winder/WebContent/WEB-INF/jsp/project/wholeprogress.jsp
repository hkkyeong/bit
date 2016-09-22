<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />

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
		<c:forEach items="${ab }" var="tdlist">
			${tdlist.key }
			<div class="progress progress-striped">
			<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${tdlist.value }" aria-valuemin="0" aria-valuemax="100" style="width: ${tdlist.value}%">
			</div>
			</div>
		</c:forEach>
		</div>
	</div>
</div>

</div>

<jsp:include page="../footer_progress.jsp" />