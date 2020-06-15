<%@ page import="java.util.ArrayList" %>
<%@ page import="OOSE.model.Facility" %><%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/FacilityInformationManagement.css"/>
    <script language="javascript">
        let registerurl = "${pageContext.request.contextPath}/view/facility/";
        let modifyurl = "${pageContext.request.contextPath}/view/facility/";
        let deleteurl = "${pageContext.request.contextPath}/view/facility/";
        function register() {
            checkTableRow();
            registerurl = "${pageContext.request.contextPath}/view/facility/FacilityInformationRegister.jsp?name=" + encodeURI(document.getElementsByName("name")[radioSelectedRow].innerHTML);
            console.log(registerurl);
            window.open(registerurl, "register", "width=500, height=400, left=200, top=100");
        }

        function modify() {
            checkTableRow();
            modifyurl = "${pageContext.request.contextPath}/view/facility/FacilityInformationModify.jsp?name=" + encodeURI(document.getElementsByName("name")[radioSelectedRow].innerHTML) +
                "&workspaceId=" + encodeURI(document.getElementsByName("workspaceId")[radioSelectedRow].innerHTML) + "&fee=" + encodeURI(document.getElementsByName("fee")[radioSelectedRow].innerHTML) +
                    "&openTime=" + encodeURI(document.getElementsByName("openTime")[radioSelectedRow].innerHTML) + "&closeTime" + encodeURI(document.getElementsByName("closeTime")[radioSelectedRow].innerHTML) +
                        "&manager=" + encodeURI(document.getElementsByName("manager")[radioSelectedRow].innerHTML) + "&capacity=" + encodeURI(document.getElementsByName("capacity")[radioSelectedRow].innerHTML);
            console.log(modifyurl);
            window.open(modifyurl, "modify", "width=500, height=400, left=200, top=100");
        }

        function remove() {
            checkTableRow();
            deleteurl = "${pageContext.request.contextPath}/view/facility/FacilityInformationDelete.jsp?name=" + encodeURI(document.getElementsByName("name")[radioSelectedRow].innerHTML);
            console.log(deleteurl);
            window.open(deleteurl, "remove", "width=500, height=400, left=200, top=100");
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
    <form>
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
                    <td id = "id">${facility.id}</td>
                    <td id = "name">${facility.name}</td>
                    <td id = "workPlaceId">${facility.workPlaceId}</td>
                    <td id = "facilityState">${facility.facilityState}</td>
                    <td id = "fee">${facility.fee}</td>
                    <td id = "openTime">${facility.openTime}</td>
                    <td id = "closeTime">${facility.closeTime}</td>
                    <td id = "manager">${facility.manager}</td>
                    <td id = "capacity">${facility.capacity}</td>
                    <td><input type="radio" name = "radio" value = "${facility.name}"></td>
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
    </form>
</div>

</body>
</html>
