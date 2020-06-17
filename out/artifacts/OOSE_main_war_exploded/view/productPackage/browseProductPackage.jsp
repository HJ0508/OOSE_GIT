<%--
 작성 일자: 2020.06.03
작성자: 윤진
내용: 상품 패키지 조회
산출물 기준: UI-047
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="OOSE.model.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../css/browseProduct.css" rel="stylesheet" type="text/css">

    <title>소공도 관광지</title>
</head>
<body>
<%--jsp파일 그대로도 작동하긴 하지만 url 패턴은 /browseProductPackage로 적용--%>
<%@include file="../default/header.jsp"%>

<!-- 절  취  선 -->

<div class="sub-body">
    <div class="side-menu">
        <ul>
            <li><a href="#" class="selected">관리</a></li>
            <li><a href="${pageContext.request.contextPath}/view/productPackage/performanceAggregate.jsp">판매 실적</a></li>
            <li><a href="#">상품 구입</a></li>
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
            </tr>

            <% Object[] productPackages = (Object[]) request.getAttribute("productPackages");
                if (productPackages == null || productPackages.length == 0) { %>
        </table>
        <p>조회된 내용이 없습니다.</p>
        <% } else {
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
        </tr>
        <%}%>
        </table>
        <%}%>

    </div>
    <div class="button-frame">
        <button onclick="showRegisterPopup()">등록</button>
        <button onclick="showModifyPopup()"><a>수정</a></button>
        <button onclick ="showDeletePopup()"><a>삭제</a></button>
    </div>
</div>
</body>

<script language="javascript">
    function showRegisterPopup() {
        window.open("http://localhost:8080/view/productPackage/registerProductPackage.jsp", "a", "width=500, height=500, left=100, top=50, resizable=no");
    }

    function showModifyPopup() {
        window.open("/view/productPackage/modifyProduct", "a", "width=500, height=500, left=100, top=50, resizable=no");
    }

    function showDeletePopup(){
        window.open("/view/productPackage/deleteProduct", "a", "width=500, height=300, left=100, top=50, resizable=no");
    }
</script>

</html>
