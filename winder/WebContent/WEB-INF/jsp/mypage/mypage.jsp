<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />
 
 ${teammenu }
 <div class="content-wrapper">
            <div class="container">
            
            <div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">My page</h1>
				</div>
			</div>
			
			
			 <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            upload
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <!-- <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr> -->
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Name : </td>
                                            <td>${member.name }</td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                        <tr>
                                            <td>phone : </td>
                                            <td>${member.phone }</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>email : </td>
                                            <td>${member.email }</td>
                                            <td></td>
                                            <td></td> 
                                        </tr>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                        
                        <div class="panel-footer">
                            <a href="profileupdateform" class="btn btn-default"><i class=" fa fa-refresh "></i> Update</a>
                            <a href="passwordupdateform?" class="btn btn-default"><i class=" fa fa-refresh "></i> password update</a>
                        </div>
                    </div>
                
                </div>
                <div class="col-md-6 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	Team Info
                        </div>
                         <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <!-- <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr> -->
                                    </thead>
                                    
                                    <tbody>
                                    	<c:forEach items="${teammenu }" var="tmenu">
	                                    
	                                  	 <tr>
	                                  	 	<td> teamname : </td>
                                            <td>${tmenu.name }  </td>
                                            <td> </td>
                                            <td>  <a href="teamdelete?tno=${tmenu.tno }" class="btn btn-danger btn-sm"><i class=" fa fa-refresh "></i>DEL</a></td>
                                        </tr>
	                                   
	                                    </c:forEach>
                                       
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="panel-footer">
                        </div>
                    </div>
                </div>
                </div>
                
                
                <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            Message
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <!-- <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr> -->
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Sender</td>
                                            <td>Message Content</td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                        <tr>
                                           <td>Sender</td>
                                            <td>Message Content</td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                        <tr>
                                            <td>Sender</td>
                                            <td>Message Content</td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                        
                        <div class="panel-footer">
                            <a href="#" class="btn btn-default">write</a>
                        </div>
                    </div>
                
                </div>
                
             </div>
              
        </div><!-- container end -->
    </div><!-- content-wrapper  -->



<jsp:include page="../footer.jsp" />