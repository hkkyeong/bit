<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />

${member }
${teammenu }
<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">My page</h4>
	</div>
</div>

<div class="row">
	<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">Profile</div>
			<div class="panel-body">
			
			<a href="profilemain"><img src="img/pic01.png" style=" width: 100%;"></a> 
<!-- 				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.
					Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.
					Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.</p> -->
			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
	<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">Team Info</div>
			<div class="panel-body">
			<a href="teaminfo"><img src="img/pic02.png" style=" width: 100%;"></a> 
<!-- 				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.
					Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.
					Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.</p> -->
			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
	<div class="col-md-4 col-sm-4">
		<div class="panel panel-success">
			<div class="panel-heading">Message</div>
			<div class="panel-body">
			<a href="noteList?rid=${sessionScope.id }"><img src="img/pic03.png" style=" width: 100%;"> </a> 
<!-- 				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.
					Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.
					Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue.</p> -->
			</div>
			<div class="panel-footer">&nbsp;</div>
		</div>
	</div>
</div>

<jsp:include page="../footer.jsp" />