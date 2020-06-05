<%--
작성 일자: 2020.06.01
작성자: 박재희
내용: 회원 등록 화면
산출물 기준: DCD-1404
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 등록</title>
    <link href="${pageContext.request.contextPath}/css/memberControl.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="memberMenuView.jsp"%>
    <div>
        <form method="post" action="/reqRegisterMember">
            <div class="contentDiv">
                <table>
                    <tr>
                        <th><span>이름</span></th>
                        <th><input type="text" name="name"></th>
                    </tr>
                    <tr>
                        <th><span>id</span></th>
                        <th><input type="text" name="id"></th>
                    </tr>
                    <tr>
                        <th><span>password</span></th>
                        <th><input type="password" name="password"></th>
                    </tr>
                    <tr>
                        <th><span>전화번호</span></th>
                        <th><input type="text" name="phoneNumber" placeholder="- 빼고 입력"></th>
                    </tr>
                </table>
                <input id="submitBtn" type="submit"value="등록">
            </div>
        </form>
    </div>
</body>
</html>
