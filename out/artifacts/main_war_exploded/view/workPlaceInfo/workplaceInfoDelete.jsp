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


<%
    Workplace workplace = (Workplace)request.getAttribute("content");
    pageContext.setAttribute("workplace", workplace); //이렇게 해야 ${}해서 쓸수있는듯!

    String[] modifyEditable = (String[])request.getAttribute("modifyEditable");
    pageContext.setAttribute("modifyEditable", modifyEditable);

%>



<form method = "POST">
    <fieldset>
        <label type=${modifyEditable[0]}>사업장 id : </label>
        <input class="inputText" type=${modifyEditable[0]} name="workplaceId"  readonly value=${workplace.getId()}>value=123
        <br>
        <label>사업장 이름 : </label>
        <input class="inputText" type=${modifyEditable[1]} name="workplaceName" readonly value="${workplace.getName()}" >내용
        <br>
        <label>사업장 관리자 : </label>
        <input class="inputText" type=${modifyEditable[2]}  name="manager" readonly value="${workplace.getManager()}">내용
        <br>
        <label>사업장 주소 : </label>
        <input class="inputText" type=${modifyEditable[3]}  name="address" readonly value="${workplace.getAddress()}">내용
        <br>
        <label>사업장 전화번호 : </label>
        <input class="inputText" type=${modifyEditable[4]} name="phoneNumber" readonly value="${workplace.getPhoneNumber()}">내용
        <br>
        <label>사업장 상태 : </label>
        <input class="inputText" type=${modifyEditable[5]} name="workplaceStatus" readonly value="${workplace.getStatus()}">내용
        <br>
        <label>사업장 요금 : </label>
        <input class="inputText" type=${modifyEditable[6]} name="fee" readonly value="${workplace.getFee()}">내용
        <br>
        <label>사업장 시작시간 : </label>
        <input class="inputText" type=${modifyEditable[7]} name="openingTime" readonly value="${workplace.getOpeningTime()}">내용
        <br>
        <label>사업장 종료시간 : </label>
        <input class="inputText" type=${modifyEditable[8]} name="closingTime" readonly value="${workplace.getClosingTime()}">내용
        <br>
        <label>사업장 면적 : </label>
        <input class="inputText" type=${modifyEditable[9]} name="squareMeasure" readonly value="${workplace.getSquare()}">내용
        <br>
        <label>사업장 기타정보 : </label>
        <input class="inputText" type=${modifyEditable[10]} name="otherInfo" readonly value="">내용


    </fieldset>



    <input type="submit" value="삭제" formaction="/workplace/deleteWorkplaceInfo">

    <%--    <input type="submit" value="조회" formaction="/workplace/browseWorkplaceInfo">--%>

</form>

</body>
<script>
    function registerOpen(){
        const popUrl = "${pageContext.request.contextPath}/view/workPlace/workplaceRegister.jsp";	//팝업창에 출력될 페이지 URL
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open(popUrl,"",popOption);
    }


</script>


</html>