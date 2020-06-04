<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-04
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
    <title>소공도 관광지</title>
    <script language="JavaScript">
        function showRR(){
            window.open("refundRegister.jsp","환불등록","width=400,height=800,left=100,top=50");
        }
        function showRM(){
            window.open("refundModify.jsp","환불수정","width=400,height=800,left=100,top=50");
        }
        function showRD(){
            window.open("refundDelete.jsp","환불삭제","width=400,height=800,left=100,top=50");
        }
    </script>
</head>
<body>
<%@ include file="../default/header.jsp"%>
<div class = "contents-container">
    <%@ include file="accomodationPaymentNaviBar.jsp"%>
    <div class="contents">
        <div class="title"><strong>결제 정보 관리</strong><br><br></div>
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
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <input type="button" value="등록" onclick="showRR()" style="float: right;">
            <input type="button" value="수정" onclick="showRM()" style="float: right;">
            <input type="button" value="삭제" onclick="showRD()" style="float: right;">
        </div>
    </div>
</div>
</body>
</html>
