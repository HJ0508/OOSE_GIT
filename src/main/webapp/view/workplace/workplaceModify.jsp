<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-06-06
  Time: 오전 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h3>사업장 수정</h3>
<form action="#">
    <fieldset>
        <div>
            <label for="originName">기존 사업장</label>
            <input type="text" id="originName">
        </div>
        <div>
            <label for="modifyName">사업장 이름</label>
            <input type="text" id="modifyName">
        </div>
    </fieldset>
    <input type="submit" value="확인">
    <input type="button" value="취소">
</form>
</body>
</html>
