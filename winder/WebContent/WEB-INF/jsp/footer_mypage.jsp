<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 </div>
    </div>
    <!-- CONTENT-WRAPPER SECTION END-->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    &copy; 2015 YourCompany | By : <a href="http://www.designbootstrap.com/" target="_blank">DesignBootstrap</a>
                </div>

            </div>
        </div>
    </footer>
    <!-- script -->
<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.bpopup.min.js"></script>

<script type="text/javascript">
     $(function() {
      /*  $('#my-button').on('click', function(e) {
           e.preventDefault();
           $('#element_to_pop_up').bPopup({
        	   modalClose: false,
               opacity: 0.6,
               positionStyle: 'fixed' //'fixed' or 'absolute'
           });

       }); */
    	 $('#file').on('click', function(e) {
             e.preventDefault();
             $('#element_to_pop_up').bPopup({
          	   modalClose: false,
                 opacity: 0.6,
                 positionStyle: 'fixed' //'fixed' or 'absolute'
             });

         });
    	 $('#scrap').on('click', function(e) {
             e.preventDefault();
             $('#element_to_pop_up2').bPopup({
          	   modalClose: false,
                 opacity: 0.6,
                 positionStyle: 'fixed' //'fixed' or 'absolute'
             });

         });

   });  

var id;
//멤버 선택시 호출 함수
function idsend(){
	size=document.all.id.length;
	console.log(size);
	for(var i=0; i<size; i++){
		if(document.all.id[i].checked){
			var id=document.all.id[i].value;
			break;
		}
	}
	$("#out").empty();
	$("#out").append("<label name="+id+" value="+id+"> ID: "+id+
			"</label><br><label>강제 탈퇴 사유</label><textarea class='form-control' rows='3' name='reason' ></textarea><br><button type='submit' class='btn btn-default'>강제 탈퇴</button>"+
			"<input type='hidden' name='id' value="+id+">");
};

</script>
</body>
</html>