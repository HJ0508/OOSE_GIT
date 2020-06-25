<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-15
  Time: 오전 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/FacilityFunction.css" rel="stylesheet" type="text/css">
    <script language="javascript">
        function cl() {
            window.open("about:blank", "_self").close();
        }
    </script>
</head>
<body>
<div class="content-container">
    <form action="/deleteFacilityManagement" method="POST">
        <%
            String check = request.getParameter("name");
            if(check != null) {
                pageContext.setAttribute("check", check);
        %>
        <div class = "name">
        시설명
        <input type="text" name = "name" value = ${check}><br>
        <%
            }
        %>
        </div>
        <input class = "btn" type="submit" value="삭제">
        <input class = "btn" type="button" value="닫기" onclick="cl()">
    </form>

</div>
</body>
</html>
