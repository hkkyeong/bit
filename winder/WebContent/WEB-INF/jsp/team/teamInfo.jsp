<%@page import="winder.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />
<html>
<head>
<title>Project 123GO | KingAdmin - Admin Dashboard</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="KingAdmin - Bootstrap Admin Dashboard Theme">
	<meta name="author" content="The Develovers">
	<!-- CSS -->
	<link href="css2/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css2/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css2/css/main.css" rel="stylesheet" type="text/css">
	 <link href="css2/css/my-custom-styles.css" rel="stylesheet" type="text/css">

</head>
<%
	String name=request.getParameter("tname");
	System.out.println("####"+name);
%>
<body>
<div class="row">
		<div class="col-lg-4 ">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="home">Home</a></li>
				<li><a href="teamlist">Team</a></li>
				<li class="active">Team Info</li>
			</ul>
		</div>
	<div class="col-md-12">
		<h4 class="page-head-line">Team Info</h4>
	
	
	<div id="wrapper" class="wrapper">
		
		<!-- END TOP BAR -->
		<!-- LEFT SIDEBAR -->
		
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN CONTENT WRAPPER -->
		<div id="main-content-wrapper" class="content-wrapper ">
			<!-- top general alert -->
			
			<!-- end top general alert -->
			<div class="row">
				
			
			<!-- main -->
			<div class="content">
				<div class="col-md-12">
					<h2><%=request.getParameter("teamname") %></h2>
					
					<em><a href="projectlist"><button type="button" class="btn btn-sm btn-primary pull-right"><i class="fa fa-edit"></i> Project list</button></a></em>
					<em>Last Activity: <a href="#">Michael</a> has achieved 80% of assigned tasks</em>
				</div>
				<div class="main-content">
					
					<div class="row">
					
						<div class="col-md-8">
							<div class="project-section general-info">
								<h3>Team comment</h3>
								
						
								<p>Rapidiously monetize orthogonal platforms with 24/7 convergence. Uniquely create error-free alignments for customized users. Credibly facilitate just in time benefits rather than user friendly imperatives. Continually promote extensible process improvements whereas virtual. Enthusiastically pontificate proactive infrastructures vis-a-vis value-added products. Enthusiastically coordinate pandemic platforms rather than team building best practices. Globally facilitate plug-and-play materials and interoperable interfaces. Enthusiastically.</p>
								<div class="row">
									<div class="col-sm-9">
										<dl class="dl-horizontal">
											<dt>Date:</dt>
											<dd>September 20, 2014 - December 20, 2014</dd>
											<dt>Duration:</dt>
											<dd>90 days <span class="text-muted"><small>(50 days remaining)</small></span></dd>
											<dt>Client:</dt>
											<dd><a href="#">ZenArt</a></dd>
											<dt>Priority:</dt>
											<dd><span class="label label-danger">HIGH</span></dd>
											<dt>Status:</dt>
											<dd><span class="label label-success">ACTIVE</span></dd>
											<dt>Team:</dt>
											<dd>
												<ul class="list-inline team-list">
													<li>
														<img src="img2/user1.png" class="img-circle" alt="Avatar" />
														<p><a href="#"><strong>Antonius</strong></a></p>
														<span class="text-muted">Project Leader</span>
													</li>
													<li>
														<img src="img2/user2.png" class="img-circle" alt="Avatar" />
														<p><a href="#"><strong>Michael</strong></a></p>
														<span class="text-muted">Art Director</span>
													</li>
													<li>
														<img src="img2/user3.png" class="img-circle" alt="Avatar" />
														<p><a href="#"><strong>Stella </strong></a></p>
														<span class="text-muted">Acc Executive</span>
													</li>
													<li>
														<img src="img2/user4.png" class="img-circle" alt="Avatar" />
														<p><a href="#"><strong>Jane Doe</strong></a></p>
														<span class="text-muted">Marketing</span>
													</li>
													<li>
														<img src="img2/user5.png" class="img-circle" alt="Avatar" />
														<p><a href="#"><strong>Jason</strong></a></p>
														<span class="text-muted">Operational</span>
													</li>
													<li class="team-add">
														<i class="icon ion-person"></i>
														<a href="#"><i class="fa fa-plus-circle"></i> Add </a>
													</li>
													
												</ul>
												
											</dd>
										</dl>
									</div>
									<div class="col-sm-3">
										<div class="project-progress text-center bottom-30px">
											<div class="easy-pie-chart" data-percent="60"><span class="percent">60</span></div>
											<span class="chart-title">OVERALL PROGRESS</span>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						<div class="col-md-4">
							<!-- MY TODO LIST -->
							<div class="widget">
								<div class="widget-header">
									<h3><i class="fa fa-calendar"></i> My To-Do List</h3>
									<div class="btn-group widget-header-toolbar">
										<a href="#" title="Expand/Collapse" class="btn-borderless btn-toggle-expand"><i class="fa fa-chevron-up"></i></a>
									</div>
								</div>
								<div class="widget-content">
									<ul class="list-unstyled simple-todo-list">
										<li>
											<label class="fancy-checkbox">
												<input type="checkbox" checked="checked">
												<span class="todo-text">Upload new revision</span>
											</label>
										</li>
										<li>
											<label class="fancy-checkbox">
												<input type="checkbox">
												<span class="todo-text">Responsive test</span>
											</label>
										</li>
										<li>
											<label class="fancy-checkbox">
												<input type="checkbox" checked="checked">
												<span class="todo-text">Cross-browser check</span>
											</label>
										</li>
										<li>
											<label class="fancy-checkbox">
												<input type="checkbox">
												<span class="todo-text">Social media research</span>
											</label>
										</li>
										<li>
											<label class="fancy-checkbox">
												<input type="checkbox">
												<span class="todo-text">Conduct A/B test</span>
											</label>
										</li>
									</ul>
									
								</div>
								
							</div>
							<!-- END MY TODO LIST -->
							<!-- RECENT FILES -->
							<div class="widget">
								<div class="widget-header">
									<h3><i class="fa fa-files-o"></i> Shared Files</h3>
									<div class="btn-group widget-header-toolbar">
										<a href="#" title="Expand/Collapse" class="btn-borderless btn-toggle-expand"><i class="fa fa-chevron-up"></i></a>
									</div>
								</div>
								<div class="widget-content">
									<ul class="fa-ul recent-file-list bottom-30px">
										<li><i class="fa-li fa fa-file-pdf-o"></i><a href="#">Project Requirements.pdf</a></li>
										<li><i class="fa-li fa fa-file-word-o"></i><a href="#">[DRAFT] System Specifications.docx</a></li>
										<li><i class="fa-li fa fa-file-picture-o"></i><a href="#">Marketing Content-v2.jpg</a></li>
										<li><i class="fa-li fa fa-file-zip-o"></i><a href="#">All-files-backup.zip</a></li>
									</ul>
									<button type="button" class="btn btn-sm btn-primary"><i class="fa fa-upload"></i> Upload</button> <a href="page-file-manager.html" class="btn btn-sm btn-default"><i class="fa fa-folder"></i> See all files</a>
								</div>
							</div>
							<!-- END RECENT FILES -->
						</div>
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

<script src="js2/plugins/stat/jquery.easypiechart.min.js"></script>
</body>
</html>
<jsp:include page="../footer.jsp" />