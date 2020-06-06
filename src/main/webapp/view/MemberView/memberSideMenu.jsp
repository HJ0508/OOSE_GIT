<%--
 작성 일자: 2020.06.01
작성자: 박재희
내용: 회원 관리 사이드 메뉴
산출물 기준: 없음
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/memberControl.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="menuDiv">
        <ul>
            <li>
                <a class="aLink" href="registerMemberView.jsp">회원 등록</a>
            </li>
            <li>
                <a class="aLink" href="browseMemberView.jsp">회원 조회</a>
            </li>
        </ul>

    </div>
</body>
</html>
