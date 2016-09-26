<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="header_basic.jsp" />
<jsp:include page="nav.jsp" />
<jsp:include page="menu_basic.jsp" />

<div class="row">
<p>abc</p>


<span class="_img _inl fx" thumburl="http://mblogthumb3.phinf.naver.net/20160926_14/kcw676912_1474862120109lt5uV_JPEG/%C3%B6%B5%B5%C1%F6%C7%CF%C3%B6%C6%C4%BE%F7_00002.jpg?type="></span>
<!-- 
span -> img
class="_img _inl fx" thumburl -> src
?type="> -> ?type=w2">
 -->

<c:forEach items="${abc }" var="abc">

${abc.abc }

</c:forEach>
</div>

<jsp:include page="footer.jsp" />