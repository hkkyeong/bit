<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header_basic.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_basic.jsp" />

<%
	String id = null;
	String password = null;
%>


<div class="row" id="tagtest">
	<div class="col-md-12">
		<h4 class="page-head-line">LOGIN</h4>
	</div>
</div>


<div class="row">

	<div class="col-md-6">
		<h4>
			Login with facebook <strong> / </strong>Google :
		</h4>
		<br /> <a href="index.html" class="btn btn-social btn-facebook">
			<i class="fa fa-facebook"></i>&nbsp; Facebook Account
		</a> &nbsp;OR&nbsp; <a href="index.html" class="btn btn-social btn-google">
			<i class="fa fa-google-plus"></i>&nbsp; Google Account
		</a>
		<hr />
		<h4>
			Or Login with <strong>Winder Account :</strong>
		</h4>
		<br />

		<form action="loginchk" method="post">
			<label>Enter ID : </label> <input type="text" name="id"
				class="form-control" /> <label>Enter Password : </label> <input
				type="password" name="password" class="form-control" /><br>
			<button type="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-user"> login </span>
			</button>
			<hr />

			<a href="signup" class="btn btn-info"><span
				class="glyphicon glyphicon-user"></span> &nbsp;Sign Me up</a>&nbsp;
		</form>

	</div>
	<div class="col-md-6">
		<div class="alert alert-info">
			This is a free bootstrap admin template with basic pages you need to
			craft your project. Use this template for free to use for personal
			and commercial use. <br /> <strong> Some of its features
				are given below :</strong>
			<ul>
				<li>Responsive Design Framework Used</li>
				<li>Easy to use and customize</li>
				<li>Font awesome icons included</li>
				<li>Clean and light code used.</li>
			</ul>

		</div>
		<div class="alert alert-success">
			<strong> Instructions To Use:</strong>
			<ul>
				<li>Lorem ipsum dolor sit amet ipsum dolor sit ame</li>
				<li>Aamet ipsum dolor sit ame</li>
				<li>Lorem ipsum dolor sit amet ipsum dolor</li>
				<li>Cpsum dolor sit ame</li>
			</ul>

		</div>
	</div>

</div>



<jsp:include page="footer.jsp" />
</body>
</html>