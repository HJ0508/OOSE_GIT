<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시설 정보 수정</title>
</head>
<body>
<div class = "content-name">시설 정보 수정</div>
<div class = "content-container">
    <form action="/modifyFacilityInformation" method = "POST">
        <%
            String oldName = request.getParameter("name");
            String name = request.getParameter("name");
            String workPlaceId = request.getParameter("workPlaceId");
            String facilityState = request.getParameter("facilityState");
            String fee = request.getParameter("fee");
            String openTime = request.getParameter("openTime");
            String closeTime = request.getParameter("closeTime");
            String manager = request.getParameter("manager");
            String capacity = request.getParameter("capacity");
            if(name != null) {
                pageContext.setAttribute("oldName", oldName);
                pageContext.setAttribute("name", name);
                pageContext.setAttribute("workPlaceId", workPlaceId);
                pageContext.setAttribute("facilityState", facilityState);
                pageContext.setAttribute("fee", fee);
                pageContext.setAttribute("openTime", openTime);
                pageContext.setAttribute("closeTime", closeTime);
                pageContext.setAttribute("manager", manager);
                pageContext.setAttribute("capacity", capacity);
        %>
        기존시설명 <input type="text" name = "oldName" value = ${oldName} readonly><br>
        시설명 <input type="text" name = "name" value = ${name}><br>
        사업장ID <input type="text" name = "workPlaceId" value = ${workPlaceId}><br>
        시설 상태 <input type="text" name = "facilityState" value = ${facilityState}><br>
        요금 <input type="text" name = "fee" value = ${fee}><br>
        여는시간 <input type="text" name = "openTime" value = ${openTime}><br>
        닫는시간 <input type="text" name = "closeTime" value = ${closeTime}><br>
        시설 담당자 <input type="text" name = "manager" value = ${manager}><br>
        크기 <input type="text" name = "capacity" value = ${capacity}><br>
        <%
            }
        %>
        <input type="submit" value="수정">
    </form>
    <input type="button" value="취소">
</div>
</body>
</html>
