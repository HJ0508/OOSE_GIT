<%@ page import="java.util.ArrayList" %>
<%@ page import="OOSE.Model.Facility" %><%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/FacilityManagement.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
    <script language="javascript">
        const url = "${pageContext.request.contextPath}/view/facility/";

        function register() {
            window.open(url + "FacilityInformationRegister.jsp", "register", "width=500, height=400, left=200, top=100");
        }

        function modify() {
            window.open(url + "FacilityInformationModify.jsp", "modify", "width=500, height=400, left=200, top=100");
        }

        function remove() {
            window.open(url + "FacilityInformationRemove.jsp", "remove", "width=500, height=400, left=200, top=100");
        }
    </script>
    <title>시설정보관리</title>
</head>
<body>
    <%--<%@include file="../default/header.jsp"%>--%>

<div class="sidebar">
    <div>
        <ul class="sidebar-content">
            <li><a href="${pageContext.request.contextPath}/view/facility/FacilityManagement.jsp">시설관리</a></li>
            <li><a href="${pageContext.request.contextPath}/view/facility/FacilityInformationManagement.jsp">시설정보관리</a></li>
        </ul>
    </div>
</div>
<div class="content-container">
    <div id = "content-name">
        시설 정보 조회
    </div>
    <div class="content">
        <table border="1">
            <tr>
                <td>No.</td>
                <td>시설명</td>
                <td>사업장ID</td>
                <td>시설 상태</td>
                <td>요금</td>
                <td>여는시간</td>
                <td>닫는시간</td>
                <td>시설 담당자</td>
                <td>크기</td>
                <td>선택</td>
            </tr>
            <%
                if(request.getAttribute("facility") != null) {
                    ArrayList<Facility> arr = (ArrayList<Facility>)request.getAttribute("facility");
                    for(Facility facility : arr) {
                        pageContext.setAttribute("facility", facility);
            %>
            <tr>
                <td>${facility.id}</td>
                <td>${facility.name}</td>
                <td>${facility.workPlaceId}</td>
                <td>${facility.facilityState}</td>
                <td>${facility.fee}</td>
                <td>${facility.openTime}</td>
                <td>${facility.closeTime}</td>
                <td>${facility.manager}</td>
                <td>${facility.capacity}</td>
                <td><input type="checkbox"></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <form action="/browseFacilityInformationManagement" method="POST">
            <input type="submit" value="조회">
        </form>
        <input type="button" value="등록" onclick="register()">
        <input type="button" value="수정" onclick="modify()">
        <input type="button" value="삭제" onclick="remove()">
    </div>
</div>

</body>
</html>
