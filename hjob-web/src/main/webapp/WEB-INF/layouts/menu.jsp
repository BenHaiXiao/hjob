
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!--左侧导航开始-->
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear">
                            <span class="block m-t-xs"><strong class="font-bold">海贼</strong></span>
                            <span class="text-muted text-xs block">系统管理员<b class="caret"></b></span>
                        </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="/user-mgr">修改信息</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="/j_logout">安全退出</a>
                        </li>
                    </ul>
                </div>
                <div class="logo-element">YJ
                </div>
            </li>
            <li>
                <a href="/">
                    <i class="fa fa-home"></i> <span class="nav-label">主页</span>
                </a>
            </li>
            <li>
                <a href="#" style="color: #ff3e21;">
                    <i class="fa fa-terminal"></i>
                    <span class="nav-label">开发工具</span>
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/job/mgr">任务管理</a>
                    </li>
               </ul>
            </li>








        </ul>
    </div>
</nav>
<!--左侧导航结束-->