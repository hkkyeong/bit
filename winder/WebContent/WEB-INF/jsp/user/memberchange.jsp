<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberchange" method="get">
<h2 align="center">회원 수정 창</h2>
아이디: <input type="text" value=<%=request.getParameter("id") %> name="id"/><br>
비밀번호: <input type="password" name="password"/><br>
이름: <input type="text" value=<%=request.getParameter("name") %> name="name"/><br>
이메일: <input type="text" value=<%=request.getParameter("email") %> name="email"/><br>
<input type="submit" value="수정" name="chk"/>
<input type="reset" value="취소"/>
</form>
</body>
</html>