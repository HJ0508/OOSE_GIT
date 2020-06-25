<%@ page import="OOSE.Model.*" %>
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
    <link href="../../css/workplace.css" rel="stylesheet" type="text/css">
    <title>사업장 관리</title>

    <script language="javascript">
        let modi = "${pageContext.request.contextPath}/view/workplace/";
        let url = "${pageContext.request.contextPath}/view/workplace/";
        let deleteU = "${pageContext.request.contextPath}/view/workplace/";

        let Info = "${pageContext.request.contextPath}/view/workPlaceInfo/";

        function register() {
            window.open(url + "RegisterWorkplace.jsp", "register", "width=500, height=400, left=200, top=100");
        }
        function modify() {
            var check = document.getElementsByName("workplaceId");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    modi = "${pageContext.request.contextPath}/view/workplace/ModifyWorkplace.jsp?workplaceId=" + encodeURI(check[i].value);
                }
            }
            window.open(modi, "modify", "width=500, height=400, left=200, top=100, resizable = no");
        }
        function deleteW() {
            var check = document.getElementsByName("workplaceId");
            for (var i = 0; i < check.length; i++) {
                if (check[i].checked) {
                    deleteU = "${pageContext.request.contextPath}/view/workplace/DeleteWorkplace.jsp?workplaceId=" + encodeURI(check[i].value);
                }
            }
            window.open(deleteU, "deleteW", "width=500, height=400, left=200, top=100, resizable = no");
        }

        // 이 부분을 건드리시면 될거 같아요!
        function workplaceInfo() {
            var check = document.getElementsByName("radio");
            for(var i =0 ; i<check.length; i++){
                if (check[i].checked){
                    Info = "${pageContext.request.contextPath}/view/workPlaceInfo/BrowseWorkplaceInfo.jsp?workplaceId=" + encodeURI(check[i].value);
                }
            }
            window.open(Info, "workplaceInfo", "width=500, height=400, left=200, top=100, resizable = no");
        }
        function browseOpen(){
            var formDatas = window.document.forms[0];
            const leftPosition = (window.screen.width-500)/2;
            const topPosition = (window.screen.height-500)/2;
            const popOption = "width=500, height=500, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
            window.open("","browsePop",popOption);

            formDatas.target = "browsePop";
            formDatas.action = "/workplace/browseWorkplaceInfo"
            formDatas.submit();
        }
    </script>
</head>
<body>
<%@include file="../Default/Header.jsp"%>

<!-- 절  취  선 -->

<div class="sub-body">
<%--    <div>--%>
<%--        사업장 조회--%>
<%--    </div>--%>
    <div class="side-menu">
        <ul>
            <li><a href="#">사업장 관리</a></li>
        </ul>
    </div>
    <form>
        <div class="table">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>선택</th>
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
        <div class = "button-frame">
        <input type="button" value="상세정보" onclick=browseOpen()>
        <input type="button" value="등록" onclick="register();"/>
        <input type="button" value="수정" onclick="modify();"/>
        <input type="button" value="삭제" onclick="deleteW();"/>
        </div>
    </form>
    <form action="/browseWorkplaceManagement" method="POST">
        <div class = "button-frame">
        <input type="submit" value="조회">
        </div>
    </form>
</div>
</body>
</html>
