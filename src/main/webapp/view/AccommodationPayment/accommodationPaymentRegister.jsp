<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-03
  Time: 오후 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/css/accommodationPayment.css" rel="stylesheet" type="text/css">
    <style>
        .contentDiv {
            top: 2rem;
            left: 1.5rem;
        }
    </style>
    <title>결제 정보 등록</title>
</head>
<body>
    <div>
        <form id="registerForm" action="/reqRegisterAccommodationPayment" method="post">
            <div class="contentDiv">
                결제id<input type="text" name="paymentId"><br>
                유저id<input type="text" name="userId"><br>
                숙소id<input type="text" name="accommodationId"><br>
                총인원<input type="text" name="totalPeople"><br>
                납부금액<input type="text" name="money"><br>
                결제방법<input type="text" name="paymentWay"><br>
                환불계좌<input type="text" name="refund"><br>
                결제구분<input type="text" name="division"><br>
                결제일자<input type="text" name="paidDate"><br>
                <input type="submit" value="확인">
            </div>
        </form>
    </div>
</body>
</html>
