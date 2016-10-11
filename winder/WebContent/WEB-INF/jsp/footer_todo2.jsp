<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
</div>
</div>
<!-- CONTENT-WRAPPER SECTION END-->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				&copy; 2015 YourCompany | By : <a
					href="http://www.designbootstrap.com/" target="_blank">DesignBootstrap</a>
			</div>

		</div>
	</div>
</footer>
<!-- script -->
<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/interface.js"></script>
<script src="js/config.js"></script>
<!-- 도넛 차트 르러그인 -->
<script src="js/jquery.flot.min.js"></script>
<script src="js/jquery.flot.pie.min.js"></script>

<script type="text/javascript" charset="UTF-8">

//todolist date 설정 위한 함수
	function selectCheck(value){
	var chk=value;
	//var chk=document.getElementsByName("tdno").value;
	//var chk=forminfo.tdno.value;
	var d;
	var tddate;
	var tdstart
	console.log(chk);
	<c:forEach items="${tlist }" var="tlist">
	d=${tlist.tdno};
	if(d==chk){
		tddate="${tlist.tddate}";
		tdstart="${tlist.tdstart}"
		console.log("date: "+"${tlist.tddate}");
		$("#subdate").empty();
		$("#subdate").append("<label>마감일</label> <input type='date' class='form-control' name='tldate' min="+tdstart+" max="+tddate+">");
		$("#startdate").empty();
		$("#startdate").append("<label>시작일</label> <input type='date' class='form-control' name='tlstart' min="+tdstart+" max="+tddate+">");
	}
	</c:forEach>
}


</script>


</body>
</html>