<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 </div>
    </div>
    <!-- CONTENT-WRAPPER SECTION END-->
    <footer>
        <div class="container">
            <div class="row">
               <div class="col-md-12">
                    &copy; 2016 Winder
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
     $(function() {
        $('#my-button').on('click', function(e) {
           e.preventDefault();
           $('#element_to_pop_up').bPopup({
        	   modalClose: false,
               opacity: 0.6,
               positionStyle: 'fixed' //'fixed' or 'absolute'
           });

       }); 
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
     
     function fn_downloadFile(obj) {
 		var comSubmit = new ComSubmit();
 		comSubmit.setUrl("downloadFile");
 		comSubmit.addParam("UNO", uno);
 		comSubmit.submit();
 	}
     
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


</script>
</body>
</html>