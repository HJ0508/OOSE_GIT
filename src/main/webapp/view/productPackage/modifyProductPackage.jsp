<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-06
  Time: 오후 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/modifyProduct.css" rel="stylesheet" type="text/css">
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
    <form action="modifyProduct" method="post">
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

</html>
