<%--
  Created by IntelliJ IDEA.
  User: jaehe
  Date: 2020-06-21
  Time: 오후 5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="OOSE.Model.Authority" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>권한 정보 조회</title>
    <link href="${pageContext.request.contextPath}/css/authority.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="../Default/Header.jsp"%>
<div class="contentDiv">
    <table id="browseTable">
        <thead>
        <tr>
            <th>권한 ID</th>
            <th>권한 이름</th>
            <th>접근 범위</th>
            <th>선택</th>
        </tr>
        </thead>
        <tbody>
        <%
            if(request.getAttribute("authorityList")!=null)        //null이 아닐때만 실행
            {
                ArrayList<Authority> list = (ArrayList<Authority>)request.getAttribute("authorityList");
                for(Authority au : list)
                {
                    pageContext.setAttribute("authority",au);
        %>
        <tr>
            <td name="id">${authority.id}</td>
            <td name="name">${authority.name}</td>
            <td name="accessRange" style="width:300px;">${authority.accessRange}</td>
            <td><input type="radio" name="selected"></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <div class="modify_delete_div">
        <a id = "register" class="aLink" href="#" onclick="registerOpen()">등록</a>
        <a id="modify" class="aLink" href="#" onclick="modifyOpen()">수정</a>
        <a id ="delete" class="aLink" href="#" onclick="deleteConfirm()">삭제</a>
    </div>
</div>
<script>
    var radio =document.getElementsByName("selected");
    var radioSelectedRow;   //라디오 버튼이 출력된 행 번호 저장
    function checkTableRow()        //라디오 버튼이 클릭된 행을 찾는 함수
    {
        var radio = document.getElementsByName("selected");
        for(var i=0;i<radio.length;i++)
        {
            if(radio[i].checked)
            {
                radioSelectedRow=i;
            }
        }
    }
    function deleteConfirm()
    {
        var clicked=confirm("정말 삭제하시겠습니까?");
        if(clicked==true)
        {
            checkTableRow();
            document.getElementById("delete").setAttribute("href", "/reqDeleteAuthority?id=" + document.getElementsByName("id")[radioSelectedRow].innerHTML);       //서버에 삭제 요청
        }
    }
    function registerOpen(){
        const popUrl = "${pageContext.request.contextPath}/view/authority/RegisterAuthority.jsp";	//팝업창에 출력될 페이지 URL
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open(popUrl,"",popOption);
    }
    function modifyOpen() {
        checkTableRow();
        const popUrl = "${pageContext.request.contextPath}/authority/modifyAuthority?id="+document.getElementsByName("id")[radioSelectedRow].innerHTML;	//팝업창에 출력될 페이지 URL
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open(popUrl,"",popOption);
    }

    function refresh() {
        location.reload(true);
        location.href = location.href;
        history.go(0);
    }
</script>
</body>
</html>
