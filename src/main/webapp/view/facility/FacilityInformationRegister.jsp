<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시설 정보 등록</title>
    <script>
        function cl() {
            window.open("about:blank", "_self").close();
        }
    </script>
</head>
<body>
<div class = "content-name">시설 정보 등록</div>
<div class = "content-container">
    <form action="/registerFacilityInformation" method="POST">
        <%
            String check = request.getParameter("name");
            if(check != null) {
                pageContext.setAttribute("check", check);
        %>
        시설명 <input type="text" name = "name" value = ${check}><br>
        <%
            }
        %>
        사업장ID <input type="text" name = "workspaceId"><br>
        시설 상태 <input type="text" name = "facilityState"><br>
        요금 <input type="text" name = "fee"><br>
        여는시간 <input type="text" name = "openTime"><br>
        닫는시간 <input type="text" name = "closeTime"><br>
        시설 담당자 <input type="text" name = "manager"><br>
        크기 <input type="text" name = "capacity"><br>
        <input type="submit" value="등록">
    </form>
    <input type="button" value="취소" onclick="cl()">
</div>
</body>
</html>