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
	
	
	$(".knob").knob({
	      /*change : function (value) {
	       //console.log("change : " + value);
	       },
	       release : function (value) {
	       console.log("release : " + value);
	       },
	       cancel : function () {
	       console.log("cancel : " + this.value);
	       },*/
	      draw: function () {

	        // "tron" case
	        if (this.$.data('skin') == 'tron') {

	          var a = this.angle(this.cv)  // Angle
	              , sa = this.startAngle          // Previous start angle
	              , sat = this.startAngle         // Start angle
	              , ea                            // Previous end angle
	              , eat = sat + a                 // End angle
	              , r = true;

	          this.g.lineWidth = this.lineWidth;

	          this.o.cursor
	          && (sat = eat - 0.3)
	          && (eat = eat + 0.3);

	          if (this.o.displayPrevious) {
	            ea = this.startAngle + this.angle(this.value);
	            this.o.cursor
	            && (sa = ea - 0.3)
	            && (ea = ea + 0.3);
	            this.g.beginPath();
	            this.g.strokeStyle = this.previousColor;
	            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, sa, ea, false);
	            this.g.stroke();
	          }

	          this.g.beginPath();
	          this.g.strokeStyle = r ? this.o.fgColor : this.fgColor;
	          this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, sat, eat, false);
	          this.g.stroke();

	          this.g.lineWidth = 2;
	          this.g.beginPath();
	          this.g.strokeStyle = this.o.fgColor;
	          this.g.arc(this.xy, this.xy, this.radius - this.lineWidth + 1 + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false);
	          this.g.stroke();

	          return false;
	        }
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


</script>


</body>
</html>