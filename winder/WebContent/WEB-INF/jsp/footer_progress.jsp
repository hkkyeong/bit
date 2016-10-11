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
<!-- 차트 플러그인 -->
<script src="js/jquery.knob.js"></script>

<script src="js/jquery.bpopup.min.js"></script>

<script type="text/javascript" charset="UTF-8">

var count=1;

var done=${done};
var size=${size};
var per;

$(function() {
	
	
	var data = [], totalPoints = 100;

    function getRandomData() {

      if (data.length > 0)
        data = data.slice(1);

      // Do a random walk
      while (data.length < totalPoints) {

        var prev = data.length > 0 ? data[data.length - 1] : 50,
            y = prev + Math.random() * 10 - 5;

        if (y < 0) {
          y = 0;
        } else if (y > 100) {
          y = 100;
        }

        data.push(y);
      }

      // Zip the generated y values with the x values
      var res = [];
      for (var i = 0; i < data.length; ++i) {
        res.push([i, data[i]]);
      }

      return res;
    }
	
    per=done/size*100.0;
	var temp=Math.floor(per);
	
	var donutData = [
{
	
	label : "to do",
	data : 100-temp,
	color : "#d2d6de"
}, {
	label : "done",
	data : temp,
	color : "rgb(57, 204, 204)"
}
];
	$.plot("#donut-chart", donutData, {
		series : {
			pie : {
				show : true,
				radius : 1,
				innerRadius : 0.4,
				label : {
					show : true,
					radius : 2 / 3,
					formatter : labelFormatter,
					threshold : 0.1
				}

			}
		},
		legend : {
			show : false
		}
	});

	
});

/*
* Custom Label formatter
* ----------------------
*/
function labelFormatter(label, series) {
return '<div style="font-size:13px; text-align:center; padding:2px; color: #fff; font-weight: 600;">'
    + label
    + "<br>"
    +"</div>";
};

function pop(content, id, pno){

        $('#element_to_pop_up3').bPopup({
     	   modalClose: false,
            opacity: 0.6,
            positionStyle: 'fixed' //'fixed' or 'absolute'
        });
        $("#out").empty();
        $("#out").append("<lablel> 버튼을 누르면  해당 멤버에게 알림 메시지가 갑니다. </label><br><br><br><button type='submit' class='btn btn-default'>확인</button>"+
        		"<input type='hidden' name='content' value='"+content+"'>"+
        		"<input type='hidden' name='pno' value="+pno+">"+
        		"<input type='hidden' name='sid' value="+id+">");
};

</script>


</body>
</html>