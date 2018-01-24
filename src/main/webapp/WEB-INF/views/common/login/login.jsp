<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/login_page.min.css" />" media="all">
    <title>로그인</title>
</head>

<body>
<div class="login_page_wrapper">
    <h5>매핑 관리 시스템 입니다.</h5>
    <div class="md-card" id="login_card">
        <div class="md-card-content large-padding login-padding" id="login_form">
            <form name="login_form" method="post" action="<c:url value="/j_spring_security_check" />">
                <div class="uk-form-row">
                    <label for="sid">아이디</label>
                    <input class="md-input login-input" type="text" id="sid" name="j_username" value="" maxlength="20" />
                </div>
                <div class="uk-form-row form-margin-top">
                    <label for="pw">비밀번호</label>
                    <input class="md-input login-input" type="password" id="pw" name="j_password" value="" maxlength="20"  />
                </div>
                <div class="uk-margin-medium-top">
                    <a href="#" class="md-btn md-btn-primary md-btn-block md-btn-large md-bg-red-400 btn-login">로그인</a>
                </div>
            </form>
        </div>
    </div>
</div>
<content tag="scripts">
<script>
    $(document).ready(function () {
<c:if test="${not empty param.fail && not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION']}">
        alert('일치하는 정보가 없습니다.');
    <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
</c:if>
        $('.btn-login').on('click', function () {
            $('form[name=login_form]').submit();
        });
    });
</script>
</content>
</body>
</html>
