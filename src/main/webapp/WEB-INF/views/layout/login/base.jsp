<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Remove Tap Highlight on Windows Phone IE -->
    <meta name="msapplication-tap-highlight" content="no"/>
    <sitemesh:decorate decorator="/WEB-INF/views/layout/css.jsp" />
    <sitemesh:write property="head" />
    <title>Mapping Manager System - <sitemesh:write property='title' /></title>
</head>
<body class="login_page">
<div id="page_content">
    <div id="page_content_inner">
        <sitemesh:write property="body" />
    </div>
</div>
<sitemesh:decorate decorator="/WEB-INF/views/layout/script.jsp" />
<sitemesh:write property="page.scripts" />
</body>
</html>
