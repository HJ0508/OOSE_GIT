<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-06-06
  Time: 오전 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사업장 삭제</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script language="javascript">
        function cl() {
            window.open("about:blank", "_self").close();
        }
    </script>
</head>
<body>
<div class="content-name">사업장 삭제</div>
<br> <p>정말로 삭제하시겠습니까?</p>
<div class="content-container">
    <form action="/deleteWorkplaceManagement" method="POST">
        <%
            String check = request.getParameter("workplaceId");
            if(check != null) {
                pageContext.setAttribute("check", check);
        %>
        사업장 ID :
        <input type="text" readonly="readonly" name = "workplaceId" value = ${check}><br>
        <%
            }
        %>
        <input type="submit" value="삭제">
        <input type="button" value="닫기" onclick="cl()">
    </form>

</div>
</body>
</html>
