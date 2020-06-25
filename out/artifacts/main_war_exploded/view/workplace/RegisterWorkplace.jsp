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
    <title>사업장 등록</title>
    <script language="javascript">
        function cl() {
            window.open("about:blank","_self").close();
        }
    </script>
</head>
<body>
<div class = "content-name">사업장 등록</div>
<br>
<div class = "content-container">
    <form action="/registerWorkplaceManagement" method="POST">
        사업장ID
        <input type="text" name = "ID"><br>
        사업장명
        <input type="text" name = "name"><br>
        <input type="submit" value="등록">
        <input type="button" value="닫기" onclick="cl()">
    </form>

</div>
</body>
</html>
