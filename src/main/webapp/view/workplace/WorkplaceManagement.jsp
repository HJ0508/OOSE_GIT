<%@ page import="OOSE.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-06-21
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/html" href="${pageContext.request.contextPath}/css/FacilityManagement.css"/>
    <title>사업장 관리</title>
    <script language="javascript">
        <%--var modi = "${pageContext.request.contextPath}/view/workplace/";--%>
        var url = "${pageContext.request.contextPath}/view/workplace/";
        var deleteU = "${pageContext.request.contextPath}/view/workplace/";

        var Info = "${pageContext.request.contextPath}/view/workPlaceInfo/";

        function register() {
            window.open(url + "workplaceRegister.jsp", "register", "width=500, height=400, left=200, top=100");
        }
        function modify() {
            var check = document.getElementsByName("radio");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    var modi = url + "workplaceModify.jsp?name=" + encodeURI(check[i].value);
                }
            }
            window.open(modi, "modify", "width=500, height=400, left=200, top=100, resizable = no");
        }
        function deleteW() {
            var check = document.getElementsByName("radio");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    deleteU = "${pageContext.request.contextPath}/view/workplace/workplaceDelete.jsp?name=" + encodeURI(check[i].value);
                }
            }
            window.open(deleteU, "deleteW", "width=500, height=400, left=200, top=100, resizable = no");
        }

        // 이 부분을 건드리시면 될거 같아요!
        function workplaceInfo() {
            var check = document.getElementsByName("radio");
            for(var i =0 ; i<check.length; i++){
                if (check[i].checked){
                    Info = "${pageContext.request.contextPath}/view/workPlaceInfo/workplaceInfoBrowse.jsp?workplaceId=" + encodeURI(check[i].value);
                }
            }
            window.open(Info, "workplaceInfo", "width=500, height=400, left=200, top=100, resizable = no");
        }
        function browseOpen(){
            var formDatas = window.document.forms[0];
            const leftPosition = (window.screen.width-1000)/2;
            const topPosition = (window.screen.height-800)/2;
            const popOption = "width=1000, height=800, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open("","browsePop",popOption);

            formDatas.target = "browsePop";
            formDatas.action = "/workplace/browseWorkplaceInfo"
            formDatas.submit();
        }
    </script>
</head>
<body>
<%@include file="../default/header.jsp" %>

<div class="sidebar">
    <div>
        <ul class="sidebar-content">
            <li><a href="${pageContext.request.contextPath}/view/workplace/WorkplaceManagement.jsp">사업장관리</a></li>
            <li><a href="${pageContext.request.contextPath}/view/workPlaceInfo/WorkplaceInfoManagement.jsp">사업장정보관리</a>
            </li>
        </ul>
    </div>
</div>
<div class="content-container">
    <div id="content-name">
        사업장 조회
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
                    if (request.getAttribute("workplace") != null) {
                        ArrayList<Workplace> arr = (ArrayList<Workplace>) request.getAttribute("workplace");
                        for (Workplace workplace : arr) {
                            pageContext.setAttribute("workplace", workplace);
                %>
                <tr>
                    <td id="id">${workplace.id}</td>
                    <td id="name">${workplace.name}</td>
                    <td><input type="radio" name="workplaceId" value="${workplace.id}"></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
        <input type="button" value="상세정보" onclick=browseOpen()>
        <input type="button" value="등록" onclick="register();"/>
        <input type="button" value="수정" onclick="modify();"/>
        <input type="button" value="삭제" onclick="deleteW();"/>
    </form>
    <form action="/browseWorkplaceManagement" method="POST">
        <input type="submit" value="조회">
    </form>
</div>
</body>
</html>
