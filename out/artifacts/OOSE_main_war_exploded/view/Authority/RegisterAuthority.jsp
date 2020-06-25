<%--
  Created by IntelliJ IDEA.
  User: haejun
  Date: 2020-06-25
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterAuthority</title>
    <style>
        strong{
            font-size:1.5rem;
            margin-left: 1rem;
        }
        label{
            display: inline-block;
            margin-right:1rem;
            margin-left:2rem;
        }
        input, select, textarea {
            float:right;
            margin-right:2rem;
            text-align: right;
        }
        .cancel{float:right; margin-right: 2rem;}
        .save{float:right; background-color: rgb(52, 152, 219); border-radius: 4px; margin-right:0.3rem;}
    </style>
</head>
<body>
<div class="register-contents">
    <div class="title"><strong>권한 등록</strong></div><br>
    <form action="/authority/registerAuthority" method="POST">
        <div class="input-info">
            <label>권한ID</label><input name = "authorityId" type="text" placeholder="권한ID를 입력하십시오"><br>
            <label>권한이름</label><input name = "authorityName" type="text" placeholder="권한이름을 입력하시오"><br>
            <label>권한범위</label><textarea name="authorityRange" cols="30" rows="10" placeholder="권한범위를 입력하십시오"></textarea><br><br><br><br><br><br><br>
            <input class="cancel" type="button" value="취소" onclick=popupClose()>
            <input class="save" type="submit" value="저장">
        </div>
    </form>
</div>
<script>
    function popupClose() { self.close();}
</script>
</body>
</html>

