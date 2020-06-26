<%--
 작성 일자: 2020.06.03
작성자: 윤진
내용: 상품 패키지 조회
산출물 기준: UI-047
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="OOSE.Model.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../css/browseProduct.css" rel="stylesheet" type="text/css">

    <title>소공도 관광지</title>
</head>
<body>
<%@include file="../Default/Header.jsp"%>

<!-- 절  취  선 -->

<div class="sub-body">
    <div class="side-menu">
        <ul>
            <li><a href="#" class="selected">관리</a></li>
            <li><a href="${pageContext.request.contextPath}/view/ProductPackage/PerformanceAggregate.jsp">판매 실적</a></li>
            <li><a href="#" onclick="showPurchasePopup()">상품 구입</a></li>
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
    <%
    Object checkError = request.getAttribute("error");
    if(checkError != null){
    %>
    alert("조회 중 오류가 발생했습니다.");
    <%}
    %>
    function showRegisterPopup() {
        window.open("/view/ProductPackage/RegisterProduct", "a", "width=500, height=500, left=100, top=50, resizable=no"); <!--★jsp 대신 url-->
    }

    function showModifyPopup() {
        window.open("/view/ProductPackage/ModifyProduct", "a", "width=500, height=500, left=100, top=50, resizable=no");
    }

    function showDeletePopup(){
        window.open("/view/ProductPackage/DeleteProduct", "a", "width=500, height=300, left=100, top=50, resizable=no");
    }

    function showPurchasePopup(){
        window.open("/view/ProductPackage/PurchaseProduct", "a", "width=500, height=500, left=100, top=50, resizable=no");
    }

    <%-- ★등록 수정 삭제 구매 팝업 추가 및 경로 수정 --%>
</script>

</html>
