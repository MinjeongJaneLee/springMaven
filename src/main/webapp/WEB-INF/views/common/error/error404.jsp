<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Remove Tap Highlight on Windows Phone IE -->
    <meta name="msapplication-tap-highlight" content="no"/>
    <link rel="icon" href="<c:url value="/css/uikit.almost-flat.min.css" />" type="image/x-icon">
    <link rel="stylesheet" href="<c:url value="/css/uikit.almost-flat.min.css" />" media="all">
    <link rel="stylesheet" href="<c:url value="/icons/flags/flags.min.css" />" media="all">
    <link rel="stylesheet" href="<c:url value="/css/main.min.css" />" media="all">
    <link rel="stylesheet" href="<c:url value="/css/error_page.min.css" />" media="all"/>
    <link rel="stylesheet" href="<c:url value="/css/change_style-dist.css" />" media="all">
    <title>Mapping Manager System</title>
</head>
<body class="error_page">

    <div class="error_page_header md-bg-red-500">
        <div class="uk-width-8-10 uk-container-center">
            404!
        </div>
    </div>
    <div class="error_page_content">
        <div class="uk-width-8-10 uk-container-center">
            <p class="heading_b">Page not found</p>
            <p class="uk-text-large">
                The requested URL <span class="uk-text-muted">/some_url</span> was not found on this server.
            </p>
            <a href="#" onclick="history.go(-1);return false;">Go back to previous page</a>
        </div>
    </div>

</body>
</html>