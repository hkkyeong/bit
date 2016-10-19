<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer = "none" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Winder</title>
    <link href="css/bootstrap.css" rel="stylesheet" />
    <link href="css/font-awesome.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
    
    
    
    <script src="js/html2canvas.js"></script>
    <script type="text/javascript">
        
        function capture() {
        	var vurl="imageCreate.ajax?pno="+${pno};
            html2canvas($(".rr"), {
                  onrendered: function(canvas) {
                    //document.body.appendChild(canvas);
                    //alert(canvas.toDataURL("image/png"));
                    
                    $("#imgSrc").val(canvas.toDataURL("image/png"));
                    
                    $.ajax({
                        type:     "post",
                        data : $("form").serialize(),
                        url:     vurl,
                        error: function(a, b, c){        
                            alert("fail!!");
                        },
                        success: function (data) {
                            try{
                                
                            }catch(e){                
                                alert('server Error!!');
                            }
                        }
                    });
                  }
            
            
            });
 
        }     
   </script>
    
    
    
    
    
    <style type="text/css">
#element_to_pop_up, #element_to_pop_up2 { 
    background-color:#fff;
    border-radius:15px;
    color:#000;
    display:none; 
    padding:20px;
    min-width:600px;
    min-height: 380px;
}
#element_to_pop_up3 { 
    background-color:#fff;
    border-radius:15px;
    color:#000;
    display:none; 
    padding:20px;
    min-width:400px;
    min-height: 160px;
}
.b-close{
    cursor:pointer;
    position:absolute;
    right:10px;
    top:5px;
}

</style>

</head>
