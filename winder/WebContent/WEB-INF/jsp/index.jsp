<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header_basic.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_basic.jsp" />
<div class="row">
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m1.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m2.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m3.png" style="width: 90%;">
	</div>
</div>
<br><br>
<div class="row">
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m4.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m5.png" style="width: 90%;">
	</div>
	<div class="col-md-4" style="text-align: center;">
	<img src="img/m6.png" style="width: 90%;">
	</div>
</div>

<form action="abc" method="post" enctype="multipart/form-data">
<div class="form-group">
<input type="text" class="form-control" name="utitle" /><br>
						<label for="Input Position">Img</label> <label
							for="exampleInputFile">File input</label> 
							<input type="file"	name="mimg" /> 
					</div>

					<button type="submit" class="btn btn-success">Submit</button>
</form>



<jsp:include page="footer.jsp" />