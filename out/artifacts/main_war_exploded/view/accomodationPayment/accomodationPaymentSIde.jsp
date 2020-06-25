<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-25
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/accomodationPayment.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="menuDiv">
    <ul>
        <li>
            <a class="aLink" href="accomodationPaymentRegister.jsp">결제등록</a>
        </li>
        <li>
            <a class="aLink" href="accomodationPaymentBrowse.jsp">결제조회</a>
        </li>
        <li>
            <a class="aLink" href="refundRegister.jsp">환불등록</a>
        </li>
        <li>
            <a class="aLink" href="refundBrowse.jsp">환불조회</a>
        </li>
    </ul>
</div>
</body>
</html>
