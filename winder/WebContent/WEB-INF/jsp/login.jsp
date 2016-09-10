
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
String loginchk=(String)session.getAttribute("loginchk");
String id=null;
String msg=null;
if(((String)session.getAttribute("id"))==null){
	id="";
	msg="";
}else{
	msg=(String)session.getAttribute("msg");
	id=(String)session.getAttribute("id");
	session.removeAttribute("msg");
}
%>
<%=msg%>
<h1>로그인</h1>
<form action="loginchk" method="post"> <!-- default는 get으로 설정되어 있음 post 방식 쓰면 주소창에 값 나오지 않음-->
아이디: <input type="text" value="<%=id%>" name="id"/><br>
비밀번호: <input type="password" name="password"/><br>
<input type="submit" value="로그인"/>
<input type="submit" value="가입" name="join"/>
</form>
 <img src="img/dd.jpg"> 
<!-- <form action="member.sku">
<input type="submit" value="가입"/>
</form> -->
</body>
</html>