<%--
  Created by IntelliJ IDEA.
  User: jaehe
  Date: 2020-06-06
  Time: 오전 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="OOSE.model.Member" %>
<html>
<head>
    <title>회원 정보</title>
    <link href="${pageContext.request.contextPath}/css/memberControl.css" rel="stylesheet" type="text/css">
<%--    <link href="../css/main_member.css" rel="stylesheet" type="text/css">--%>
</head>
<body>
<%@include file="../default/main_member.jsp"%>
<div class="contentDiv">
    <table id="browseTable">
        <thead>
        <tr>
            <th>회원 이름</th>
            <th>ID</th>
            <th>Password</th>
            <th>전화번호</th>
        </tr>
        </thead>
        <tbody>
        <%!Member member =new Member();%>
        <%member = (Member)request.getAttribute("member");%>
        <tr>
<%--            <td id="name"><%=member.getName()%></td>--%>
<%--            <td id="id"><%=member.getId()%></td>--%>
<%--            <td id="password"><%=member.getPassword()%></td>--%>
<%--            <td id="phoneNum"><%=member.getPhoneNum()%></td>--%>
                 <td id="name">${member.name}</td>
                <td id="id">${member.id}</td>
                <td id="password">${member.password}</td>
                <td id="phoneNum">${member.phoneNum}</td>
        </tr>
        </tbody>
    </table>
    <div class="modify_delete_div">
        <a id="modify" class="aLink" href="#" onclick="modifyClick()">수정</a>
        <a id ="delete" class="aLink" href="#" onclick="deleteClick()">탈퇴</a>
    </div>
</div>
<script>
    function modifyClick()
    {
        document.getElementById("modify").setAttribute("href", "/view/MemberView/modifyMemberView_member.jsp?id="
            + encodeURI(document.getElementById("id").innerHTML) + "&name=" + encodeURI(document.getElementById("name").innerHTML)+ "&password=" + encodeURI(document.getElementById("password").innerHTML)
            + "&phoneNum=" + encodeURI(document.getElementById("phoneNum").innerHTML));
    }
    function deleteClick()
    {
        var clicked=confirm("정말 탈퇴하시겠습니까?");
        if(clicked==true)
        {
            document.getElementById("delete").setAttribute("href", "/view/MemberView/reqDeleteMember?id=" + encodeURI(document.getElementById("id").innerHTML));       //서버에 삭제 요청
        }
    }
</script>
</body>

</html>
