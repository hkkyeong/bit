
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="winder.vo.TeamVO"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />
<div class="row">   
	<div class="col-md-12">
		<h4 class="page-head-line">Scrap</h4>
		제목 : <%=request.getAttribute("title")%> <br>
		내용 : <%=request.getAttribute("content") %>
		<img alt="" src="<%=request.getAttribute("img")%>">
		
		<%-- content: <%=request.getAttribute("str2")%>  --%>
	</div>
</div>
 
</div>
</div>
</div>
</div>

<jsp:include page="../footer.jsp" />