<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-06
  Time: 오후 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../css/purchaseProduct.css" rel="stylesheet" type="text/css">

    <title>상품패키지 구입</title>
</head>

<body>
<div class="purchase-head">
    <h2>상품 구입</h2>
</div>
<form action="purchaseProduct">
    <div class="purchase-body">

        <br><br><br>
        <label> 상품 명 <select name="name">
            <c:forEach var="pp" items="${productList}">
                <option>
                        ${pp.name}
                </option>
            </c:forEach>
        </select>
        </label> <br><br>
        <label> 수량 <input name="amount" type="text"></label> <br><br>
        <label> 결제 방법
            <select name="paymentOption">
                <option>신용 카드</option>
                <option>체크 카드</option>
            </select>
        </label> <br><br>
        <label> 환불 계좌 <input name="refundAccount" type="text"></label> <br><br>

    </div>
    <div class="purchase-tail">
        <input type="reset" class="cancel-button" name="cancel" value="취소">
        <input type="submit" class="sumbit-button" name="register" value="확인">
    </div>
</form>
</body>

<script>
    <%
    Object temp = request.getAttribute("result");
    if(temp != null)
        {
            int result = (Integer)temp;
            if(result == 1){
    %>
    window.onload = alert("구입이 완료되었습니다.");
    opener.location.reload();
    <%
            }else if(result == 0){
                %>
    window.onload = alert("구매 중 오류가 발생했습니다.");
    <%
            }else if(result == 2){
                %>
    window.onload = alert("누락된 정보가 존재합니다.");
    <%
            }else if(result == 3){
                            %>
    window.onload = alert("재고가 부족합니다. 다시 선택해주십시오.");
    <%
            }else if(result == 4){
                %>
    window.onload = alert("상품 목록 조회 중 오류가 발생했습니다.");
    <%
            }else if(result == 5){
                %>
    window.onload = alert("입력 형식이 잘못되었습니다.");
    <%
            }
        }
    %>
</script>
</html>