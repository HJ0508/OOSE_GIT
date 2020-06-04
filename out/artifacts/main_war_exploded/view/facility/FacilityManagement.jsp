<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-05-31
  Time: 오후 6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/FacilityManagement.css"/>
    <title>시설관리</title>
    <script language="javascript">
        function register() {
            window.open("FacilityRegister.jsp", "register", "width=500, height=400, left=200, top=100");
        }
        function modify() {
            window.open("FacilityModify.jsp", "modify", "width=500, height=400, left=200, top=100");
        }
        function remove() {
            window.open("FacilityRemove.jsp", "remove", "width=500, height=400, left=200, top=100");
        }
    </script>
</head>
<body>
<%@include file="../default/header.jsp" %>

<div class="sidebar">
    <div>
        <ul class="sidebar-content">
            <li>시설관리</li>
            <li>시설정보관리</li>
        </ul>
    </div>
</div>
<div class="content-container">
<div id="content-name">
    시설 조회
</div>
    <br>
    <br>
    <br>

    <form action="FacilityManagement.jsp" method="POST">
    <input type="submit" value="조회">

</form>
<input type="button" value="등록" onclick="register();"/>
<input type="button" value="수정" onclick="modify();"/>
<input type="button" value="삭제" onclick="remove();"/>

<div class="content">
<table border="1">
<tr>
    <th>No.</th>
    <th>Name</th>
    <th>선택</th>
</tr>
<c:forEach items="${result}" var="result">
    <tr>
    <th></th>
    <th>${result[0]}</th>
    <th><input type="checkbox"></th>
    </tr>
</c:forEach>
    </table>
    </div>
    </div>

    </body>
    </html>
