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
						 <td rowspan="5" width="30%" ><img src="img/${tinfo.timg}"> </td>
					</tr>
					<tr>
						<td><b>Team name</b></td>
						<td>${tinfo.name }</td>
						<td></td>
					</tr>
					<tr>
						<td><b>Team leader</b></td>
						<td>${tinfo.leader}</td>
						<td></td> 

					</tr>
					<tr>
						<td><b>Team member</b></td>
						<td>
							<c:forEach items="${memberslist }" var="members">
								<c:if test="${members.tno eq tinfo.tno }">  
									${members.id}
									<a href="teamout?tno=${tinfo.tno}&id=${members.id}"	class="btn btn-danger btn-xs"  >Member out</a><br>
								</c:if>
							</c:forEach>
						</td>
						<td></td> 
					</tr>
					<tr>
						<td><b>Team delete</b></td>
						<td><a href="teamdelete?tno=${tinfo.tno }"
							class="btn btn-danger btn-xs">Team delete</a></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</c:forEach>

<jsp:include page="../footer.jsp" />