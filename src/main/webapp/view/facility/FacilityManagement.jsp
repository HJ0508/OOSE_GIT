<%@ page import="OOSE.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-05-31
  Time: 오후 6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/FacilityManagement.css"/>
    <title>시설관리</title>
    <script language="javascript">
        const url = "${pageContext.request.contextPath}/view/facility/";

        function register() {
            window.open(url + "FacilityRegister.jsp", "register", "width=500, height=400, left=200, top=100");
        }

        function modify() {
            window.open(url + "FacilityModify.jsp", "modify", "width=500, height=400, left=200, top=100");
        }

        function remove() {
            window.open(url + "FacilityRemove.jsp", "remove", "width=500, height=400, left=200, top=100");
        }
    </script>
</head>
<body>
<%--<%@include file="../default/header.jsp" %>--%>

<div class="sidebar">
    <div>
        <ul class="sidebar-content">
            <li><a href="${pageContext.request.contextPath}/view/facility/FacilityManagement.jsp">시설관리</a></li>
            <li><a href="${pageContext.request.contextPath}/view/facility/FacilityInformationManagement.jsp">시설정보관리</a></li>
        </ul>
    </div>
</div>
<div class="content-container">
    <div id="content-name">
        시설 조회
    </div>
    <br>
    <br>
    <br>
    <form action="/browseFacilityManagement" method="POST">
        <input type="submit" value="조회">
    </form>
    <input type="button" value="등록" onclick="register();"/>
    <input type="button" value="수정" onclick="modify();"/>
    <input type="button" value="삭제" onclick="remove();"/>

    <div class="content">
        <table border="1">
            <tr>
                <td>No.</td>
                <td>Name</td>
                <td>선택</td>
            </tr>
            <%
                int cnt = 1;
                if(request.getAttribute("facility") != null) {
                    ArrayList<Facility> arr = (ArrayList<Facility>)request.getAttribute("facility");
                    for(Facility facility : arr) {
                        pageContext.setAttribute("facility", facility);
            %>
            <tr>
                <td>${facility.id}</td>
                <td>${facility.name}</td>
                <td><input type="checkbox" id = "${facility.id}" value="${facility.name}"></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</div>

</body>
</html>