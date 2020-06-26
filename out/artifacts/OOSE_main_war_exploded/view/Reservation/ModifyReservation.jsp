<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haejun
  Date: 2020-06-25
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
            margin-left: 1rem;
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

            <label>숙박시설</label><select id = "accommodationList" name="accommodation" >
                <c:forEach items="${accommodations}" var = "accommodation">
                    <option value = "${accommodation.id}" <c:if test="${reservations.accommodationId==accommodation.id}">selected</c:if>>${accommodation.name}</option>
                </c:forEach>
            </select><br>

            <label>호실</label><select name="roomNumber" id = "roomList" onclick="accommodationChange()" >
                <option value="${reservations.roomNumber}">${reservations.roomNumber}</option>
                <c:forEach items="${roomInfos}" var = "roomInfo">
                    <option class="${roomInfo.id}" value = "${roomInfo.roomNumber}">${roomInfo.roomNumber}</option>
                </c:forEach>
            </select><br>
            <label>인원</label><input name = "headCount" type="number" placeholder="?명" min="0" value=${reservations.headCount}><br>
            <label>시작일</label><input name = "checkIn" type="date" placeholder="0000-00-00" value="${reservations.checkInDate}"><br>
            <label>종료일</label><input name = "checkOut" type="date" placeholder="0000-00-00" value="${reservations.checkOutDate}"><br>
            <label>가격</label><input name = "name" type="text" value = ${reservations.totalPrice}><br>
            <br>
            <button class="cancel" type="button" onclick=popupClose()>취소</button>
            <input class="save" type="submit" value="저장">
            <input style="visibility: hidden" name="reservationId" value=${reservations.reservation} >
        </div>
    </form>
</div>
<script>
    accommodationChange();
    function popupClose() { self.close();}
    function accommodationChange() {
        var selectedAccommodation = document.getElementById("accommodationList").value;

        var roomList = document.getElementById("roomList").children;
        for(var i=1;i<roomList.length; i++)
            if(roomList[i].className!=selectedAccommodation)
                roomList[i].style.display = "none";
            else
                roomList[i].style.display = "block";
    }
</script>
</body>
</html>

