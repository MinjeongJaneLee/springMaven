<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="pageRows" type="java.lang.Integer" required="true" %>
<%@ attribute name="pageNo" type="java.lang.Integer" required="true" %>
<%@ attribute name="totalCount" type="java.lang.Integer" required="true" %>
<%@ attribute name="callback" required="true" %>
<%@ attribute name="blockSize" type="java.lang.Integer" %>
<c:if test="${blockSize == null}">
    <c:set var="blockSize" value="10"></c:set>
</c:if>
<fmt:formatNumber pattern="###" var="blockNo" value="${((pageNo + pageRows) - ((pageNo + pageRows) % pageRows)) / pageRows - ((pageNo + pageRows) % pageRows == 0 ? 1 : 0)}" minFractionDigits="0"></fmt:formatNumber>
<fmt:formatNumber pattern="###" var="startPage" value="${(blockNo - 1) * blockSize + 1}" minFractionDigits="0"></fmt:formatNumber>
<fmt:formatNumber pattern="###" var="lastPage" value="${(totalCount - (totalCount % pageRows)) / pageRows + 1 - (totalCount % pageRows == 0 ? 1 : 0)}" minFractionDigits="0"></fmt:formatNumber>
<div class="paginate">
    <ul class="uk-pagination sc-pagination-btn">
<c:if test="${startPage > blockSize}">
        <li><a href="javascript:${callback}(${pageRows}, 1)" class="first"><i class="uk-icon-angle-double-left"></i></a></li>
        <li><a href="javascript:${callback}(${pageRows}, ${(blockNo - 2) * blockSize + 1})" class="previous paginate_button paginate_button"><i class="uk-icon-angle-left"></i></a></li>
</c:if>
<c:forEach begin="1" end="${blockSize}" step="1" varStatus="status">
    <c:if test="${((status.index - 1) + startPage) <= lastPage}">
        <c:choose>
            <c:when test="${((status.index - 1) + startPage) == pageNo}">
                <li class="uk-active"><a class="choice">${(status.index - 1) + startPage}</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="javascript:${callback}(${pageRows}, ${(status.index - 1) + startPage})">${(status.index - 1) + startPage}</a></li>
            </c:otherwise>
        </c:choose>
    </c:if>
</c:forEach>
<c:if test="${(blockNo * blockSize) < lastPage}">
        <li><a href="javascript:${callback}(${pageRows}, ${blockNo * blockSize + 1})" class="next"><i class="uk-icon-angle-right"></i></a></li>
        <li><a href="javascript:${callback}(${pageRows}, ${lastPage})" class="last"><i class="uk-icon-angle-double-right"></i></a></li>
</c:if>
    </ul>
</div>