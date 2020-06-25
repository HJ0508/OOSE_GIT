<%--
  Created by IntelliJ IDEA.
  User: thkim
  Date: 2020-06-03
  Time: 오후 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="OOSE.model.AccommodationPayment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>환불 정보 관리</title>
    <link href="${pageContext.request.contextPath}/css/accommodationPayment.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
</head>
<body>
<%@include file="accommodationPaymentView.jsp"%>
<div class="contentDiv">
    <div style="font-size:20px;left:0;">
        환불 정보
        <div>
            <form class="buttonForm" method="post" action="/reqBrowseRefund">
                <input type="submit"value="조회">
            </form>
        </div>
    </div>
    <div>
        <div>
            <table id="browseTable">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>유저ID</td>
                    <td>숙소ID</td>
                    <td>총인원</td>
                    <td>납부금액</td>
                    <td>결제방법</td>
                    <td>결제구분</td>
                    <td>환불계좌</td>
                    <td>결제일자</td>
                    <td>선택</td>
                </tr>
                </thead>
                <tbody>
                <%
                    if (request.getAttribute("accommodationPaymentList") != null) {
                        ArrayList<AccommodationPayment> list = (ArrayList<AccommodationPayment>) request.getAttribute("accommodationPaymentList");
                        for (AccommodationPayment accommodationPayment : list) {
                            pageContext.setAttribute("accommodationPayment", accommodationPayment);
                %>
                <tr>
                    <td name = "paymentId">${accommodationPayment.paymentId}</td>
                    <td name = "userId">${accommodationPayment.userId}</td>
                    <td name = "accommodationId">${accommodationPayment.accommodationId}</td>
                    <td name = "totalPeople">${accommodationPayment.totalPeople}</td>
                    <td name = "money">${accommodationPayment.money}</td>
                    <td name = "paymentWay">${accommodationPayment.paymentWay}</td>
                    <td name = "division">${accommodationPayment.division}</td>
                    <td name = "refund">${accommodationPayment.refund}</td>
                    <td name = "paidDate">${accommodationPayment.paidDate}</td>
                    <td><input type="radio" name="selected"></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <div class="modify_delete_div">
        <a id="register" class="aLink" href="#" onclick="showRR()">등록</a>
        <a id="modify" class="aLink" href="#" onclick="showRM()">수정</a>
        <a id="delete" class="aLink" href="#" onclick="showRD()">삭제</a>
    </div>
</div>
</div>
<script>
    var radio =document.getElementsByName("selected");
    var radioSelectedRow;   //라디오 버튼이 출력된 행 번호 저장
    function checkTableRow()        //라이도 버튼이 클릭된 행을 찾는 함수
    {
        var radio = document.getElementsByName("selected");
        for(var i=0;i<radio.length;i++)
        {
            if(radio[i].checked)
            {
                radioSelectedRow=i;
            }
        }
    }
    function showRR(){
        window.open("/view/accommodationPayment/refundRegister.jsp","register","width=500, height=400, left=200, top=100, resizable = no");
    }
    function showRM() {
        checkTableRow();
        document.getElementById("modify").setAttribute("href", "/view/accommodationPayment/refundModify.jsp?paymentId=" + encodeURI(document.getElementsByName("paymentId")[radioSelectedRow].innerHTML)+
            "&userId=" + encodeURI(document.getElementsByName("userId")[radioSelectedRow].innerHTML) + "&accommodationId=" + encodeURI(document.getElementsByName("accommodationId")[radioSelectedRow].innerHTML)+
            "&totalPeople=" + encodeURI(document.getElementsByName("totalPeople")[radioSelectedRow].innerHTML) + "&money=" + encodeURI(document.getElementsByName("money")[radioSelectedRow].innerHTML)+
            "&paymentWay=" + encodeURI(document.getElementsByName("paymentWay")[radioSelectedRow].innerHTML)+"&refund=" +encodeURI(document.getElementsByName("refund")[radioSelectedRow].innerHTML) +
            "&division=" + encodeURI(document.getElementsByName("division")[radioSelectedRow].innerHTML) + "&paidDate=" + encodeURI(document.getElementsByName("paidDate")[radioSelectedRow].innerHTML));
    }
    function showRD() {
        var check = radio;
        for (var i = 0; i < check.length; i++) {
            if (check[i].checked) {
                deleteU = "${pageContext.request.contextPath}/view/accommodationPayment/refundDelete.jsp?refund=" + encodeURI(check[i].value);
            }
        }
        window.open(deleteU, "delete", "width=500, height=400, left=200, top=100, resizable = no");
    }
</script>
</body>
</html>

