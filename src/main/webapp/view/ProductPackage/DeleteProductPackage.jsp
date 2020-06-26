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
    <link href="../../css/deleteProduct.css" rel="stylesheet" type="text/css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>상품패키지 삭제</title>
</head>
<body>
<div class="delete-head">
    <h2>상품패키지 삭제</h2>
</div>
<form action="DeleteProduct" onsubmit="showPopup()">
    <div class="delete-body">
        <label>
            <select name="name">
                <c:forEach var="pp" items="${productList}">
                    <option>
                            ${pp.name}
                    </option>
                </c:forEach>
            </select>
        </label>
    </div>
    <div class="delete-bottom">
        <input type="submit" value="삭제">
    </div>
</form>
</body>

<script>
    function showPopup() {
        return confirm("정말로 삭제하시겠습니까?");
    }

    <%
        Object temp = request.getAttribute("result");

        if(temp != null){
        int result = (Integer)temp;
            if(result == 1){
    %>
    window.onload = alert("삭제가 완료되었습니다.");
    opener.location.reload();
    <%
            }else if(result == 2){
    %>
    window.onload = alert("이미 판매 집계된 상품이므로 삭제가 불가능합니다.");

    <%
            }else if(result == 3){
    %>
    window.onload = alert("삭제를 실패하셨습니다.");
    <%
            }else if(result == 4){
                %>
    window.onload = alert("상품 조회 중 오류가 발생했습니다.");
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
