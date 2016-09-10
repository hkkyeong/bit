
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<%
	String id=(String)session.getAttribute("id");
	%> 
	<a href="/springGuestbook/logout">로그아웃</a>
	<P>${sessionScope.id } 님 환영합니다
	</p>
	<h1 align="center">회원 목록</h1>
	<table>
		<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>가입일</th>
		</tr>
		<c:forEach items="${memberlist }" var="member">
		<tr>
		<td>${member.id}</td>
		<td>${member.name}</td>
		<td>${member.password}</td>
		<td>${member.email}</td>
		<td>${member.regdate}</td>
		<td>
		<form action="memberchangepage">
		<input type="hidden" value="${member.id}" name="id">
		<input type="hidden" value="${member.name}" name="name">
		<input type="hidden" value="${member.email}" name="email">
		<c:if test="${member.id eq sessionScope.id}">
		<input type="submit" value="수정" name="chk"/>
		</c:if>
		</form>
		<form action="memberdelete">
		<input type="hidden" value="${member.id}" name="id">
		<c:if test="${member.id eq sessionScope.id}">
		<input type="submit" value="삭제" name="chk"/>
		</c:if>
		</form>
		</td>
		</tr>
		</c:forEach>
	</table>
	<form action="../guestbook/guestbooklist">
<%-- 	<%
	session=request.getSession();
	session.setAttribute("id", id);
	%> --%>
		<input type="submit" value="방명록 목록">
	</form>
</body>
</html>