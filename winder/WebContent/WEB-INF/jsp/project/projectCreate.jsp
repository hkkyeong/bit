<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_project.jsp" /> 	

<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">Project create Form</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12" style="padding-left: 20%;">
					<div class="panel panel-info" style="width: 80%;">
						<div class="panel-heading">Project create</div>

						<div class="panel-body">

							<form action="projectcreate" mehtod="post">
								<div class="form-group">
									<label>Team Select</label>
									<select class="form-control" name="tno">
										<c:forEach items="${teammenu }" var="tmenu">
											<option value="${tmenu.tno }">${tmenu.name }</option>
										</c:forEach>
									</select>
									<!-- <input
										type="text" class="form-control" name="teampassword"
										placeholder="Input content" /> -->
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Project Name</label> <input
										type="text" class="form-control" name="name"
										placeholder="Input projectname" />
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Content</label> <input
										type="text" class="form-control" name="content"
										placeholder="Input content" />
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">expire Date</label> <input
										type="date" class="form-control" name="exdate"
										placeholder="Input content" />
								</div>
								<button type="submit" class="btn btn-default" >Submit</button>



							</form>
						</div>
					</div>
				</div>

			</div>
		</div>

<jsp:include page="../footer.jsp" />
