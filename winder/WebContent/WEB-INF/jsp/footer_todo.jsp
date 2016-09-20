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

var count=1;

var done=${done};
var size=${size};
var per;

$(function abc() {
	
	
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
	color : "#0073b7"
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


var tlno;

function drag(target, e) {		//드래그 시작시 호출 할 함수
	e.dataTransfer.setData('Text', target.id);

};
function drop(target, e) {		//드롭시 호출 할 함수
	var id = e.dataTransfer.getData('Text');
	target.appendChild(document.getElementById(id));
	e.preventDefault();	
	var url="statetodo?pno="+${pno}+"&tlno="+tlno;
	$.ajax({
		url:url,
		dataType : 'json',
		/* dataType:"json", */
		success:function(data){
			size=data.size;
			done=data.done;
			dchart();
			$("#per").empty();
			$("#per").append("&nbsp;&nbsp;&nbsp;진행률: "+data.per+" %");
			url="bar?pno="+${pno};
			bar(url);
		},
		error:function(){
			alert("error 1");
		}
	});

};



function drag2(target, e) {		//드래그 시작시 호출 할 함수
	e.dataTransfer.setData('Text', target.id);

};
function drop2(target, e) {		//드롭시 호출 할 함수
	var id = e.dataTransfer.getData('Text');
	target.appendChild(document.getElementById(id));
	e.preventDefault();
	var url="statedone?pno="+${pno}+"&tlno="+tlno;
	$.ajax({
		url:url,
		dataType : 'json',
		success:function(data){
			size=data.size;
			done=data.done;
			dchart();
			$("#per").empty();
			$("#per").append("&nbsp;&nbsp;&nbsp;진행률: "+data.per+" %");
			url="bar?pno="+${pno};
			bar(url);
		},
		error:function(){
			alert("error 2");
		}
	});

};

function tlnosend(obj){
	x=obj.attr('id');
	tlno=x;
};

function dchart(){
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
	color : "#0073b7"
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
};


//진행률 바
function bar(url){
	$.ajax({
		type: "post",
		url:url,
		dataType : 'json',
		success:function(data){		
			$("#progressbar").empty();
 			 $.each(data, function(key, value){
 				var Ca = /\+/g;
 				 var kkey=decodeURIComponent(key.replace(Ca, " "));
 				 var vvalue=decodeURIComponent(value);
				$("#progressbar").append(kkey+"<div class='progress progress-striped'>"+
						"<div class='progress-bar progress-bar-success' role='progressbar' aria-valuenow="+value+"aria-valuemin='0' aria-valuemax='100' style='width:"+
						value+"%'></div></div>");
				});  
			},
			error:function(){
				alert("error bar");
		}
	}); 
}

</script>


</body>
</html>