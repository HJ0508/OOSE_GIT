<%@ page import="OOSE.model.*" %>
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
    <link rel="stylesheet" type="text/html" href="${pageContext.request.contextPath}/css/FacilityManagement.css"/>
    <title>시설관리</title>
    <script language="javascript">
        let modi = "${pageContext.request.contextPath}/view/facility/";
        let url = "${pageContext.request.contextPath}/view/facility/";
        let deleteU = "${pageContext.request.contextPath}/view/facility/";
        function register() {
            window.open(url + "FacilityRegister.jsp", "register", "width=500, height=400, left=200, top=100");
        }

        function modify() {
            var check = document.getElementsByName("radio");

            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    modi = "${pageContext.request.contextPath}/view/facility/FacilityModify.jsp?name=" + encodeURI(check[i].value);
                }
            }
            window.open(modi, "modify", "width=500, height=400, left=200, top=100, resizable = no");
        }

        function remove() {
            var check = document.getElementsByName("radio");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    deleteU = "${pageContext.request.contextPath}/view/facility/FacilityDelete.jsp?name=" + encodeURI(check[i].value);
                }
            }
            window.open(deleteU, "delete", "width=500, height=400, left=200, top=100, resizable = no");
        }
    </script>
</head>
<body>
<%@include file="../default/header.jsp" %>

<div class="sidebar">
    <div>
        <ul class="sidebar-content">
            <li><a href="${pageContext.request.contextPath}/view/facility/FacilityManagement.jsp">시설관리</a></li>
            <li><a href="${pageContext.request.contextPath}/view/facility/FacilityInformationManagement.jsp">시설정보관리</a>
            </li>
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

    <form>
        <div class="content">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>선택</td>
                </tr>
                <%
                    if (request.getAttribute("facility") != null) {
                        ArrayList<Facility> arr = (ArrayList<Facility>) request.getAttribute("facility");
                        for (Facility facility : arr) {
                            pageContext.setAttribute("facility", facility);
                %>
                <tr>
                    <td id="id">${facility.id}</td>
                    <td id="name">${facility.name}</td>
                    <td><input type="radio" name="radio" value="${facility.name}"></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>

        <input type="button" value="등록" onclick="register();"/>
        <input type="button" value="수정" onclick="modify();"/>
        <input type="button" value="삭제" onclick="remove();"/>
    </form>
    <form action="/browseFacilityManagement" method="POST">
        <input type="submit" value="조회">
    </form>



</div>

</body>
</html>