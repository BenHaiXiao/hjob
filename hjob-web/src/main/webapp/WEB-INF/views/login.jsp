<%--
  Created by wjc133.
  Date: 2017/2/8
  Time: 15:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>《一件》管理后台 - 登录</title>
    <link rel="shortcut icon" href="${ctx}/static/favicon.ico">
    <link type="text/css" href="${ctx}/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link type="text/css" href="${ctx}/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link type="text/css" href="${ctx}/static/css/animate.css" rel="stylesheet">
    <link type="text/css" href="${ctx}/static/css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
</head>

<body class="gray-bg">

<div class="animated fadeInDown">
    <h1 class="logo-name" style="text-align: center;font-size: 100px;margin-top: 100px;">ONEPIECE</h1>
</div>
<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <h3>欢迎使用一件管理后台</h3>
        <form class="m-t" role="form" action="/j_spring_security_check" method="post">
            <div class="form-group">
                <input type="text" name="j_username" class="form-control" placeholder="海度通行证(dw_开头)" required="">
            </div>
            <div class="form-group">
                <input type="password" name="j_password" class="form-control" placeholder="密码" required="">
            </div>
            <c:if test="${needDynamic}">
                <div class="form-group">
                    <input type="password" name="dynamic" class="form-control" placeholder="动态密码" required="">
                </div>
            </c:if>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <p class="text-muted text-center">首次登陆请联系吴健成(909014825)开通权限</p>
        </form>
    </div>
</div>

<!-- 全局js -->
<script src="${ctx}/static/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctx}/static/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
</body>

</html>
