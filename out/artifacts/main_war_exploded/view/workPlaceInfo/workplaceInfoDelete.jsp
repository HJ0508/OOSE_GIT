<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-06-02
  Time: 오후 01:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "OOSE.model.Workplace" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/workplaceInfoBrowse.css" rel="stylesheet" type="text/css">
</head>
<body>

<h1><b>사업장 속성 삭제</b></h1>
<p>다음의 정보를 정말 삭제 하시겠습니까?</p>


<%
    Workplace workplace = (Workplace)request.getAttribute("content");
    pageContext.setAttribute("workplace", workplace); //이렇게 해야 ${}해서 쓸수있는듯!

    String[] isVisible = (String[])request.getAttribute("isVisible");
    pageContext.setAttribute("isVisible", isVisible);

    String[] pastInfo = (String[])request.getAttribute("pastInfo");
    pageContext.setAttribute("pastInfo", pastInfo);
%>



<form method = "POST">
    <fieldset>
        <div ${isVisible[0]}>
            <label >사업장 id : </label>
            <input type = text value = "${pastInfo[0]}">
            <input class="inputText" type=hidden name="workplaceId"   value="${workplace.getId()}">
            <br>
        </div>
        <div ${isVisible[1]}>
            <label>사업장 이름 : </label>
            <input type = text value = "${pastInfo[1]}">
            <input class="inputText" type=hidden name="workplaceName"  value="${workplace.getName()}" >
            <br>
        </div>
        <div ${isVisible[2]}>
            <label>사업장 관리자 : </label>
            <input type = text value = "${pastInfo[2]}">
            <input class="inputText" type=hidden  name="manager"  value="${workplace.getManager()}">
            <br>
        </div>
        <div ${isVisible[3]}>
            <label>사업장 주소 : </label>
            <input type = text value = "${pastInfo[3]}">
            <input class="inputText" type=hidden name="address"  value="${workplace.getAddress()}">
            <br>
        </div>
        <div ${isVisible[4]}>
            <label>사업장 전화번호 : </label>
            <input type = text value = "${pastInfo[4]}">
            <input class="inputText" type=hidden name="phoneNumber"  value="${workplace.getPhoneNumber()}">
            <br>
        </div>
        <div ${isVisible[5]}>
            <label>사업장 상태 : </label>
            <input type = text value = "${pastInfo[5]}">
            <input class="inputText" type=hidden name="workplaceStatus"  value="${workplace.getStatus()}">
            <br>
        </div>
        <div ${isVisible[6]}>
            <label>사업장 요금 : </label>
            <input type = text value = "${pastInfo[6]}">
            <input class="inputText" type=hidden name="fee"  value="${workplace.getFee()}">
            <br>
        </div>
        <div ${isVisible[7]}>
            <label>사업장 시작시간 : </label>
            <input type = text value = "${pastInfo[7]}">
            <input class="inputText" type=hidden name="openingTime"  value="${workplace.getOpeningTime()}">
            <br>
        </div>
        <div ${isVisible[8]}>
            <label>사업장 종료시간 : </label>
            <input type = text value = "${pastInfo[8]}">
            <input class="inputText" type=hidden name="closingTime"  value="${workplace.getClosingTime()}">
            <br>
        </div>
        <div ${isVisible[9]}>
            <label>사업장 면적 : </label>
            <input type = text value = "${pastInfo[9]}">
            <input class="inputText" type=hidden name="squareMeasure"  value="${workplace.getSquare()}">
            <br>
        </div>
        <div ${isVisible[10]}>
            <label>사업장 기타정보 : </label>
            <input type = text value = "${pastInfo[10]}">
            <input class="inputText" type=hidden name="otherInfo"  value="">
        </div>

    </fieldset>



    <input type="submit" value="삭제" formaction="/workplace/deleteWorkplaceInfo">

    <%--    <input type="submit" value="조회" formaction="/workplace/browseWorkplaceInfo">--%>

</form>

</body>
<script>
    function registerOpen(){
        const popUrl = "${pageContext.request.contextPath}/view/workPlace/workplaceDelete.jsp";	//팝업창에 출력될 페이지 URL
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open(popUrl,"",popOption);
    }


</script>


</html>