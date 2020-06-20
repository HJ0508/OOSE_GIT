<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-04
  Time: 오후 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>환불정보등록</title>
</head>
<body>
<form action="/reqRegisterAccomodationPayment" method="post">
    <div>
        <label>결제id</label><input type="text" name="paymentId">
        <label>총인원</label><input type="text" name="totalPeople"><br>
        <label>납부금액</label><input type="text" name="money"><br>
        <label>결제방법</label><select name="paymentWay">
        <option value="card">신용카드</option>
        <option value="checkcard">체크카드</option>
        <option value="cash">무통장입금</option>
    </select>
        <br>
        <label>환불계좌</label><input type="text" name="refund"><br>
        <label>결제구분</label><input type="text" name="division"><br>
        <label>결제일자</label><input type="text" name="paidDate"><br>
        <input type="submit" value="확인">
        <input type="button" value="취소" onclick="window.close()">
    </div>
</form>
</body>
</html>
