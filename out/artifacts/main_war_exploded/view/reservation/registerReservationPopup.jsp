<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-06-02
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core%" prefix="c"%>
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
    <div class="title"><strong>예약 정보 등록</strong></div><br>
    <form action="/reservation/registerReservation" method="POST">
        <div class="input-info">
            <label>회원이름</label><input name = "name" type="text" placeholder="이름을 입력하시오"><br>
            <label>전화번호</label><input name = "tel" type="tel" placeholder="전화번호를 입력하시오"><br>
            <label>차량번호</label><input name = "carNumber" type="text" placeholder="차량번호를 입력하시오"><br>

            <label>숙박시설</label><select name="accommodation" onchange="accommodationChange(this)">
                <option value="">선택</option>
                <c:forEach items="${accommodations}" var = "accommodation">
                    <option value = "${accommodation.id}">${accommodation.name}</option>
                </c:forEach>
            </select><br>

            <label>호실</label><select name="roomNumber" id = "roomList">
                <option value="">선택</option>
                <c:forEach items="${roomInfos}" var = "roomInfo">
                    <option class = "${roomInfo.id}" value = "${roomInfo.roomNumber}">${roomInfo.roomNumber}</option>
                </c:forEach>
            </select><br>
            <label>인원</label><input name = "headCount" type="number" placeholder="?명" min="0"><br>
            <label>시작일</label><input name = "checkIn" type="date" placeholder="0000-00-00"><br>
            <label>종료일</label><input name = "checkOut" type="date" placeholder="0000-00-00"><br>
            <br>
            <button class="cancel" type="button" onclick=popupClose()>취소</button>
            <input class="save" type="submit" value="저장">
            <input name="condition" value="예약" style="visibility: hidden">
        </div>
    </form>
</div>
<script>
    function popupClose() { self.close();}

    function accommodationChange(accommodation) {
        var roomList = document.getElementById("roomList").children;
        for(var i=1;i<roomList.length; i++)
            if(roomList[i].className!=accommodation.value)
                roomList[i].style.display = "none";
            else
                roomList[i].style.display = "block";
    }
</script>
</body>
</html>

