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
    <link href="${pageContext.request.contextPath}/css/FacilityFunction.css" rel="stylesheet" type="text/css">
    <title>시설 등록</title>
    <script language="javascript">
        function cl() {
            window.open("about:blank","_self").close();
        }
    </script>
</head>
<body>
    <div class = "content-container">
        <form action="/registerFacilityManagement" method="POST">
            <div class = "name">
                시설명
                <input type="text" name = "name"><br>
            </div>
            <input class = "btn" type="submit" value="등록">
            <input class = "btn" type="button" value="닫기" onclick="cl()">
        </form>
    </div>
</body>
</html>