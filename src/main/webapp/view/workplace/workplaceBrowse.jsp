<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-06-06
  Time: 오전 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />--%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사업장 조회(관리)</title>
    <script language="javascript">
        const url = "${pageContext.request.contextPath}/view/workplace/";
        function Register() {
            window.open(url+"workplaceRegister.jsp","register","width=500,height=400,left=200,top=100");
        }
        function Modify() {
            window.open(url+"workplaceModify.jsp","modify","width=500,height=400,left=200,top=100");
        }
        function Delete() {
            window.open(url+"workplaceDelete.jsp","delete","width=500,height=400,left=200,top=100");
        }
    </script>
</head>
<body>
<%--<%@ include file="../default/header.jsp"%>--%>
<div>
    <div class="table">
        <table border="1">
            <caption>사업장 조회</caption>
            <tr>
                <th>No.</th>
                <th>상품 명</th>
                <th>상세정보</th>
            </tr>
            <tr>
                <td> </td>
                <td> </td>
                <td><button>상세정보</button></td>
            </tr>
        </table>
    </div>
    <div>
        <form action="/browseWorkplace" method="POST">
            <input type="submit" value="조회">
        </form>
        <input type="button" value="등록" onclick="Register();"/>
        <input type="button" value="수정" onclick="Modify();"/>
        <input type="button" value="삭제" onclick="Delete();"/>

<%--        <button onclick="Register()"><a>등록</a></button>--%>
<%--        <button onclick="Modify()"><a>수정</a></button>--%>
<%--        <button onclick="Delete()"><a>삭제</a></button>--%>
    </div>
</div>
</body>
</html>
