<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />

<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Mypage > Team Info</h1>
	</div>
</div>

<c:forEach items="${teaminfo }" var="tinfo">
	<div class="col-md-6 col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading">TEAM INFO</div>

			<div class="panel-body">
				<table class="table">
					<thead>
					</thead>
					<tr>
						<td rowspan="5" width="30%"><img src="upload/${tinfo.timg}" style=" width: 100%;"></td>
					</tr>
					<tr>
						<td><b>Team name</b></td>
						<td>${tinfo.name }</td>
						<td></td>
					</tr>
					<tr>
						<td><b>Team leader</b></td>
						<td><c:if test="${sessionScope.id eq tinfo.leader }">
								<b> ${tinfo.leader} (ME) </b>
							</c:if> <c:if test="${sessionScope.id != tinfo.leader }">
								<b>${tinfo.leader}</b>
							</c:if></td>
						<td></td>

					</tr>
					<tr>
						<td><b>Team member</b></td>
						<td><c:forEach items="${memberslist }" var="members">
								<c:if test="${members.state eq '2' }">
									<c:if test="${members.tno eq tinfo.tno }">
									${members.id}
									  
									
									<c:choose>
											<c:when test="${sessionScope.id eq tinfo.leader }">
												<%-- <a href="teamout?tno=${tinfo.tno}&id=${members.id}"	class="btn btn-danger btn-sm">Member out</a> --%>
												<a href="javascript:teamOut('=${tinfo.tno}&id=${members.id}')"	class="btn btn-danger btn-sm">Member out</a>
											</c:when>

										</c:choose>

										<br>
									</c:if>
								</c:if>
							</c:forEach></td>
						<td></td>
					</tr>
					<tr>
						<td><b>Team delete</b></td>
						<td><c:choose>
								<c:when test="${sessionScope.id eq tinfo.leader }">
									<%-- <a href="teamdelete?tno=${tinfo.tno }"	class="btn btn-danger btn-sm">Team delete</a> --%>
									<a href="javascript:delTeam('=${tinfo.tno }')"	class="btn btn-danger btn-sm">Team delete</a>
								</c:when>
								<c:otherwise>
							권한 X
							</c:otherwise>
							</c:choose></td>
						<td></td>
					</tr>
					<tr>
						<form action="javascript:addM('=${tinfo.tno}&tname=${tinfo.name}')">
							<c:choose> 
								<c:when test="${sessionScope.id eq tinfo.leader }">
									<td><b>Add member</b></td>
									<td>
									<input type="text" id ="id" name="id" class="form-control" placeholder="input id..">
										
										<input type="hidden" value="${tinfo.tno }" name="tno"> 
										<input type="hidden" value="${tinfo.name }" name="tname">
										</td>
									<td>
									<input type="submit" class="btn btn-danger btn-sm" value="Add"></td>
									<td></td>
								</c:when>
							</c:choose>
						</form>
					</tr>
				</table>
			</div>
		</div>
	</div>
</c:forEach>

<jsp:include page="../footer.jsp" />