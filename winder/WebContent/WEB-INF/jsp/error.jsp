<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>
<jsp:include page="header_basic.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_basic.jsp" />
<div class="row">
<div class="form-group">
	<img src="img/error.jpg" style=" width: 100%;">
</div>
</div>


<jsp:include page="footer.jsp" />