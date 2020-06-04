<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-06-02
  Time: 오후 01:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/workplaceInfoBrowse.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1><b>사업장 속성 조회</b></h1>

<form action="workplaceInfoBrowse" method = "POST">
    <fieldset>
        <label>사업장 id : </label>
        <input class="inputText" type="text" name="workplaceId" value="123" readonly>value=123
        <input type="checkbox" name="workplaceInfo" id="workplaceIdCheck" value="workplaceId"><br>
        <label>사업장 이름 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="workplaceNameCheck" value="workplaceName"><br>
        <label>사업장 관리자 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="personInChargeCheck" value="personInCharge"><br>
        <label>사업장 주소 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="addressCheck" value="address"><br>
        <label>사업장 전화번호 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="phoneNumberCheck" value="phoneNumber"><br>
        <label>사업장 상태 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="workplaceStatusCheck" value="workplaceStatus"><br>
        <label>사업장 요금 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="feeCheck" value="fee"><br>
        <label>사업장 시작시간 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="openingTimeCheck" value="openingTime"><br>
        <label>사업장 종료시간 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="closingTimeCheck" value="closingTime"><br>
        <label>사업장 면적 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="sqareMeasureCheck" value="sqareMeasure"><br>
        <label>사업장 기타정보 : </label>
        <input class="inputText" type="text" readonly>내용
        <input type="checkbox" name="workplaceInfo" id="otherInfoCheck" value="otherInfo"><br>

    </fieldset>


    <input type="submit" value="등록">
    <input type="submit" value="수정">
    <input type="submit" value="삭제">
    <input type="submit" value="조회">
</form>

</body>

</html>