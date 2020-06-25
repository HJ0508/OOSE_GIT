<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-03
  Time: 오후 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결제삭제</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script language="javascript">
        function cl() {
            window.open("about:blank", "_self").close();
        }
    </script>
</head>
<body>
<div>결제 삭제</div>
<div class="contents-container">
    <form action="/reqDeleteAccommodationPayment" method="POST">
        <%
            String check = request.getParameter("userId");
            if(check != null) {
                pageContext.setAttribute("check", check);
        %>
        유저id <input type="text" name="userId" value = ${check}><br>
        <%
            }
        %>
        <input type="submit" value="삭제">
    </form>
    <input type="button" value="닫기" onclick="cl()">
</div>
</body>
</html>

