<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
<form id="commonForm" name="commonForm"></form>
<!-- script -->
<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.bpopup.min.js"></script>
<script src="js/common.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$("a[name='file']").on("click", function(e) { //파일 이름
			 e.preventDefault(); 
			fn_downloadFile($(this));
		});
	});

	function fn_downloadFile(obj) {
		var uno = obj.parent().find("#UNO").val();	
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("downloadFile");
		comSubmit.addParam("UNO", uno);
		comSubmit.submit();
	}
	
	
	
	
	
	//todolist date 설정 위한 함수
 	function selectCheck(forminfo){
		var chk=forminfo.tdno.value;
		var d;
		var tddate;
		var tdstart
		<c:forEach items="${tlist }" var="tlist">
		d=${tlist.tdno};
		if(d==chk){
			tddate="${tlist.tddate}";
			tdstart="${tlist.tdstart}"
			console.log("date: "+"${tlist.tddate}");
			$("#subdate").empty();
			$("#subdate").append("<label>마감일</label> <input type='date' class='form-control' name='tldate' max="+tddate+">");
			$("#startdate").empty();
			$("#startdate").append("<label>시작일</label> <input type='date' class='form-control' name='tlstart' min="+tdstart+">");
		}
		</c:forEach>
	} 
	
	
</script>
</body>
</html>