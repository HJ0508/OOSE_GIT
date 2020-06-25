<%--
  Created by IntelliJ IDEA.
  User: haejun
  Date: 2020-06-25
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core%" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.modify').on('click', function() {
                var currentRow = $(this).closest('tr');
                var reservationId = currentRow.find('td:eq(0)').text();
                const popUrl = "${pageContext.request.contextPath}/reservation/modifyReservation?reservation="+reservationId+"&condition=취소";	//팝업창에 출력될 페이지 URL
                const leftPosition = (window.screen.width-500)/2;
                const topPosition = (window.screen.height-400)/2;
                const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
                window.open(popUrl,"",popOption);
            });
            $('.register').on('click', function () {
                const popUrl = "${pageContext.request.contextPath}/reservation/registerReservation?condition=취소";
                const leftPosition = (window.screen.width-500)/2;
                const topPosition = (window.screen.height-400)/2;
                const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
                window.open(popUrl,"",popOption);
            });
        })
    </script>
    <title>소공도 관광지</title>
</head>
<body>
<%@ include file="../default/header.jsp"%>
<div class = "contents-container">
    <!-- 왼쪽 메뉴바 -->
    <%@ include file="reservationNavigationBar.jsp"%>
    <!-- 내용 -->
    <div class="contents">
        <div class="title"><strong>예약 취소정보 관리</strong><br><br></div>
        <div class="contents-option">
            <button class="register">등록</button>
            <button id = "deleteButton" onclick = deleteReservationInfo()>삭제</button>
            <form method="POST">
                <select name="option-category", id="selectBox">
                    <option value="">선택</option>
                    <option value="회원명">회원명</option>
                    <option value="시설명">시설명</option>
                </select>
                <input name="keyword" type="text" name="search_keyword">
                <input type="submit" name = "search" value="검색" formaction="/reservation/browseReservation">
                <input name="condition" value="취소" style="visibility: hidden">
            </form>
        </div>
        <br><br>
        <div class="contents-table">
            <table>
                <thead>
                <tr>
                    <th>예약번호</th>
                    <th>예약자</th>
                    <th>시설명</th>
                    <th>호실</th>
                    <th>예약날짜</th>
                    <th>연락처</th>
                    <th>차량번호</th>
                    <th>상태</th>
                    <th>수정</th>
                    <th>선택</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var = "reservation">
                    <tr>
                        <td name = "reservation">${reservation.reservation}</td>
                        <td name = "userId">${reservation.userId}</td>
                        <td name = "accommodationId">${reservation.accommodationId}</td>
                        <td name = "roomNumber">${reservation.roomNumber}</td>
                        <td name = "checkInDate">${reservation.checkInDate}</td>
                        <td name = "phoneNum">${reservation.phoneNum}</td>
                        <td name = "carNumber">${reservation.carNumber}</td>
                        <td name = "reservationCode">${reservaiton.reservationCode}</td>
                        <td><input class="modify" type="button" value="수정"></td>
                        <td><input name="selected" type="checkbox"></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script>
    function registerOpen(){
        const popUrl = "${pageContext.request.contextPath}/view/reservation/registerReservationCancelPopup.jsp";	//팝업창에 출력될 페이지 URL
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open(popUrl,"",popOption);
    }

    function modifyOpen(){
        const popUrl = "${pageContext.request.contextPath}/reservation/modifyReservation";	//팝업창에 출력될 페이지 URL
        const leftPosition = (window.screen.width-500)/2;
        const topPosition = (window.screen.height-400)/2;
        const popOption = "width=500, height=400, top="+topPosition+", left="+leftPosition+", resizable=no, scrollbars=no, status=no, menubar=no, toolbar=no, location=no;";    //팝업창 옵션(optoin)
        window.open(popUrl,"",popOption);
    }

    function deleteReservationInfo() {
        const isDeleted = confirm("정말로 삭제하시겠습니까?");
        if (isDeleted) {
            const selectedItem = document.getElementsByName("selected");
            var param = "?reservation=예약&id=";
            for (var i = 0; i < selectedItem.length; i++) {
                if (selectedItem[i].checked) {
                    param += document.getElementsByName("reservation")[i].innerHTML + ";";
                }
            }
            location.href="/reservation/deleteReservation"+param;
        } else
            alert("취소되었습니다.");
    }



</script>

</body>
</html>

