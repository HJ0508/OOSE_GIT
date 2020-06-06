<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 2020-06-06
  Time: 오후 6:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label>ID : </label>
    <input type="text" name="id">
    <br>

    <label>비밀번호 : </label>
    <input type="password" name="passwd">
    <br>

    <input type="radio" name="userIdentify" value="회원">회원
    <input type="radio" name="userIdentify" value="직원">직원
    <input type="radio" name="userIdentify" value="관리자">관리자



    <input type="submit" value="로그인" formaction="/login">
    <br><br>
    <input type="submit" value="비회원으로 계속">

</form>

</body>
</html>
