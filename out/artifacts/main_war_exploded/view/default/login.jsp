<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 2020-06-23 수정
  Time: 오후 6:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
<div class = centerBox>
    <h3>로그인</h3><br>
<form method="post" id = "form">
    <div id = "inputLabel">
    <label>ID      : </label>
    <br>
    <label>비밀번호 : </label>
    <br>
    </div>
    <div id="inputText">
        <input type="text" name="id">
        <br>
        <input type="password" name="passwd">
        <br>
    </div>
    <input id="loginSubmit" type="submit" value="로그인" formaction="/login">

    <div id="radio">
    <input type="radio" name="userDivision" value="회원" checked = "checked">회원
    <input type="radio" name="userDivision" value="직원">직원
    <input type="radio" name="userDivision" value="관리자">관리자
    <input type="radio" name="userDivision" value="비회원">비회원으로 계속
    </div>

    <br><br>
<%--    <input type="submit" value="비회원으로 계속">--%>
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
</div>

</body>
</html>
