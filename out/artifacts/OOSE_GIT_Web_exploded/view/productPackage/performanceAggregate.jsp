<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-03
  Time: 오후 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../css/aggregate.css" rel="stylesheet" type="text/css">
    <title>소공도 관광지 상품 판매 실적</title>
</head>
<body>
<%@include file="../default/header.jsp"%>


<!-- 절  취  선 -->

<div class="sub-body">

    <div class="date-frame">
        <form action="ap" method="get">
            <input type="date" name="d">
            <button type="submit">조회</button>
        </form>
    </div>

    <div class="side-menu">
        <ul>
            <li><a href="${pageContext.request.contextPath}/view/productPackage/browseProductPackage">관리</a></li>
            <li><a href="#" class="selected">판매 실적</a></li>
            <li><a href="#">상품 구입</a></li>
        </ul>
    </div>

    <div class="table">
        <table>
            <tr>
                <th>No.</th>
                <th>상품 명</th>
                <th>판매량</th>
                <th>수입</th>
            </tr>

            <% Object[] productPackagePayments = (Object[]) request.getAttribute("productPackagePayments");
                if (productPackagePayments == null || productPackagePayments.length == 0) { %>
        </table>
        <p>조회된 내용이 없습니다.</p>
        <% } else {
            for (int i = 0; i < productPackagePayments.length; i++) {
                pageContext.setAttribute("productPackagePayments", productPackagePayments[i]);
        %>

        <tr>
            <td>${productPackagePayments.id}</td>
            <td>${productPackagePayments.productName}</td>
            <td>${productPackagePayments.amount}</td>
            <td>${productPackagePayments.paidAmount}</td>
        </tr>

        <%
            }
        %>
        </table>

        <%
            }
        %>
    </div>
</div>
</body>
</html>
