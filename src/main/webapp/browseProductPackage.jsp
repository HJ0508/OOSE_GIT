<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-01
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="/model/ProductPackage" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/browseProduct.css" rel="stylesheet" type="text/css">

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
                    <img src="pngguru.com.png" alt>
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
                        <a href="#" class="selected">판매상품</a>
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
        <img src="sightseeing.jpg">
    </div>
</div>

<!-- 절  취  선 -->

<div class="sub-body">
    <div class="side-menu">
        <ul>
            <li><a href="#" class="selected">관리</a></li>
            <li><a href="#">판매 실적</a></li>
        </ul>
    </div>
    <div class="table">
        <table>
            <tr>
                <th>No.</th>
                <th>상품 명</th>
                <th>가격</th>
                <th>상품 상태</th>
                <th>재고</th>
                <th>비고</th>
                <th>선택</th>
            </tr>

            <% ProductPackage[] productPackages = (ProductPackage[]) request.getAttribute("productPackages");

                for (int i = 0; i < productPackages.length; i++) {
                    pageContext.setAttribute("productPackage", productPackages[i]);
            %>

            <tr>
                <td>${productPackage.id}</td>
                <td>${productPackage.name}</td>
                <td>${productPackage.price}</td>
                <td>${productPackage.state}</td>
                <td>${productPackage.stock}</td>
                <td>${productPackage.note}</td>
                <td><input type="checkbox"></td>
            </tr>
            <%}%>

        </table>
    </div>
    <div class = "button-frame">
        <button><a>등록</a></button>
        <button><a>수정</a></button>
        <button><a href="#">삭제</a></button>
    </div>
</div>
</body>
</html>
