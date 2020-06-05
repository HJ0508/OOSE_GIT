<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-04
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core%" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
    <title>소공도 관광지</title>
</head>
<body>
<%@ include file="../default/header.jsp"%>
<div class = "contents-container">
    <%@ include file="accomodationPaymentNaviBar.jsp"%>
    <div class="contents">
        <div class="title"><strong>환불 정보 관리</strong><br><br></div>
        <div class="contents-option">
            <div class="contents-table">
                <table>
                    <thead>
                    <tr>
                        <th>NO.</th>
                        <th>총인원</th>
                        <th>납부금액</th>
                        <th>결제방법</th>
                        <th>결제구분</th>
                        <th>환불계좌</th>
                        <th>결제일자</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var = "accomodationPayment">
                        <tr>
                            <td>${accomodationPayment.paymentId}</td>
                            <td>${accomodationPayment.totalPeople}</td>
                            <td>${accomodationPayment.money}</td>
                            <td>${accomodationPayment.paymentWay}</td>
                            <td>${accomodationPayment.refund}</td>
                            <td>${accomodationPayment.division}</td>
                            <td>${accomodationPayment.paidDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <button onclick="showRR()" style="float: right">등록</button>
                <button onclick="showRM()" style="float: right">수정</button>
                <button onclick="showRD()" style="float: right">삭제</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function showRR() {
        const popUrl = "${pageContext.request.contextPath}/view/accomodationPayment/refundRegister.jsp";
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";
        window.open(popUrl,"",popOption);
    }
    function showRM() {
        const popUrl = "${pageContext.request.contextPath}/view/accomodationPayment/refundModify.jsp";
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";
        window.open(popUrl,"",popOption);
    }
    function showRD() {
        const popUrl = "${pageContext.request.contextPath}/view/accomodationPayment/refundDelete.jsp";
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";
        window.open(popUrl,"",popOption);
    }
</script>
</body>
</html>
