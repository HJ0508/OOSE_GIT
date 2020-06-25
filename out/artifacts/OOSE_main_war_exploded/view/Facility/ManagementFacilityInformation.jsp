<%@ page import="java.util.ArrayList" %>
<%@ page import="OOSE.Model.Facility" %><%--
  Created by IntelliJ IDEA.
  User: tngh1
  Date: 2020-06-01
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/FacilityManage.css" rel="stylesheet" type="text/css">
    <title>시설정보관리</title>
    <script language="javascript">
        var radiocheck;
        let registerUrl = "${pageContext.request.contextPath}/view/Facility/";
        let modifyUrl = "${pageContext.request.contextPath}/view/Facility/";
        let deleteUrl = "${pageContext.request.contextPath}/view/Facility/";

        function register() {
            var check = document.getElementsByName("radio");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    radiocheck = i;
                    console.log(check[i].value);
                    registerUrl = "${pageContext.request.contextPath}/view/Facility/RegisterFacilityInformation.jsp?name=" + check[i].value;
                }
            }
            const leftPosition = (window.screen.width-500)/2;
            const topPosition = (window.screen.height-450)/2;
            const popOption = "width=500, height=450, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open(registerUrl, "register", popOption);
        }

        function modify() {
            var check = document.getElementsByName("radio");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    radiocheck = i;
                }
            }
            modifyUrl = "${pageContext.request.contextPath}/view/Facility/ModifyFacilityInformation.jsp?name=" + document.getElementsByName("name")[radiocheck].innerHTML +
                "&workPlaceId=" + document.getElementsByName("workPlaceId")[radiocheck].innerHTML + "&facilityState=" + document.getElementsByName("facilityState")[radiocheck].innerHTML +
                "&fee=" + document.getElementsByName("fee")[radiocheck].innerHTML + "&openTime=" + document.getElementsByName("openTime")[radiocheck].innerHTML +
                "&closeTime=" + document.getElementsByName("closeTime")[radiocheck].innerHTML +
                "&manager=" + document.getElementsByName("manager")[radiocheck].innerHTML + "&capacity=" + document.getElementsByName("capacity")[radiocheck].innerHTML;
            const leftPosition = (window.screen.width-500)/2;
            const topPosition = (window.screen.height-450)/2;
            const popOption = "width=500, height=450, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open(modifyUrl, "modify", popOption);
        }

        function remove() {
            var check = document.getElementsByName("radio");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    radiocheck = i;
                }
            }
            deleteUrl = "${pageContext.request.contextPath}/view/Facility/DeleteFacilityInformation.jsp?name=" + document.getElementsByName("name")[radiocheck].innerHTML;
            console.log(deleteUrl);
            const leftPosition = (window.screen.width-500)/2;
            const topPosition = (window.screen.height-450)/2;
            const popOption = "width=500, height=450, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open(deleteUrl, "remove", popOption);
        }
    </script>

</head>
<body>
<%@ include file="../Default/Header.jsp" %>
<div class="side-menu">
    <ul>
        <li><a class = "alink" href="${pageContext.request.contextPath}/view/Facility/ManagementFacility.jsp">시설관리</a></li>
        <li><a class = "alink" href="${pageContext.request.contextPath}/view/Facility/ManagementFacilityInformation.jsp">시설정보관리</a></li>
    </ul>
</div>
<div class="content-container">
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
                    if (request.getAttribute("facility") != null) {
                        ArrayList<Facility> arr = (ArrayList<Facility>) request.getAttribute("facility");
                        for (Facility facility : arr) {
                            pageContext.setAttribute("facility", facility);
                            int facilityWorkplaceId = facility.getWorkPlaceId();
                            if(facilityWorkplaceId == 0) {
                %>
                <tr>
                    <td name="id" value="${facility.id}">${facility.id}</td>
                    <td name="name" value="${facility.name}">${facility.name}</td>
                    <td name="workPlaceId" value="${facility.workPlaceId}"></td>
                    <td name="facilityState" value="${facility.facilityState}"> ${facility.facilityState}</td>
                    <td name="fee" value="${facility.fee}"></td>
                    <td name="openTime" value="${facility.openTime}"> ${facility.openTime}</td>
                    <td name="closeTime" value="${facility.closeTime}"> ${facility.closeTime}</td>
                    <td name="manager" value="${facility.manager}"> ${facility.manager}</td>
                    <td name="capacity" value="${facility.capacity}"></td>
                    <td><input type="radio" name="radio" value="${facility.name}"></td>
                </tr>
                <%
                            }
                            else {

                %>
                <tr>
                    <td name="id" value="${facility.id}">${facility.id}</td>
                    <td name="name" value="${facility.name}">${facility.name}</td>
                    <td name="workPlaceId" value="${facility.workPlaceId}">${facility.workPlaceId}</td>
                    <td name="facilityState" value="${facility.facilityState}"> ${facility.facilityState}</td>
                    <td name="fee" value="${facility.fee}"> ${facility.fee}</td>
                    <td name="openTime" value="${facility.openTime}"> ${facility.openTime}</td>
                    <td name="closeTime" value="${facility.closeTime}"> ${facility.closeTime}</td>
                    <td name="manager" value="${facility.manager}"> ${facility.manager}</td>
                    <td name="capacity" value="${facility.capacity}"> ${facility.capacity}</td>
                    <td><input type="radio" name="radio" value="${facility.name}"></td>
                </tr>
                <%
                            }
                        }
                    }
                %>
            </table>
        </div>
        <input class="btn" type="button" value="등록" onclick="register()">
        <input class="btn" type="button" value="수정" onclick="modify()">
        <input class="btn" type="button" value="삭제" onclick="remove()">
    </form>
    <form action="/browseFacilityInformationManagement" method="POST">
        <input class="btn" type="submit" value="조회">
    </form>

</div>

</body>
</html>
