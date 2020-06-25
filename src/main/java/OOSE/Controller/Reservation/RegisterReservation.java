package OOSE.Controller.Reservation;

import OOSE.Database.AccommodationInfoDBManager;
import OOSE.Database.ReservationDBManager;
import OOSE.Model.Accommodation;
import OOSE.Model.Reservation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;
    AccommodationInfoDBManager accommodationInfoDBManager;
    HtmlUtil util;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Accommodation[] accommodations = accommodationInfoDBManager.browseAccommodationInfo();
            Accommodation[] roomInfos = accommodationInfoDBManager.browseRoomInfo();
            req.setAttribute("accommodations", accommodations);
            req.setAttribute("roomInfos", roomInfos);
            RequestDispatcher dispatcher = null;
            if(req.getParameter("condition").equals("예약"))
                dispatcher = req.getRequestDispatcher("/view/reservation/RegisterReservation.jsp");
            else
                dispatcher = req.getRequestDispatcher("/view/reservation/RegisterReservationForCancel.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            checkAuthority(request);
            System.out.println(request.getParameter("accommodation"));
            Reservation reservation = new Reservation(0, Integer.parseInt(request.getParameter("accommodation")),
                    Integer.parseInt(request.getParameter("roomNumber")), request.getParameter("name"), request.getParameter("tel"), request.getParameter("carNumber"),
                    request.getParameter("checkIn"), request.getParameter("checkOut"), 0, request.getParameter("condition"), Integer.parseInt(request.getParameter("headCount")));
            if(reservationDBManager.checkDuplicatedInfo(reservation))
                util.closeOnException(response, "중복된 예약정보 내역이 존재합니다.");
            else {
                boolean result = reservationDBManager.registerReservation(reservation);

                request.setAttribute("result", result);
                if (result) {
                    util.htmlPrint(response, "저장 완료");
                    response.getWriter().print("<script>self.close()</script>");
                } else
                    util.htmlPrint(response, "저장 실패");
            }
            /* -----Exception----- */
        } catch (NumberFormatException e){ util.closeOnException(response, "입력 형식이 잘못되었습니다."); e.printStackTrace();}
        catch (SQLException e) { util.closeOnException(response, ""); e.printStackTrace();}
        catch (ExceptionOnAuthority e) { util.closeOnException(response, "권한이 없습니다."); e.printStackTrace(); }

    }

    public RegisterReservation() {
        this.reservationDBManager = new ReservationDBManager();
        this.accommodationInfoDBManager = new AccommodationInfoDBManager();
        util = new HtmlUtil();
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnAuthority{
        try {
            HttpSession httpSession = req.getSession();
            int userAuthority = (int)httpSession.getAttribute("authority");
            if(!reservationDBManager.checkAuthority(userAuthority))
                throw new ExceptionOnAuthority("권한 없음");
        } catch(SQLException e) {
            throw new ExceptionOnAuthority("해당 기능에 대한 권한명이 없음");
        }
    }
}


