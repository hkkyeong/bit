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
String msg=(String)session.getAttribute("msg");
if(((String)session.getAttribute("msg"))==null){
	msg="";
}
%>
<%=msg %>
<form action="memberjoin" method="post">
<h2 align="center">회원 가입 창</h2>
아이디: <input type="text" name="id"/><br>
비밀번호: <input type="password" name="password"/><br>
이름: <input type="text" name="name"/><br>
이메일: <input type="text" name="email"/><br>
<input type="submit" value="가입" name="chk"/>
<input type="submit" value="취소" name="cancel"/>
</form>
</body>
</html>