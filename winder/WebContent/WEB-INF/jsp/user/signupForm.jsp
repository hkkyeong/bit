<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />


<div class="row">
	<div class="col-md-12">
		<h4 class="page-head-line">LOGIN</h4>
	</div>

	<div class="col-md-12" style="padding-left: 20%;">
		<div class="panel panel-info" style="width: 80%;">
			<div class="panel-heading">SIGN UP!</div>
			<div class="panel-body">
				<form action="insertFile2" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="Input Email">Id</label> <input type="text"
							class="form-control" name="id" placeholder="Enter id" />
					</div>
					<div class="form-group">
						<label for="Input Password">Password</label> <input
							type="password" class="form-control" name="password"
							placeholder="Enter password" />
					</div>
					<div class="form-group">
						<label for="Input Password">Name</label> <input type="text"
							class="form-control" name="name" placeholder="Enter name" />
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" name="email"
							placeholder="Enter email" />
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">Phone</label> <input
							type="text" class="form-control" name="phone"
							placeholder="Enter Phone" />
					</div>
					<div class="form-group">
						<label for="Input Position">Img</label> <label
							for="exampleInputFile">File input</label> 
							<input type="file"	name="mimg" /> 
					</div>

					<button type="submit" class="btn btn-success">Submit</button>
				</form>
			</div>
		</div>
	</div>

</div>

<jsp:include page="../footer.jsp" />