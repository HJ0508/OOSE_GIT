<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-06-02
  Time: 오후 5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
    <div class="sub-nav-wrapper">
        <ul class="sub-nav-list">
            <li class="title"><span>예약 관리</span></li>
            <li>
                <a title="예약 정보 조회" href="${pageContext.request.contextPath}/view/reservation/reservationBrowse.jsp">예약 정보 조회</a>
            </li>
            <li>
                <a title="예약 취소정보 조회" href="${pageContext.request.contextPath}/view/reservation/reservationCancelBrowse.jsp">예약 취소정보 조회</a>
            </li>
        </ul>
    </div>
</body>

