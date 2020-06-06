<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-06-02
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ModifyReservation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
    <style>
        .item {
            display: block;
            margin-left: 5rem;
            margin-right: 5rem;
            height: 1.5rem;
            border-bottom: 1px solid #797979 ;
        }

        .item select,
        .item input{
            float: right;
        }

        .cancel{float:right;}
        .save{float:right; background-color: rgb(52, 152, 219); border-radius: 4px; margin-right:0.3rem;}
    </style>
</head>
<body>
    <%@ include file="../default/header.jsp"%>
    <div class = "contents-container">
        <!-- 왼쪽 메뉴바 -->
        <%@ include file="reservationNavigationBar.jsp"%>
        <!-- 내용 -->
        <div class="contents">
            <div class="title"><strong>예약 수정</strong></div><br>
            <form method="POST">
                <div class="input-info">
                    <div class="item"><label>예약번호</label><input name = "reservationId" type="text" readonly="true" value=${reservations.reservation}><br></div>
                    <div class="item"><label>회원이름</label><input name = "name" type="text" readonly="true" value=${reservations.userId}><br></div>
                    <div class="item"><label>전화번호</label><input name = "tel" type="tel" readonly="true" value=${reservations.phoneNum}><br></div>
                    <div class="item"><label>차량번호</label><input name = "carNumber" type="text" value=${reservations.carNumber}><br></div>
                    <div class="item"><label>숙박시설</label><select name="accommodation" value=${reservations.accommodationId}>
                    <option value="">선택</option>
                    <option value="">1동</option>
                    <option value="">2동</option>
                    <option value="">3동</option>
                    <option value="1111">test</option>
                </select><br></div>
                    <div class="item"><label>호실</label><select name="roomNumber" value=${reservations.roomNumber}>
                    <option value="">선택</option>
                    <option value="101">101</option>
                    <option value="102">102</option>
                    <option value="103">103</option>
                </select><br></div>
                    <div class="item"><label>인원</label><input name = "headCount" type="number" value=${reservations.headCount}><br></div>
                    <div class="item"><label>시작일</label><input name = "checkIn" type="date" value=${reservations.checkInDate}><br></div>
                    <div class="item"><label>종료일</label><input name = "checkOut" type="date" value=${reservations.checkOutDate}><br></div>
                    <br>
                    <div class="item">
                        <button class="cancel" type="button" onclick="location.href='/view/reservation/reservationBrowse.jsp'">취소</button>
                        <input class="save" type="submit" value="저장" formaction="/reservation/modifyReservation">
                    </div>
                </div>
            </form>
        </div>
    </div>
<script>


</script>
</body>
</html>

