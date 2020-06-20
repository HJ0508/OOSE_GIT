<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-05
  Time: 오전 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../css/registerProduct.css" rel="stylesheet" type="text/css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>상품 패키지 등록</title>
</head>

<body>
<div class="register-head">
    <h2>상품 등록</h2>
</div>
<div class="register-body">
    <form action="registerProduct" method="post">
        <br><br><br>
        <label> 상품 명 <input name="name" type="text"></label> <br><br>
        <label> 가격 <input name="price" type="text"></label> <br><br>
        <label> 상품 상태
            <select name="state">
                <option>On Sale</option>
                <option>Sold Out</option>
                <option>Preparing</option>
            </select>
        </label> <br><br>
        <label> 재고 <input name="stock" type="text"></label> <br><br>
        <label> 비고 <input name="note" type="text"></label>
        <div class="register-tail">
            <input type="button" class="cancel-button" name="cancel" value="취소">
            <input type="submit" class="sumbit-button" name="register" value="확인">
        </div>
    </form>
</div>

</body>

<script !src="">

    <%
    Object temp = request.getAttribute("result");
    if(temp != null)
        {
            int result = (Integer)temp;
            if(result == 1){
               %>
    window.onload = alert("등록이 완료되었습니다.");
    <%
            }else if(result == 0){
                %>
    window.onload = alert("등록에 실패하셨습니다.");
    <%
            }else if(result == 2){
                %>
    window.onload = alert("누락된 정보가 존재합니다.");
    <%
            }else if(result == 3){
                            %>
    window.onload = alert("이미 등록된 상품입니다.");
    <%
            }
        }
    %>

</script>

</html>
