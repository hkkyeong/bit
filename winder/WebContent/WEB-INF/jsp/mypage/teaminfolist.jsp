<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />

			<div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">Mypage > Team Info</h1>
				</div>
			</div>
			
			
			
			
			
			
			<c:forEach items="${abc }" var="aa">
			<div class="col-md-6 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	Team Info 
                        </div>
                        
                         <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    </thead>
                                    
                                    <tbody>
                                      <tr>
	                                  	 	<td><b>Team leader :</b></td>  
	                                  	 	 <c:forEach items="${aa}" var="bb">
	                                 			<c:set var="name" value="${bb.position }"></c:set>
                                        	 </c:forEach>  
	                                 		<%
	                                 			String name=(String)pageContext.getAttribute("name");
	                                 			if(name.equals(session.getAttribute("id"))){
	                                 		%>
	                                 		
                                            <td>${tinfo.leader }(Me) </td>
                                            <td><a href="teamdelete?tno=${tinfo.tno }" class="btn btn-danger btn-sm">Team delete</a> </td>
                                            <%
                                            }else{
                                            	
                                            %>
                                            <td>${tinfo.leader }</td>
                                            <td><a href="teamout?tno=${tinfo.tno }" class="btn btn-danger btn-sm">Out of Team</a> </td>
                                            <%} %>
                                            <td> </td>
                                        </tr>
                                    
                                    	<tr>
	                                  	 	<td> <b>Team No. :</b></td>
                                            <td>${tinfo.tno }  </td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                    	<tr>
	                                  	 	<td> <b>Team name :</b> </td>
                                            <td>${tinfo.name }  </td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                        
                                      
                                        
                                        <tr>
	                                  	 	<td><b>Team member :</b></td>
	                                  	 	<td> </td>
                                            <td> </td>
                                          
                                            <td> </td>
                                        
                                        </tr>
                                        <tr>
                                        <c:forEach items="${aa}" var="bb">
                                        	 <td>${tinfomembers.id }</td>
                                         </c:forEach> 
                                       </tr>
                                       <tr></tr>
             
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="panel-footer">
                        </div>
                    </div>
                </div>
			</c:forEach>
			
			
			
			
			
			
			
 			<c:forEach items="${teaminfo }" var="tinfo">
 				<div class="col-md-6 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	Team Info 
                        </div>
                        
                         <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    </thead>
                                    
                                    <tbody>
                                      <tr>
	                                  	 	<td><b>Team leader :</b></td>   
	                                 		<c:set var="name" value="${tinfo.leader }"></c:set>
	                                 		<%
	                                 			String name=(String)pageContext.getAttribute("name");
	                                 			if(name.equals(session.getAttribute("id"))){
	                                 		%>
	                                 		
                                            <td>${tinfo.leader }(Me) </td>
                                            <td><a href="teamdelete?tno=${tinfo.tno }" class="btn btn-danger btn-sm">Team delete</a> </td>
                                            <%
                                            }else{
                                            	
                                            %>
                                            <td>${tinfo.leader }</td>
                                            <td><a href="teamout?tno=${tinfo.tno }" class="btn btn-danger btn-sm">Out of Team</a> </td>
                                            <%} %>
                                            <td> </td>
                                        </tr>
                                    
                                    	<tr>
	                                  	 	<td> <b>Team No. :</b></td>
                                            <td>${tinfo.tno }  </td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                    	<tr>
	                                  	 	<td> <b>Team name :</b> </td>
                                            <td>${tinfo.name }  </td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                        
                                      
                                        
                                        <tr>
	                                  	 	<td><b>Team member :</b></td>
	                                  	 	<td> </td>
                                            <td> </td>
                                          
                                            <td> </td>
                                        
                                        </tr>
                                        <tr>
                                          <c:forEach items="${tinfo.members }" var="tinfomembers">
                                            <td>${tinfomembers.id }</td>
                                          </c:forEach>
                                       </tr>
                                       <tr></tr>
             
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="panel-footer">
                        </div>
                    </div>
                </div>
 			</c:forEach>
 
 
<jsp:include page="../footer.jsp" />