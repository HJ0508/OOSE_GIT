<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2020-06-06
  Time: 오후 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/deleteProduct.css" rel="stylesheet" type="text/css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>상품패키지 삭제</title>
</head>
<body>
<div class="delete-head">
    <h2>상품패키지 삭제</h2>
</div>
<form action = "deleteProduct" onsubmit="showPopup()">
    <div class="delete-body">
        <label>
            <select name = "name">
                <c:forEach var="pp" items="${productList}">
                    <option>
                            ${pp.name}
                    </option>
                </c:forEach>
            </select>
        </label>
    </div>
    <div class="delete-bottom">
        <input type="submit" value = "삭제">
    </div>
</form>
</body>

<script>
    function showPopup(){
        return confirm("정말로 삭제하시겠습니까?");
    }
</script>
</html>
