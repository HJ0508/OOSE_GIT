<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-06
  Time: 오전 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/default/main_member.jsp" %>
<link href="../css/browseProduct.css" rel="stylesheet" type="text/css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>상품 패키지 조회</title>
</head>
<body>
<div class="sub-body">
    <div class="side-menu">
        <ul>
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

<%--            <% Object[] productPackages = (Object[]) request.getAttribute("productPackages");--%>
<%--                if (productPackages == null || productPackages.length == 0) { %>--%>
<%--        </table>--%>
<%--        <p>조회된 내용이 없습니다.</p>--%>
<%--        <% } else {--%>
<%--            for (int i = 0; i < productPackages.length; i++) {--%>
<%--                pageContext.setAttribute("productPackage", productPackages[i]);--%>
<%--        %>--%>

<%--        <tr>--%>
<%--            <td>${productPackage.id}</td>--%>
<%--            <td>${productPackage.name}</td>--%>
<%--            <td>${productPackage.price}</td>--%>
<%--            <td>${productPackage.state}</td>--%>
<%--            <td>${productPackage.stock}</td>--%>
<%--            <td>${productPackage.note}</td>--%>
<%--        </tr>--%>
<%--        <%}%>--%>
<%--        </table>--%>
<%--        <%}%>--%>

<%--            <c:set var="productPackages" value="${productPackages}"/>--%>

            <c:forEach var="pp" items="${productPackages}">
                <tr>
                    <td>${pp.id}</td>
                    <td>${pp.name}</td>
                    <td>${pp.price}</td>
                    <td>${pp.state}</td>
                    <td>${pp.stock}</td>
                    <td>${pp.note}</td>
                </tr>
            </c:forEach>
            </table>

    </div>
</div>
</body>
</html>
