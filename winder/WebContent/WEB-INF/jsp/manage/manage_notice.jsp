<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header_manage.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_notice.jsp" />

<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">Notice Management</h4>
		
		
		<div class="panel panel-default">
			<div class="panel-heading">Message</div>
			<div class="panel-body">
			<a href="" id="my-button" >쪽지보내기</a>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>No</th>
									<th>Title</th>
									<th>Date</th>
									<th>보낸이</th> 
									<th>삭제</th>
								</tr>
							</thead>

							<tbody id="div1">
								<c:forEach items="${noteList}" var="note">
									<tr>
										<td>${note.nno }</td>
										<td><a href="noteDetail?nno=${note.nno}" onclick="">${note.ntitle}</a></td>
										<td>${note.ndate}</td>
										<td>${note.sid}</td>
										<td><a href="noteDelete?nno=${note.nno }">삭제</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
		</div>
		
		
	</div>
</div>


<div id="element_to_pop_up">
<div class="b-close" style="color: #000;">x</div>
<form action="insertNotice" id="out">
제목 : <input type="text" name="ntitle" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		받는 이 : <input type="text" value="전체 회원 "><br> 
		내용 : <textarea name="ncontent" cols="80" rows="12"></textarea><br> 
		<input type="hidden"	name="sid" value="${sessionScope.id}"><br> 
		<input type="submit" value="보내기">
</form>

</div>



<jsp:include page="footer_manage.jsp" />