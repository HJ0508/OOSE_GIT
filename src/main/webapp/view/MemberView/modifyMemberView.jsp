<%--
  Created by IntelliJ IDEA.
  User: jaehe
  Date: 2020-06-04
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 정보 수정</title>
    <link href="${pageContext.request.contextPath}/css/memberControl.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="memberMenuView.jsp"%>
    <div>
        <form method="post" action="/reqModifyMember">
            <div class="contentDiv">
                <table>
                    <tr>
                        <td><span>이름</span></td>
                        <td><input type="text" name="name" value="<%=request.getParameter("name")%>"></td>
                    </tr>
                    <tr>
                        <td><span>id</span></td>
                        <td><input type="text" name="id" readonly value="<%=request.getParameter("id")%>"></td>     <%--readonly - 읽기만 가능한 input, id는 pk이므로 수정 불가로 출력--%>
                    </tr>
                    <tr>
                        <td><span>password</span></td>
                        <td><input type="password" name="password" value="<%=request.getParameter("password")%>"></td>
                    </tr>
                    <tr>
                        <td><span>전화번호</span></td>
                        <td><input type="text" name="phoneNumber" value="<%=request.getParameter("phoneNum")%>"></td>
                    </tr>
                </table>
                <input id="submitBtn" type="submit"value="수정 완료">
            </div>
        </form>
    </div>
</body>
</html>
