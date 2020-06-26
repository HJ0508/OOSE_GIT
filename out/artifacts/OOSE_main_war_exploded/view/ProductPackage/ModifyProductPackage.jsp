<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-06
  Time: 오후 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../css/modifyProduct.css" rel="stylesheet" type="text/css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>상품 패키지 수정</title>
</head>
<body>
<div class="register-head">
    <h2>상품 수정</h2>
</div>
<div class="register-body">
    <form action="ModifyProduct" method="post">
        <br><br><br>

        <label> 상품 명
            <select name="name">
                <c:forEach var="pp" items="${productList}">
                    <option>
                            ${pp.name}
                    </option>
                </c:forEach>
            </select>
        </label>
        <br><br>
        <label> 가격 <input name="price" type="text"></label> <br><br>
        <label> 상품 상태
            <select name="state">
                <option>판매 중</option>
                <option>판매 완료</option>
                <option>준비 중</option>
            </select>
        </label> <br><br>
        <label> 재고 <input name="stock" type="text"></label> <br><br>
        <label> 비고 <input name="note" type="text"></label>
        <div class="register-tail">
            <input type="reset" class="cancel-button" name="cancel" value="취소">
            <input type="submit" class="sumbit-button" name="register" value="확인">
        </div>
    </form>
</div>

</body>

<script>
    <%
Object temp = request.getAttribute("result");
if(temp != null)
    {
        int result = (Integer)temp;
        if(result == 1){
%>
    window.onload = alert("수정이 완료되었습니다.");
    opener.location.reload();
    <%
            }else if(result == 0){
                %>
    window.onload = alert("수정 중 오류가 발생했습니다.");
    <%
            }else if(result == 2){
                %>
    window.onload = alert("누락된 정보가 존재합니다.");
    <%
            }else if(result == 3){
                            %>
    window.onload = alert("수정에 실패하셨습니다.");
    <%
            }else if(result == 4){
            %>
    window.onload = alert("상품 조회 중 오류가 발생했습니다.");
    <%
            }else if(result == 5){
            %>
    window.onload = alert("입력 형식이 잘못되었습니다.");
    <%
            }else if(result == 6){
            %>
    window.onload = alert("권한이 없습니다.");
        window.close();
    <%
            }
        }
    %>
</script>

</html>
