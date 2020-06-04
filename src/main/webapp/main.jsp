<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-05-29
  Time: 오후 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/main.css" rel="stylesheet" type="text/css">
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
                            <img src="Image/pngguru.com.png"alt>
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
                                <a href="#">시설</a>
                            </li>
                            <li>
                                <a href="#">예약</a>
                            </li>
                            <li>
                                <a href="#">판매상품</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/view/accomodationPayment/accomodationPaymentBrowse.jsp">결제</a>
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
    </body>
</html>
