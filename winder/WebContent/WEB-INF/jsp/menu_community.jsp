<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<section class="menu-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            <li><a class="menu-top" href="home">Home</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Team<i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu">
                                	<li><a href="teamList">팀 List</a></li>
                                    <li><a href="teamCreateform">팀 생성</a></li>
                                    <c:forEach items="${teammenu }" var="tmenu">
                                    <li><a href="projectlist?tno=${tmenu.tno }">${tmenu.name }</a></li>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Project<i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu">
                                    <li><a href="projectform">프로젝트 생성</a></li>
                                    <c:forEach items="${projectmenu }" var="pmenu">
                                    <li><a href="projectmain?pno=${pmenu.pno }">${pmenu.name }</a></li>
                                    </c:forEach>
                                </ul>
                            </li>
                             <li><a href="mypage" >My Page</a></li>
							 <li><a class="menu-top-active" href="communitylist">community</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">