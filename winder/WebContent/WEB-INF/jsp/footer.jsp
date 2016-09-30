<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
/* 	$(function() {
		$('#my-button').on('click', function(e) {
			e.preventDefault();
			$('#element_to_pop_up').bPopup({
				modalClose : false,
				opacity : 0.6,
				positionStyle : 'fixed' //'fixed' or 'absolute'
			});

		});

	}); */

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
		//comSubmit.addParam("UNO", uno);
		comSubmit.addParam("UNO", uno);
		console.log("aaaa");
		comSubmit.submit();
	}
</script>
</body>
</html>