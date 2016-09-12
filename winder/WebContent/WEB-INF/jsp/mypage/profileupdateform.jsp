<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header_basic.jsp" /> 
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_mypage.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


					<div class="row">
						<div class="col-md-12">
							<h4 class="page-head-line">profile update</h4>
						</div>
					</div>
			  					<div class="col-md-6">
			                        <div class="panel panel-default">
			                        <div class="panel-heading">
			                          PROFILE UPDATE FORM 
			                        </div>
			                        <div class="panel-body">
                            			<form action="profileupdate" method="post">
                                        
                                        <div class="form-group has-success">
                                            <label class="control-label" for="success">Member Name</label>
                                            <input type="text" class="form-control" name="name" id="success" placeholder="${member.name}" value="${member.name }"/>
                                        </div>
                                        <div class="form-group has-success">
                                            <label class="control-label" for="success">Member Email</label>
                                            <input type="text" class="form-control" name="email" id="success" placeholder="${member.email }" value="${member.email}"/>
                                        </div>
                                        <div class="form-group has-success">
                                            <label class="control-label" for="success">Member Phone</label>
                                            <input type="text" class="form-control" name="phone" id="success" placeholder="${member.phone }" value="${member.phone}"/>
                                        </div>
                                        
                                        
                                        <hr/>
                                        <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-user"></span> &nbsp;update</button>&nbsp;
                                    </form>
                            <hr />
                           
                        </div>
                            </div>
                        </div>
                         <div class="col-md-6">
                    <div class="alert alert-info">
                        This is a free bootstrap admin template with basic pages you need to craft your project. 
                        Use this template for free to use for personal and commercial use.
                        <br />
                         <strong> Some of its features are given below :</strong>
                        <ul>
                            <li>
                                Responsive Design Framework Used
                            </li>
                            <li>
                                Easy to use and customize
                            </li>
                            <li>
                                Font awesome icons included
                            </li>
                            <li>
                                Clean and light code used.
                            </li>
                        </ul>
                       
                    </div>
                    <div class="alert alert-success">
                         <strong> Instructions To Use:</strong>
                        <ul>
                            <li>
                               Lorem ipsum dolor sit amet ipsum dolor sit ame
                            </li>
                            <li>
                                 Aamet ipsum dolor sit ame
                            </li>
                            <li>
                               Lorem ipsum dolor sit amet ipsum dolor
                            </li>
                            <li>
                                 Cpsum dolor sit ame
                            </li>
                        </ul>
                       
                    </div>
                </div>

</body>
</html>