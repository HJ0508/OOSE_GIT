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

<h1><b>사업장 속성 수정</b></h1>


<%
    Workplace workplace = (Workplace)request.getAttribute("content");
    pageContext.setAttribute("workplace", workplace); //이렇게 해야 ${}해서 쓸수있는듯!

    String[] isVisible = (String[])request.getAttribute("isVisible");
    pageContext.setAttribute("isVisible", isVisible);

%>



<form method = "POST">
    <fieldset>
        <div ${isVisible[0]}>
            <label >사업장 id : </label>
            <input class="inputText" type=text name="workplaceId"   value=${workplace.getId()}>
            <br>
        </div>
        <div ${isVisible[1]}>
            <label>사업장 이름 : </label>
            <input class="inputText" type=text name="workplaceName"  value="${workplace.getName()}" >
            <br>
        </div>
        <div ${isVisible[2]}>
            <label>사업장 관리자 : </label>
            <input class="inputText" type=text  name="manager"  value="${workplace.getManager()}">
            <br>
        </div>
        <div ${isVisible[3]}>
            <label>사업장 주소 : </label>
            <input class="inputText" type=text  name="address"  value="${workplace.getAddress()}">
            <br>
        </div>
        <div ${isVisible[4]}>
            <label>사업장 전화번호 : </label>
            <input class="inputText" type=text name="phoneNumber"  value="${workplace.getPhoneNumber()}">
            <br>
        </div>
        <div ${isVisible[5]}>
            <label>사업장 상태 : </label>
            <input class="inputText" type=text name="workplaceStatus"  value="${workplace.getStatus()}">
            <br>
        </div>
        <div ${isVisible[6]}>
            <label>사업장 요금 : </label>
            <input class="inputText" type=text name="fee"  value="${workplace.getFee()}">
            <br>
        </div>
        <div ${isVisible[7]}>
            <label>사업장 시작시간 : </label>
            <input class="inputText" type=text name="openingTime"  value="${workplace.getOpeningTime()}">
            <br>
        </div>
        <div ${isVisible[8]}>
            <label>사업장 종료시간 : </label>
            <input class="inputText" type=text name="closingTime"  value="${workplace.getClosingTime()}">
            <br>
        </div>
        <div ${isVisible[9]}>
            <label>사업장 면적 : </label>
            <input class="inputText" type=text name="squareMeasure"  value="${workplace.getSquare()}">
            <br>
        </div>
        <div ${isVisible[10]}>
            <label>사업장 기타정보 : </label>
            <input class="inputText" type=text name="otherInfo"  value="${workplace.getOtherInfo()}">
        </div>

    </fieldset>



    <input type="submit" value="등록" formaction="/workplace/registerWorkplaceInfo">

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