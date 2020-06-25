<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-06-02
  Time: 오후 01:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "OOSE.Model.Workplace" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/workplaceInfoBrowse.css" rel="stylesheet" type="text/css">
</head>
<body>

<h1><b>사업장 속성 조회</b></h1>

<%
    Workplace workplace = (Workplace)request.getAttribute("content");
    pageContext.setAttribute("workplace", workplace); //이렇게 해야 ${}해서 쓸수있는듯!
%>

<%
    String id = (String)session.getAttribute("id") ;
    int authority = (Integer)session.getAttribute("authority");
%>

<form method = "POST" name="formData">
    <fieldset>
        <label>사업장 id : </label>
        <input class="inputText" type="text" name="workplaceId"  value="${workplace.getId()}">
        <br>
        <label>사업장 이름 : </label>
        <input class="inputText" type="text" name="workplaceName" readonly value="${workplace.getName()}" >
        <input type="checkbox" name="workplaceInfo" id="workplaceNameCheck" value="workplaceName"><br>
        <label>사업장 관리자 : </label>
        <input class="inputText" type="text" name="manager" readonly value="${workplace.getManager()}">
        <input type="checkbox" name="workplaceInfo" id="personInChargeCheck" value="manager"><br>
        <label>사업장 주소 : </label>
        <input class="inputText" type="text" name="address" readonly value="${workplace.getAddress()}">
        <input type="checkbox" name="workplaceInfo" id="addressCheck" value="address"><br>
        <label>사업장 전화번호 : </label>
        <input class="inputText" type="text" name="phoneNumber" readonly value="${workplace.getPhoneNumber()}">
        <input type="checkbox" name="workplaceInfo" id="phoneNumberCheck" value="phoneNumber"><br>
        <label>사업장 상태 : </label>
        <input class="inputText" type="text" name="workplaceStatus" readonly value="${workplace.getStatus()}">
        <input type="checkbox" name="workplaceInfo" id="workplaceStatusCheck" value="workplaceStatus"><br>
        <label>사업장 요금 : </label>
        <input class="inputText" type="text" name="fee" readonly value="${workplace.getFee()}">
        <input type="checkbox" name="workplaceInfo" id="feeCheck" value="fee"><br>
        <label>사업장 시작시간 : </label>
        <input class="inputText" type="text" name="openingTime" readonly value="${workplace.getOpeningTime()}">
        <input type="checkbox" name="workplaceInfo" id="openingTimeCheck" value="openingTime"><br>
        <label>사업장 종료시간 : </label>
        <input class="inputText" type="text" name="closingTime" readonly value="${workplace.getClosingTime()}">
        <input type="checkbox" name="workplaceInfo" id="closingTimeCheck" value="closingTime"><br>
        <label>사업장 면적 : </label>
        <input class="inputText" type="text" name="squareMeasure" readonly value="${workplace.getSquare()}">
        <input type="checkbox" name="workplaceInfo" id="squareMeasureCheck" value="squareMeasure"><br>
        <label>사업장 기타정보 : </label>
        <input class="inputText" type="text" name="otherInfo" readonly value="${workplace.getOtherInfo()}">
        <input type="checkbox" name="workplaceInfo" id="otherInfoCheck" value="otherInfo"><br>

    </fieldset>


    <input type="button" value="등록" onclick = registerOpen()>
    <input type="button" value="수정" onclick = modifyOpen()>
    <input type="button" value="삭제" onclick = deleteOpen()>
    <input type="button" value="조회" onclick = browseOpen()>
    <input type="submit" value="취소" onclick = "cancel()">
</form>

</body>
<script type="text/javascript">
    function registerOpen(){
        var formDatas = document.formData;
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-500)/2;
        const popOption = "width=500, height=500, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open("","registerPop",popOption);

        formDatas.target = "registerPop";
        formDatas.action = "/workplace/viewRegisterWorkplaceInfo"
        formDatas.submit();
    }

    function modifyOpen(){
        var formDatas = document.formData;
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-500)/2;
        const popOption = "width=500, height=500, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open("","modifyPop",popOption);

        formDatas.target = "modifyPop";
        formDatas.action = "/workplace/viewModifyWorkplaceInfo"
        formDatas.submit();
    }
    function deleteOpen(){
        var formDatas = document.formData;
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-500)/2;
        const popOption = "width=500, height=500, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open("","deletePop",popOption);

        formDatas.target = "deletePop";
        formDatas.action = "/workplace/viewDeleteWorkplaceInfo"
        formDatas.submit();
    }
    function browseOpen(){
        var formDatas = document.formData;
        const leftPosition = (window.screen.width-1000)/2;
        const topPosition = (window.screen.height-800)/2;
        const popOption = "width=1000, height=800, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open("","browsePop",popOption);

        formDatas.target = "browsePop";
        formDatas.action = "/workplace/browseWorkplaceInfo";
        formDatas.submit();
    }

    function cancel(){
        window.close();
    }

</script>


</html>