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
<%@ include file="../Default/Header.jsp"%>
<div class = "contents-container">
    <div class="contents">
        <div class="side-menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/view/accomodationPayment/accomodationPaymentBrowse.jsp">결제정보조회</a></li>
                <li><a href="${pageContext.request.contextPath}/view/accomodationPayment/refundBrowse.jsp">환불정보조회</a></li>
            </ul>
        </div>
        <div class="title"><strong>환불 정보 관리</strong><br><br></div>
        <div class="contents-option">
            <div class="contents-table">
                <div>
                    <form method="post" action="/reqBrowseAccomodationPayment">
                        <input type="submit"value="조회">
                    </form>
                </div>
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
                        <c:forEach items="${accomodationPayment}" var = "accomodationPaymentInfo">
                            <tr>
                                <td>${accomodationPaymentInfo.paymentId}</td>
                                <td>${accomodationPaymentInfo.totalPeople}</td>
                                <td>${accomodationPaymentInfo.money}</td>
                                <td>${accomodationPaymentInfo.paymentWay}</td>
                                <td>${accomodationPaymentInfo.division}</td>
                                <td>${accomodationPaymentInfo.refund}</td>
                                <td>${accomodationPaymentInfo.paidDate}</td>
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
        const popUrl = "${pageContext.request.contextPath}/view/accomodationPayment/RegisterRefund.jsp";
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";
        window.open(popUrl,"",popOption);
    }
    function showRM() {
        const popUrl = "${pageContext.request.contextPath}/view/accomodationPayment/ModifyRefund.jsp";
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";
        window.open(popUrl,"",popOption);
    }
    function showRD() {
        const popUrl = "${pageContext.request.contextPath}/view/accomodationPayment/DeleteRefund.jsp";
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";
        window.open(popUrl,"",popOption);
    }
</script>
</body>
</html>
