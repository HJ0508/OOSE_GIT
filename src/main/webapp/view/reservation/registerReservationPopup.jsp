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
    <div class="title"><strong>예약 정보 등록</strong></div><br>
    <form action="/reservation/registerReservation" method="POST">
        <div class="input-info">
            <label>회원이름</label><input name = "name" type="text" placeholder="이름을 입력하시오"><br>
            <label>전화번호</label><input name = "tel" type="tel" placeholder="전화번호를 입력하시오"><br>
            <label>차량번호</label><input name = "carNumber" type="text" placeholder="차량번호를 입력하시오"><br>
            <label>숙박시설</label><select name="accommodation">
            <option value="">선택</option>
            <option value="">1동</option>
            <option value="">2동</option>
            <option value="">3동</option>
            <option value="1111">test</option>
            </select><br>
            <label>호실</label><select name="roomNumber">
            <option value="">선택</option>
            <option value="101">101</option>
            <option value="102">102</option>
            <option value="103">103</option>
        </select><br>
            <label>인원</label><input name = "headCount" type="number" placeholder="?명"><br>
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
</script>
</body>
</html>

