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
    <title>소공도 관광지 - login</title>
    <style>
        h3{text-align: center; font-size: 1.5rem;}
        fieldset{
            height: 10rem;
            text-align: center;
            padding-top: 5%;
        }
    </style>
</head>
<body>
<div class = centerBox>
    <h3>로그인</h3><br>
<form method="post" id = "form">
    <fieldset>
        <div id = "inputLabel">
            <label>ID      : </label>
            <br>
            <label>비밀번호 : </label>
            <br>
        </div>
        <div id="inputText">
            <input type="text" name="id" id="id">
            <br>
            <input type="password" name="passwd" id="pw">
            <br>
        </div>
        <input id="loginSubmit" type="submit" value="로그인" formaction="/home">

        <div id="radio">
            <input type="radio" name="userDivision" value="회원" checked = "checked" onchange="disableOption()">회원
            <input type="radio" name="userDivision" value="직원" onchange="disableOption()">직원
            <input type="radio" name="userDivision" value="관리자" onchange="disableOption()">관리자
            <input type="radio" name="userDivision" id="nonMembers" value="비회원" onchange="disableOption()">비회원으로 계속
        </div>
        <br>
    <%--    <input type="submit" value="비회원으로 계속">--%>
        <%
            String loginMessage = (String)request.getAttribute("loginMessage");
            if(loginMessage==null)
                loginMessage=""; //처음조회시 null로 출력돼서 빈칸으로 만듦.
        %>
        <%=
            loginMessage
        %>
    </fieldset>
</form>
</div>
    <script>
        function disableOption() {
            var id = document.getElementById("id");
            var pw = document.getElementById("pw");
            if(document.getElementById("nonMembers").checked) {
                id.disabled = true;
                pw.disabled = true;
            } else {
                id.disabled = false;
                pw.disabled = false;
            }
        }
    </script>
</body>
</html>
