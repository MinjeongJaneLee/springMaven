<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>매핑목록</title>
</head>
<body>
<div class="page_check" data="mapping/mapping">
    <div class="page_sub_heading">
        <ul class="uk-breadcrumb">
            <li><i class="material-icons">&#xE88A;</i></li>
            <li><span>매핑관리</span></li>
            <li><span>매핑목록</span></li>
        </ul>
        <h3 class="heading_b uk-margin-bottom">매핑목록</h3>
    </div>
    <div class="uk-width-1-1">
        <div class="md-card">
            <div id="body" class="md-card-content">
                <div class="table-label-area">
                    <div class="page-rows-wrap">
                        <span class="search-all-style">
                            <span id="totalCount">전체</span>
                        </span>
                    </div>
                </div>
                <div class="uk-overflow-container">
                    <table class="uk-table uk-table-nowrap">
                        <thead>
                        <tr>
                            <th class="uk-text-center">test</th>
                            <th class="uk-text-center">test</th>
                            <th class="uk-text-center">test</th>
                            <th class="uk-text-center">test</th>
                            <th class="uk-text-center">test</th>
                            <th class="uk-text-center">test</th>
                            <th class="uk-text-center last">test</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="uk-text-center">test</td>
                                <td class="uk-text-center">test</td>
                                <td class="uk-text-center">test</td>
                                <td class="uk-text-center">test</td>
                                <td class="uk-text-center">test</td>
                                <td class="uk-text-center">test</td>
                                <td class="uk-text-center">test</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- // Job 스케쥴 설정 레이어 팝업 -->
<content tag="scripts">
<script type="text/javascript">
    $(document).ready(function () {
    });
</script>
</content>
</body>
</html>
