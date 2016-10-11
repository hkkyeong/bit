<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" />
<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">to do management</h4>
	</div>
	<div class="col-md-12">
	<a href="todo?pno=${pno }"
			style="text-align: right; margin: auto; display: block;">
			<h4>progress -></h4> <br>
		</a>
	</div>
</div>
<div class="row">
<div class="col-md-12">
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">TITLE LIST</div>
			<div class="panel-body">
			<form action="todoupdateform">
			<input type="hidden" name="pno" value="${pno }">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Title</th>
								<th>Start Date</th>
								<th>Dead Line</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tlist }" var="tlist">
									<tr >
										<td><input type="radio" name="tdno" value="${tlist.tdno }" /></td>
										<td>${tlist.content }</td>
										<td>${tlist.tdstart }</td>
										<td>${tlist.tddate }</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="form-group">
					<input type="submit" name="update" value="update" class="btn btn-default">
					<input type="submit" name="update" value="delete" class="btn btn-default">
				</div>
				</form>
			</div>
			<div class="panel-heading">SUBTITLE LIST</div>
			<div class="panel-body">
			<form action="todolistupdateform">
			<input type="hidden" name="pno" value="${pno }">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Title</th>
								<th>Subtitle</th>
								<th>Start Date</th>
								<th>Dead Line</th>
								<th>ID</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tllist }" var="tllist">
									<tr>
										<td><input type="radio" name="tlno" value="${tllist.tlno }" /></td>
										<td>${tllist.title }</td>
										<td>${tllist.content }</td>
										<td>${tllist.tlstart }</td>
										<td>${tllist.tldate }</td>
										<td>${tllist.id }</td>
									</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div class="form-group">
					<input type="submit" name="update" value="update" class="btn btn-default">
					<input type="submit" name="update" value="delete" class="btn btn-default">
				</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-6">
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">TITLE FORM</div>
			<div class="panel-body">
			<%if("todoupdate".equals((String)request.getParameter("update"))) {%>
				<form action="todoupdate">
				<input type="hidden" name="pno" value="${pno }">
				<input type="hidden" name="tdno" value="${todoselect.tdno }">
					<div class="form-group">
						<label>Tilte</label>
						<input type="text" value="${todoselect.content }" class="form-control" name="content" />
					</div>
					<div class="form-group">
						<label>시작일</label> <input type="date" class="form-control" name="tdstart" value="${todoselect.tdstart }"/>
					</div>
					<div class="form-group">
						<label>마감일</label> <input type="date" class="form-control" name="tddate" value="${todoselect.tddate }"/>
					</div>
					<div class="form-group">
					<a href="todoupdate" style="text-align: right; margin: auto; display: block;">
					<button type="submit" class="btn btn-default">확인</button>
					</a>
					</div>
				</form>
						<%} else{%>
				<form action="todoinsert">
				<input type="hidden" name="pno" value="${pno }">
					<div class="form-group">
						<label>Tilte</label>
						<input type="text" class="form-control" name="content" placeholder="title" />
					</div>
					<div class="form-group">
						<label>시작일</label> <input type="date" class="form-control" name="tdstart"/>
					</div>
					<div class="form-group">
						<label>마감일</label> <input type="date" class="form-control" name="tddate"/>
					</div>
					<div class="form-group">
					<a href="#" style="text-align: right; margin: auto; display: block;">
					<button type="submit" class="btn btn-default">확인</button>
					</a>
					</div>
				</form>
			<%} %>
			</div>
		</div>	
	</div>
	<div class="col-md-6">
		<!--   Basic Table  -->
		<div class="panel panel-default">
			<div class="panel-heading">SUBTITLE FORM</div>
			<div class="panel-body">
			<%if("todolistupdate".equals((String)request.getParameter("update"))) {%>
			<form action="todolistupdate">
			<input type="hidden" name="pno" value="${pno }">
			<input type="hidden" name="tlno" value="${ todolistselect.tlno}">
					<div class="form-group">
						<label>Title</label>
						<select class="form-control" name="tdno" onchange="selectCheck(this.value)">
 							 <c:forEach items="${tlist }" var="tlist">
 								<c:if test="${ tlist.tdno==todolistselect.tdno }">
 									<option value="${tlist.tdno }">${tlist.content }</option>
 								</c:if>
							</c:forEach>
							<c:forEach items="${tlist }" var="tlist">
 								<c:if test="${ tlist.tdno!=todolistselect.tdno }">
 									<option value="${tlist.tdno }">${tlist.content }</option>
 								</c:if>
							</c:forEach> 			 				
						</select><br>
						<label>+Subtitle</label> 
					</div>
					<div class="form-group">
						<label>Subtilte</label>
						<textarea class="form-control" rows="3" name="content" >${todolistselect.content }</textarea>
					</div>
					<div class="form-group" id="startdate">
						<c:forEach items="${tlist }" var="tlist">
 						<c:if test="${ tlist.tdno==todolistselect.tdno }">
							<label>시작일</label> <input type="date" class="form-control" name="tlstart" value="${todolistselect.tlstart}" min="${tlist.tdstart }" max="${tlist.tddate }"/>
 						</c:if>
 						</c:forEach>
					</div>
					<div class="form-group" id="subdate">
						<c:forEach items="${tlist }" var="tlist">
 						<c:if test="${ tlist.tdno==todolistselect.tdno }">
							<label>마감일</label> <input type="date" class="form-control" name="tldate" value="${todolistselect.tldate}" min="${tlist.tdstart }" max="${tlist.tddate }"/>
						</c:if>
						</c:forEach>
					</div>
					<div class="form-group">
						<label>Person in charge</label>
						<select class="form-control" name="id">
							<c:forEach items="${ mlist}" var="mlist">
								<c:if test="${ mlist.id eq todolistselect.id }">
									<option value="${mlist.id }">${mlist.id }</option>
								</c:if>
							</c:forEach>
							<c:forEach items="${ mlist}" var="mlist">
								<c:if test="${ mlist.id ne todolistselect.id }">
									<option value="${mlist.id }">${mlist.id }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
					<a href="todolistupdate" style="text-align: right; margin: auto; display: block;">
					<button type="submit" class="btn btn-default">확인</button>
					</a>
					</div>
				</form>
			<%} else{ %>
				<form action="todolistinsert">
				<input type="hidden" name="pno" value="${pno }">
					<div class="form-group">
						<label>Title</label>
						<select class="form-control" onchange="selectCheck(this.value)" name="tdno">
 							<c:forEach items="${tlist }" var="tlist">
									<option value="${tlist.tdno }">${tlist.content }</option>  
							</c:forEach> 							
						</select><br>
						<label>+Subtitle</label> 
					</div>
					<div class="form-group">
						<label>Subtilte</label>
						<textarea class="form-control" rows="3" placeholder="subtitle" name="content"></textarea>
					</div>
					<div class="form-group" id="startdate">
						<c:forEach items="${tlist }" var="tlist" varStatus="s">
						<c:if test="${s.count eq 1 }">
							<label>시작일</label> <input type="date" class="form-control" name="tlstart" min="${tlist.tdstart }" max="${tlist.tddate }"/>
						</c:if>
						</c:forEach>
					</div>
					<div class="form-group" id="subdate">
						<c:forEach items="${tlist }" var="tlist" varStatus="s">
						<c:if test="${s.count eq 1 }">
							<label>마감일</label> <input type="date" class="form-control" name="tldate" min="${tlist.tdstart }" max="${tlist.tddate }"/>
						</c:if>
						</c:forEach>
					</div>
					<div class="form-group">
						<label>Person in charge</label>
						<select class="form-control" name="id">
							<c:forEach items="${ mlist}" var="mlist">
								<option value="${mlist.id }">${mlist.id }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
					<a href="#" style="text-align: right; margin: auto; display: block;">
					<button type="submit" class="btn btn-default">확인</button>
					</a>
					</div>
				</form>
			<%} %>

			</div>
		</div>
		</div>
</div>




<jsp:include page="../footer_todo2.jsp" />