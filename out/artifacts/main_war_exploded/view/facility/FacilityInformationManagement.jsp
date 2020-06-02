<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/FacilityManagement.css" rel="stylesheet" type="text/css">
    <title>시설정보관리</title>
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
                    <img src="Image/pngguru.com.png" alt>
                    <strong>소공도 관광지</strong>
                    <div>통합관리시스템</div>
                </a>
            </h1>
            <div id="top-menu">
                <ul class="navbar-nav">
                    <li>
                        <a href="#">회원</a>
                    </li>
                    <li>
                        <a href="#">권한</a>
                    </li>
                    <li>
                        <a href="#">사업장</a>
                    </li>
                    <li>
                        <a href="FacilityManagement.jsp">시설</a>
                    </li>
                    <li>
                        <a href="#">예약</a>
                    </li>
                    <li>
                        <a href="#">판매상품</a>
                    </li>
                    <li>
                        <a href="#">결제</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="sub-top">
    <div class="sub-visual-wrapper">
        <img src="Image/sightseeing.jpg">
    </div>
</div>

<div class="sidebar">
    <div>
        <ul class="sidebar-content">
            <li>시설관리</li>
            <li>시설정보관리</li>
        </ul>
    </div>
</div>
<div class="content-container">
    <div id = "content-name">
        시설 정보 조회
    </div>
    <div class="content">
        <table border="1">
            <tr>
                <th>No.</th>
                <th>시설명</th>
                <th>시설 상태</th>
                <th>시설 담당자</th>
                <th>전화번호</th>
                <th>선택</th>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th><input type="checkbox"></th>
            </tr>
        </table>
        <input type="button" value="등록">
        <input type="button" value="수정">
        <input type="button" value="삭제">
    </div>
</div>

</body>
</html>
