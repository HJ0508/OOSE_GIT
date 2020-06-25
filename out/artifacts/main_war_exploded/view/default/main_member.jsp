<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-04
  Time: 오전 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/main_member.css" rel="stylesheet" type="text/css">

    <title>소공도 관광지</title>
</head>

<%
    String id = (String)session.getAttribute("id") ; //세션에 저장된 id, 권한정보 받아오기
    int authority = (Integer)session.getAttribute("authority");
%>

<body>
<div class="main header" id="header">
    <div class="header-blank">
        <ul class="user-bar">
            <li><a href="#"><strong><%= id%> 님 환영합니다. 권한: <%=authority%></strong></a></li>
        </ul>
    </div>
    <div class="navbar">
        <div class="container">
            <h1 class="navbar-brand">
                <a href="#">
                    <img src="../../Image/pngguru.com.png" alt>
                    <div class = "brand-logo">소공도 관광지</div>
                    <!-- <div>통합관리시스템</div> -->
                </a>
            </h1>
            <div id="top-menu">
                <ul class="navbar-nav">
                    <li>
                        <a id="browseMemberView" href="#" onclick="reqBrowseMember()">회원</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/productList">판매상품</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<<<<<<< HEAD
<div class="sub-top">
    <div class="sub-visual-wrapper">
        <img src="../../Image/sightseeing.jpg">
    </div>
</div>


<<<<<<< HEAD
=======
=======
<script>
    function reqBrowseMember()
    {
        checkTableRow();
        document.getElementById("browseMemberView").setAttribute("href", "/view/MemberView/reqBrowseMemberView_member?id="+document.getElementsByName("id")[radioSelectedRow].innerHTML);
        //로그인된 사용자의 정보를 세션에서 가져옴, 로그인시 세션에 저장되어 있을것
    }
</script>
>>>>>>> master
</body>
>>>>>>> master
</html>
