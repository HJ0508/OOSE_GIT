<%@ page import="OOSE.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-05-31
  Time: 오후 6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/FacilityManage.css" rel="stylesheet" type="text/css">
    <title>시설관리</title>
    <script language="javascript">
        let modi = "${pageContext.request.contextPath}/view/facility/";
        let url = "${pageContext.request.contextPath}/view/facility/";
        let deleteU = "${pageContext.request.contextPath}/view/facility/";

        function register() {
            const leftPosition = (window.screen.width-500)/2;
            const topPosition = (window.screen.height-450)/2;
            const popOption = "width=500, height=450, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open(url + "RegisterFacility.jsp", "register", popOption);
        }

        function modify() {
            var check = document.getElementsByName("radio");

            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    modi = "${pageContext.request.contextPath}/view/facility/ModifyFacility.jsp?name=" + encodeURI(check[i].value);
                }
            }
            const leftPosition = (window.screen.width-500)/2;
            const topPosition = (window.screen.height-450)/2;
            const popOption = "width=500, height=450, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open(modi, "modify", popOption);
        }

        function remove() {
            var check = document.getElementsByName("radio");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    deleteU = "${pageContext.request.contextPath}/view/facility/DeleteFacility.jsp?name=" + encodeURI(check[i].value);
                }
            }
            const leftPosition = (window.screen.width-500)/2;
            const topPosition = (window.screen.height-450)/2;
            const popOption = "width=500, height=450, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open(deleteU, "delete", popOption);
        }
    </script>
</head>
<body>
<%@ include file="../Default/Header.jsp" %>
<div class="side-menu">
    <ul>
        <li><a class = "alink" href="${pageContext.request.contextPath}/view/facility/FacilityManagement.jsp">시설관리</a></li>
        <li><a class = "alink" href="${pageContext.request.contextPath}/view/facility/FacilityInformationManagement.jsp">시설정보관리</a></li>
    </ul>
</div>
<div class="content-container">
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
        <input class="btn" type="button" value="등록" onclick="register();"/>
        <input class="btn" type="button" value="수정" onclick="modify();"/>
        <input class="btn" type="button" value="삭제" onclick="remove();"/>
    </form>
    <form action="/browseFacilityManagement" method="POST">
        <input class="btn" type="submit" value="조회">
    </form>
</div>

</body>
</html>