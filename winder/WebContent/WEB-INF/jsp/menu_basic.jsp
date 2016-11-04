<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<section class="menu-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            <li><a class="menu-top-active" href="home">Home</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Team<i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu">
                                	<li><a href="teamList">Team List</a></li>
                                	<li><a href="teaminfo">Team Management</a></li>

                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Project<i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu">
                                    <li><a href="projectlist">Project List</a></li>
                                    <li><a href="projectform">Project Create</a></li>
                                </ul>
                            </li>
                             <li><a class="menu-top" href="mypage">My Page</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">