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

    <input type="radio" name="userDivision" value="회원" checked = "checked">회원
    <input type="radio" name="userDivision" value="직원">직원
    <input type="radio" name="userDivision" value="관리자">관리자



    <input type="submit" value="로그인" formaction="/login">
    <br><br>
    <input type="submit" value="비회원으로 계속">
    <br><br>
    <%
        String loginMessage = (String)request.getAttribute("loginMessage");
        if(loginMessage==null)
            loginMessage=""; //처음조회시 null로 출력돼서 빈칸으로 만듦.
    %>
    <%=
        loginMessage
    %>
</form>

</body>
</html>
