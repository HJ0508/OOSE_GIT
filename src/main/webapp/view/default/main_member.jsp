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
    <link href="../css/main_member.css" rel="stylesheet" type="text/css">

    <title>소공도 관광지</title>
</head>

<body>
<div class="main header" id="header">
    <div class="header-blank">
        <ul class="user-bar">
            <li><a href="#"><strong>로그인</strong></a></li>
        </ul>
    </div>
    <div class="navbar">
        <div class="container">
            <h1 class="navbar-brand">
                <a href="#">
                    <img src="../../Image/sightseeing.jpg" alt>
                    <div class = "brand-logo">소공도 관광지</div>
                    <!-- <div>통합관리시스템</div> -->
                </a>
            </h1>
            <div id="top-menu">
                <ul class="navbar-nav">
                    <li>
                        <a href="#">회원</a>
                    </li>
                    <li>
                        <a href="#" class="selected">판매상품</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="sub-top">
    <div class="sub-visual-wrapper">
        <img src="../../Image/sightseeing.jpg">
    </div>
</div>

<div class = "sub-body">
    <div class="side-menu">
        <ul>
            <li><a href="#" class="selected">목록</a></li>
            <li><a href="#">상품 구입</a></li>
        </ul>
    </div>
</div>
</html>
