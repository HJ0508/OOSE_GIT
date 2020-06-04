<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-03
  Time: 오후 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h>결제 정보 수정</h>
    총인원 <input type="text" name="totpeople"><br>
    납부금액 <input type="text" name="totmoney"><br>
    결제방법 <select name="payway">
        <option value="card">신용카드</option>
        <option value="checkcard">체크카드</option>
        <option value="cash">무통장입금</option>
    </select>
    <br>
    환불계좌 <input type="text" name="refundaccount"><br>
    결제구분 <input type="text" name="paydiv"><br>
    결제일자 <input type="text" name="paydate"><br>
    <input type="button" value="확인" onclick="window.close()">
    <input type="button" value="취소" onclick="window.close()">
</body>
</html>
