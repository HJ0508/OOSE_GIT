<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-04
  Time: 오후 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>환불 정보 수정</title>
    <link href="${pageContext.request.contextPath}/css/accommodationPayment.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="accommodationPaymentView.jsp"%>
<div>
    <form action="/reqModifyRefund" method="post">
        <div class="contentDiv">
            결제id<input type="text" name="paymentId" readonly value = "<%=request.getParameter("paymentId")%>"><br>
            유저id<input type="text" name="userId" value="<%=request.getParameter("userId")%>"><br>
            숙소id<input type="text" name="accommodationId" readonly value="<%=request.getParameter("accommodationId")%>"><br>
            총인원<input type="text" name="totalPeople" readonly value = "<%=request.getParameter("totalPeople")%>"><br>
            납부금액<input type="text" name="money" value = "<%=request.getParameter("money")%>"><br>
            결제방법<input type="text" name="paymentWay" value = "<%=request.getParameter("paymentWay")%>"><br>
            환불계좌<input type="text" name="refund" value = "<%=request.getParameter("refund")%>"><br>
            결제구분<input type="text" name="division" value = "<%=request.getParameter("division")%>"><br>
            결제일자<input type="text" name="paidDate" readonly value = "<%=request.getParameter("paidDate")%>"><br>
            <input id="submitBtn" type="submit" value="확인">
        </div>
    </form>
</div>
</body>
</html>