<%--
  Created by IntelliJ IDEA.
  User: 김해준
  Date: 2020-06-01
  Time: 오후 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String id = (String)session.getAttribute("id") ; //세션에 저장된 id, 권한정보 받아오기
    int authority = (Integer)session.getAttribute("authority");
%>
<body>
    <div class="main header" id="header">
        <div class="header-blank">
            <ul class="user-bar">
                <li><a href="#"><strong><%= id%> 님 환영합니다. 권한: <%=authority%></strong></a></li>
            </ul>
        </div>
        <div class="navbar">
            <div class="container">
                <h1 class="navbar-brand">
                    <a href="#">
                        <img src="../../Image/pngguru.com.png" alt>
                        <strong>소공도 관광지</strong>
                        <div>통합관리시스템</div>
                    </a>
                </h1>
                <div id="top-menu">
                    <ul class="navbar-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}/view/MemberView/memberMenuView.jsp">회원</a>
                        </li>
                        <li>
                            <a href="#">권한</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/workPlaceInfo/workplaceInfoBrowse.jsp">사업장</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/facility/FacilityManagement.jsp">시설</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/reservation/reservationBrowse.jsp">예약</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/productPackage/browseProductPackage.jsp">판매상품</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/accomodationPayment/accomodationPaymentBrowse.jsp">결제</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="sub-top">
        <div class="sub-visual-wrapper">
            <img src="../../Image/sightseeing.jpg">
        </div>
    </div>
</body>

