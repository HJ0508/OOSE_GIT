<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시설 수정</title>
    <script language="javascript">
        function cl() {
            window.open("about:blank", "_self").close();
        }
    </script>
</head>
<body>
<div class="content-name">시설 수정</div>
<div class="content-container">
    <form action="/modifyFacilityManagement" method="POST">
        <%
            String check = request.getParameter("name");
                if(check != null) {
                    pageContext.setAttribute("check", check);
        %>
        기존 시설명 :
        <input type="text" name = "oldName" value = ${check}><br>
        <%
                }
        %>
        시설명
        <input type="text" name = "name">
        <input type="submit" value="수정">
    </form>
    <input type="button" value="닫기" onclick="cl()">
</div>
</body>
</html>
