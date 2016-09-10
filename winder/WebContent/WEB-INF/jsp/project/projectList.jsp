<%@page import="winder.vo.ProjectVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="winder.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects list</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="KingAdmin - Bootstrap Admin Dashboard Theme">
	<meta name="author" content="The Develovers">
	<!-- CSS -->
	<link href="css2/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css2/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- <link href="css2/main.css" rel="stylesheet" type="text/css"> --> 
	<link href="css2/my-custom-styles.css" rel="stylesheet" type="text/css">
	<!--[if lte IE 9]>
		<link href="assets/css/main-ie.css" rel="stylesheet" type="text/css"/>
		<link href="assets/css/main-ie-part2.css" rel="stylesheet" type="text/css"/>
	<![endif]-->

</head>
<%
	ArrayList<ProjectVO> projectAll = new ArrayList<>();
	projectAll =(ArrayList)request.getAttribute("projectlist");
	System.out.println("projectlist req'value : "+projectAll);
%>

<body>
<div class="row">
		<div class="col-lg-4 ">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="home">Home</a></li>
				<li><a href="teamlist">Team</a></li>
				<li><a href="teamInfo">Team Info</a></li>
				<li class="active">Project list</li>
			</ul>
		</div>

	<div class="col-md-12">
		<h4 class="page-head-line">project</h4>	
	<a href="teamcreate"></a>
	
	<!-- WRAPPER -->
	<div id="wrapper" class="wrapper">
	
	
		<!-- MAIN CONTENT WRAPPER -->
		<div id="main-content-wrapper" class="content-wrapper ">
			<!-- top general alert -->
			
			<!-- end top general alert -->
			
			<!-- main -->
			<div class="content">
			
			
				<div class="main-content">
				
					<div class="bottom-30px">
						<a href="projectcreate" class="btn btn-primary"><i class="fa fa-plus-square"></i> Create New Project</a>
						<nav class="main-content-nav pull-right">
							<ul class="list-inline">
								<li><a href="#"><i class="fa fa-tasks"></i> My Tasks</a></li>
								<li><a href="page-file-manager.html"><i class="fa fa-files-o"></i> My Files</a></li>
								<li><a href="#"><i class="fa fa-history"></i> My Activity</a></li>
							</ul>
						</nav>
					</div>
				
					<div class="table-responsive">
						<!-- PROJECT TABLE -->
						<table class="table colored-header datatable project-list">
							<thead>
								<tr>
									<th>Title</th>
									<th>Date Start</th>
									<th>Days to Deadline</th>
									<th>Progress</th>
									<th>Priority</th>
									<th>Leader</th>
									<th>Status</th>
								</tr>
							</thead>
					
							<tbody>
							<c:forEach var="vo" items="${projectlist}">
								<tr>
									<td><a href="profile">${vo.getTitle() }</a></td>
									<td>${vo.getPdate() }</td>
									<td>12 days</td>
									<td>
										<div class="progress">
											<div class="progress-bar" data-transitiongoal="95"></div>
										</div>
									</td>
									<td><span class="label label-warning">MEDIUM</span></td>
									<td><img src="img2/user2.png" alt="Avatar" class="avatar img-circle" /> <a href="profile">Michael</a></td>
									<td><span class="label label-success">ACTIVE</span></td>
								</tr>
							</c:forEach>
								<tr>
									<td><a href="#">Spot Media</a></td>
									<td>18-05-2014</td>
									<td>12 days</td>
									<td>
										<div class="progress">
											<div class="progress-bar" data-transitiongoal="95"></div>
										</div>
									</td>
									<td><span class="label label-warning">MEDIUM</span></td>
									<td><img src="img2/user2.png" alt="Avatar" class="avatar img-circle" /> <a href="profile">Michael</a></td>
									<td><span class="label label-success">ACTIVE</span></td>
								</tr>
								<tr>
									<td><a href="#">E-Commerce Site</a></td>
									<td>24-05-2014</td>
									<td>30 days</td>
									<td>
										<div class="progress">
											<div class="progress-bar" data-transitiongoal="40"></div>
										</div>
									</td>
									<td><span class="label label-success">LOW</span></td>
									<td><img src="img2/user1.png" alt="Avatar" class="avatar img-circle" /> <a href="profile">Antonius</a></td>
									<td><span class="label label-warning">PENDING</span></td>
								</tr>
								<tr>
									<td><a href="#">Project 123GO</a></td>
									<td>20-09-2014</td>
									<td>50 days</td>
									<td>
										<div class="progress">
											<div class="progress-bar" data-transitiongoal="65"></div>
										</div>
									</td>
									<td><span class="label label-danger">HIGH</span></td>
									<td><img src="img2/user1.png" alt="Avatar" class="avatar img-circle" /> <a href="profile">Antonius</a></td>
									<td><span class="label label-success">ACTIVE</span></td>
								</tr>
								
								
								
								<tr>
									<td><a href="#">Wordpress Theme</a></td>
									<td>05-10-2014</td>
									<td>N/A</td>
									<td>
										<div class="progress">
											<div class="progress-bar progress-bar-default" data-transitiongoal="100"></div>
										</div>
									</td>
									<td><span class="label label-default">MEDIUM</span></td>
									<td><img src="img2/user2.png" alt="Avatar" class="avatar img-circle" /> <a href="profile">Michael</a></td>
									<td><span class="label label-default">CLOSED</span></td>
								</tr>
								<tr>
									<td><a href="#">Redesign Landing Page</a></td>
									<td>15-11-2014</td>
									<td>30 days</td>
									<td>
										<div class="progress">
											<div class="progress-bar" data-transitiongoal="33"></div>
										</div>
									</td>
									<td><span class="label label-success">LOW</span></td>
									<td><img src="img2/user5.png" alt="Avatar" class="avatar img-circle" /> <a href="profile">Jason</a></td>
									<td><span class="label label-warning">PENDING</span></td>
								</tr>
							</tbody>
						</table>
						<!-- END PROJECT TABLE -->
					</div>
				</div>
			</div>
			<!-- /main -->
			<!-- FOOTER -->
		
			<!-- END FOOTER -->
		</div>
		<!-- END CONTENT WRAPPER -->
	</div>
	</div>

</div>

<script src="js2/jquery/jquery-2.1.0.min.js"></script>
<script src="js2/bootstrap/bootstrap.js"></script>
<script src="js2/js/plugins/modernizr/modernizr.js"></script>
<script src="js2/plugins/bootstrap-tour/bootstrap-tour.custom.js"></script>
<script src="js2/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="js2/plugins/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
</body>
</html>

<jsp:include page="../footer.jsp" />