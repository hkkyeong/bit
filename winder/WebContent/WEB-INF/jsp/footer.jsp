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
			<div class="col-md-12">&copy; 2016 Winder</div>
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

var uno;
function unosubmit(obj){
	 x=obj.attr('id');
	 uno=x;
}

	$(document).ready(function() {
		$("a[name='file1']").on("click", function(e) { //파일 이름
			 e.preventDefault(); 
			fn_downloadFile($(this));
		});
	});

	function fn_downloadFile(obj) {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("downloadFile");
		comSubmit.addParam("UNO", uno);
		comSubmit.submit();
	}
	
	
	////////////////////////////////////////막기
	function addM(tno, tname)
	{
		var add
		var id =document.getElementById('id').value

		add = confirm("팀으로 초대 요청 메시지를 보내시겠습니까?")

		if (add == true) {
			location.href = "inviteMember?tno" + tno +"&id="+id
		} else {
			alert("취소되었습니다!")
			location.href = "redirect:/mypage"
		}
	}
	
	function delTeam(tno)
	{
		var del
	
		del = confirm("정말 삭제하시겠습니까?")

		if (del == true) {
			location.href = "teamdelete?tno" + tno
		} else {
			alert("취소되었습니다!")
			location.href = "redirect:/teaminfo"
		}
	}
	
	function teamOut(tno,id)
	{
		var out

		out = confirm("정말 팀에서 "+id+"를 삭제하시겠습니까?")

		if (out == true) {
			location.href = "teamout?tno" + tno
		} else {
			alert("취소되었습니다!")
			location.href = "redirect:/teaminfo"
		}
	}
	
</script>
</body>
</html>