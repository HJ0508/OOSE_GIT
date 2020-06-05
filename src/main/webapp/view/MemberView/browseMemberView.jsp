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
<%@include file="memberMenuView.jsp"%>
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
                        <td><input type="radio" name="selected"></td>     <%-- radio버튼 왜 안나옴????--%>
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
            <a class="aLink" href="#">삭제</a>
        </div>
    </div>

<script>
    function parsingMember()        //수정 버튼을 누르면 라디오버튼이 체크된 행의 값을 파라미터로 수정 페이지에 전달한다 (a태그의 href 속성을 바꿔서 보냄)
    {
        var radio = document.getElementsByName("selected");
        for(var i=0;i<radio.length;i++)
        {
            if(radio[i].checked)
            {
                var table = document.getElementsByTagName("table");
                //var td = table.rows[i];

                document.getElementById("modify").setAttribute("href", "/view/MemberView/modifyMemberView.jsp?name=" + document.getElementsByName("name")[i].innerHTML+
                    "&id=" + document.getElementsByName("id")[i].innerHTML+"&password=" +document.getElementsByName("password").innerHTML +
                    "&authority=" + document.getElementsByName("authority").innerHTML + "&phoneNum=" + document.getElementsByName("phoneNum")[i].innerHTML);
                break;      //전송도 했겠다 빠져나가자
            }
        }
    }
</script>
</body>
</html>
