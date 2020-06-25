<%--
  Created by IntelliJ IDEA.
  User: jaehe
  Date: 2020-06-03
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="OOSE.Model.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 정보 조회</title>
    <link href="${pageContext.request.contextPath}/css/memberControl.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="MemberMenuView.jsp"%>
<div class="contentDiv">
    <div style="font-size:20px;left:0;">
        회원 정보
        <div>
            <form class="buttonForm" method="post" action="/reqBrowseMember">
                <input id="submitBtn" type="submit"value="조회">
            </form>
        </div>
    </div>
    <div>
        <div>
            <table id="browseTable">
                <thead>
                <tr>
                    <th>회원 이름</th>
                    <th>ID</th>
                    <th>Password</th>
                    <th>권한 레벨</th>
                    <th>전화번호</th>
                    <th>선택</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if(request.getAttribute("memberList")!=null)        //null이 아닐때만 실행
                    {
                        ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("memberList");
                        for(Member member : list)
                        {
                            pageContext.setAttribute("member", member);
                %>
                <tr class="memberList">
                    <td name="name">${member.name}</td>
                    <td name="id">${member.id}</td>
                    <td name="password">${member.password}</td>
                    <td name="authority">${member.authority}</td>
                    <td name="phoneNum">${member.phoneNum}</td>
                    <td><input type="radio" name="selected"></td>
                </tr>
                <%
                        }
                    } //if문의 끝
                %>
                </tbody>
            </table>
        </div>
    </div>
    <div class="modify_delete_div">
        <a id="modify" class="aLink" href="#" onclick="parsingMember()">수정</a>
        <a id ="delete" class="aLink" href="#" onclick="deleteConfirm()">삭제</a>
    </div>
</div>


<script>
    var radio =document.getElementsByName("selected");
    var radioSelectedRow;   //라디오 버튼이 출력된 행 번호 저장
    function checkTableRow()        //라이도 버튼이 클릭된 행을 찾는 함수
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

    function parsingMember()        //수정 버튼을 누르면 라디오버튼이 체크된 행의 값을 파라미터로 수정 페이지에 전달한다 (a태그의 href 속성을 바꿔서 보냄)
    {
        checkTableRow();
        document.getElementById("modify").setAttribute("href", "/view/MemberView/ModifyMemberView.jsp?name=" + encodeURI(document.getElementsByName("name")[radioSelectedRow].innerHTML)+
            "&id=" + encodeURI(document.getElementsByName("id")[radioSelectedRow].innerHTML)+"&password=" +encodeURI(document.getElementsByName("password")[radioSelectedRow].innerHTML) +
            "&authority=" + encodeURI(document.getElementsByName("authority")[radioSelectedRow].innerHTML) + "&phoneNum=" + encodeURI(document.getElementsByName("phoneNum")[radioSelectedRow].innerHTML));
    }
    function deleteConfirm()
    {
        var clicked=confirm("정말 삭제하시겠습니까?")
        if(clicked==true)
        {
            checkTableRow();
            document.getElementById("delete").setAttribute("href", "/view/MemberView/reqDeleteMember?id=" + document.getElementsByName("id")[radioSelectedRow].innerHTML);       //서버에 삭제 요청
        }
    }
</script>
</body>
</html>
