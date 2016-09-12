<%@page import="winder.vo.TeamVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_team.jsp" />

		<div class="row">
			<div class="col-md-12">
				<h1 class="page-head-line">Mypage > Profile</h1>
			</div>
		</div>
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">Profile</div>
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
                                            <td>ID : </td>
                                            <td><%=session.getAttribute("id") %></td>
                                            <td> </td>
                                            <td> </td>
                                        </tr>
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

</div>

<jsp:include page="../footer.jsp" />