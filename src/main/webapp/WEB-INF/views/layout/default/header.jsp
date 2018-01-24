<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>header</title>
</head>
<body>
<!-- main header -->
<header id="header_main">
    <div class="header_main_content">
        <div class="header_left_con uk-float-left">
            <nav class="uk-navbar">
                <a href="#" id="sidebar_main_toggle" class="sSwitch sSwitch_left">
                    <span class="sSwitchIcon sc_sSwitchIcon"></span>
                </a>
            </nav>
            <div class="header_main_text">
                <h4>Mapping Manager System</h4>
                <div>${nowDate}</div>
            </div>
        </div>
        <div class="uk-float-right">
            <ul class="uk-tab">
                <li class="uk-active"><a href="#">Welcome!<span class="padding-left10"><sec:authentication property="principal.username"></sec:authentication></span></a></li>
                <li><a href="#" onclick="cfn.logout('<c:url value="/common/logout/logout.do" />')">로그아웃</a></li>
            </ul>
        </div>
    </div>
</header>
<!-- main header end -->
</body>
</html>
