<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<c:if test="${kind eq 'pro' }">
<jsp:include page="../menu_project.jsp" />
</c:if>
<c:if test="${kind eq 'my' }">
<jsp:include page="../menu_mypage.jsp" />
</c:if>

<div class="row">
<div class="row">   
	<div class="col-md-12">
		<h4 class="page-head-line"><%=request.getAttribute("title")%></h4>
		${scrapcontent }
		
	</div>
</div>

</div>

<jsp:include page="../footer.jsp" />