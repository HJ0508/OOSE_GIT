<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-06-06
  Time: 오전 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사업장 수정</title>
    <script language="javascript">
        function cl() {
            window.open("about:blank", "_self").close();
        }
    </script>
</head>
<body>
<div class="content-name">사업장 수정</div>
<div class="content-container">
    <form action="/modifyWorkplaceManagement" method="POST">
        <%
            String check = request.getParameter("name");
            if(check != null) {
                pageContext.setAttribute("check", check);
        %>
        기존 사업장명 :
        <input type="text" name = "oldName" value = ${check}><br>
        <%
            }
        %>
        사업장명
        <input type="text" name = "name">
        <input type="submit" value="수정">
    </form>
    <input type="button" value="닫기" onclick="cl()">
</div>
</body>
</html>
