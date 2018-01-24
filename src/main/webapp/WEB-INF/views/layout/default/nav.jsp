<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>navigator</title>
</head>
<body>
<!-- main sidebar -->
<aside id="sidebar_main" class="bidding_type_a">
    <div class="sidebar_main_header">
        <h1>Mapping Manager System</h1>
    </div>
    <div class="menu_section md-card">
        <ul class="padding">
            <li>
                <a href="#">
                    <span class="menu_icon"><i class="material-icons">&#xE85C;</i></span>
                    <span class="menu_title">매핑 관리</span>
                </a>
                <ul style="display: block;">
                    <li><a href="<c:url value="/mapping/mapping.do" />">매핑목록</a></li>
                </ul>
            </li>
        </ul>
    </div>
</aside>
<!-- main sidebar end -->
</body>
</html>