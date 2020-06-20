<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>RegisterReservation</title>
    <style>
        strong{
            font-size:1.5rem;
        }
        label{
            display: inline-block;
            margin-right:1rem;
            margin-left:1rem;
        }
        input, select {
            float:right;
            margin-right:1rem;
            text-align: right;
        }
        .cancel{float:right;}
        .save{float:right; background-color: rgb(52, 152, 219); border-radius: 4px; margin-right:0.3rem;}
    </style>

</head>
<body>
<div class="register-contents">
    <div class="title"><strong>예약 정보 수정</strong></div><br>
    <form action="/reservation/modifyReservation" method="POST">
        <div class="input-info">
            <label>회원이름</label><input name = "name" type="text" value = ${reservations.userId}><br>
            <label>전화번호</label><input name = "tel" type="tel" value = ${reservations.phoneNum}><br>
            <label>차량번호</label><input name = "carNumber" type="text" value = ${reservations.carNumber}><br>
            <label>숙박시설</label><select name="accommodation">
<%--            <option value="">선택</option>--%>
            <option value="1" <c:if test="${reservations.accommodationId==1}"/> selected>1동</option>
            <option value="2" <c:if test="${reservations.accommodationId==2}"/> selected>2동</option>
            <option value="3" <c:if test="${reservations.accommodationId==3}"/> selected>3동</option>
            <option value="1111" <c:if test="${reservations.accommodationId==1111}"/> selected>test</option>
        </select><br>
            <label>호실</label><select name="roomNumber">
            <option value=""></option>
            <option value="101" <c:if test="${reservations.roomNumber==101}"/> selected>101</option>
            <option value="102" <c:if test="${reservations.roomNumber==102}"/> selected>102</option>
            <option value="103" <c:if test="${reservations.roomNumber==103}"/> selected>103</option>
        </select><br>
            <label>인원</label><input name = "headCount" type="number" placeholder="?명" min="0" value=${reservations.headCount}><br>
            <label>시작일</label><input name = "checkIn" type="date" placeholder="0000-00-00" value="${reservations.checkInDate}"><br>
            <label>종료일</label><input name = "checkOut" type="date" placeholder="0000-00-00" value="${reservations.checkOutDate}"><br>
            <br>
            <button class="cancel" type="button" onclick=popupClose()>취소</button>
            <input class="save" type="submit" value="저장">
            <input style="visibility: hidden" name="reservationId" value=${reservations.reservation} >
        </div>
    </form>
</div>
<script>
    function popupClose() { self.close();}
</script>
</body>
</html>

