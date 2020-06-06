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
    <title>시설 등록</title>
</head>
<body>
    <div class = "content-name">시설 등록</div>
    <div class = "content-container">
        <form action="/registerFacilityManagement" method="POST">
        시설명
        <input type="text" name = "name"><br>
            <input type="submit" value="등록" onclick="window.close()">
        </form>
        <input type="button" value="취소">
    </div>
</body>
</html>