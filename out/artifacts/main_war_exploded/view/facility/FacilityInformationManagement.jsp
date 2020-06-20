<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/FacilityManagement.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
    <title>시설정보관리</title>
</head>
<body>
    <%@include file="../default/header.jsp"%>

<div class="sidebar">
    <div>
        <ul class="sidebar-content">
            <li>시설관리</li>
            <li>시설정보관리</li>
        </ul>
    </div>
</div>
<div class="content-container">
    <div id = "content-name">
        시설 정보 조회
    </div>
    <div class="content">
        <table border="1">
            <tr>
                <th>No.</th>
                <th>시설명</th>
                <th>시설 상태</th>
                <th>시설 담당자</th>
                <th>전화번호</th>
                <th>선택</th>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th><input type="checkbox"></th>
            </tr>
        </table>
        <input type="button" value="등록">
        <input type="button" value="수정">
        <input type="button" value="삭제">
    </div>
</div>

</body>
</html>
