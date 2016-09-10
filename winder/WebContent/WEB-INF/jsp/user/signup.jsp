<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../header_basic.jsp" />
<jsp:include page="../nav.jsp" />
<jsp:include page="../menu_basic.jsp" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login form.</title>
</head>
<body>
<%
    String id=null;
    String password=null;
    
%>




<div class="row" id="tagtest">
    <div class="col-md-12">
        <h4 class="page-head-line">Sign up form</h4>
    </div>
    
    <div class="content-wrapper">
        <div class="container">
            <div class="row">
                

            </div>
            <div class="row">
    
                <div class="col-md-6">
                   <h4> Login with facebook <strong> / </strong>Google :</h4>
                    <br />
                    <a href="index.html" class="btn btn-social btn-facebook">
                            <i class="fa fa-facebook"></i>&nbsp; Facebook Account</a>
                    &nbsp;OR&nbsp;
                    <a href="index.html" class="btn btn-social btn-google">
                            <i class="fa fa-google-plus"></i>&nbsp; Google Account</a>
                    <hr />
                     <h4> Or Sign up <strong>Winder Account  :</strong></h4>
                    <br />
                    
                     <form action="signchk" method="post">
                     <label>input new ID : </label>
                        <input type="text" name="id" class="form-control" />
                        <label>input Name : </label>
                        <input type="text" name="name" class="form-control" />
                        <label>input new Password :  </label>
                        <input type="password" name="password" class="form-control" /><br>
                        <label>Again input password :  </label>
                        <input type="password" name="password1" class="form-control" /><br>
                        <label>input email :  </label>
                        <input type="text" name="email" class="form-control" /><br>
                        <label>Input phone :  </label>
                        <input type="text" name="phone" class="form-control" /><br>
                      
                        <hr />
                        
                      	<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-user"></span> &nbsp;Sign Me up!</button>&nbsp;
                        </form>
                        
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

            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer.jsp" />
</body>
</html>