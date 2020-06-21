package OOSE.controller.reservation;

import OOSE.db.ReservationDBManager;
import OOSE.model.Reservation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ModifyReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;
    HtmlUtil util;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkAuthority(req);
            Reservation[] reservations = reservationDBManager.browseReservation(req.getParameter("reservation"), 3,req.getParameter("condition"));
            req.setAttribute("reservations", reservations[0]);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/reservation/modifyReservationPopup.jsp");
            dispatcher.forward(req, resp);
        } catch (ExceptionOnAuthority e) { util.closeOnException(resp, "권한이 없습니다."); e.printStackTrace(); }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("->"+req.getParameter("reservationId"));
            Reservation reservation = new Reservation(Integer.parseInt(req.getParameter("reservationId")), Integer.parseInt(req.getParameter("accommodation")),
                    Integer.parseInt(req.getParameter("roomNumber")), req.getParameter("name"), req.getParameter("tel"), req.getParameter("carNumber"),
                    req.getParameter("checkIn"), req.getParameter("checkOut"), 0, null, Integer.parseInt(req.getParameter("headCount")));

            if(reservationDBManager.checkDuplicatedInfo(reservation))
                util.closeOnException(resp, "중복된 예약정보 내역이 존재합니다.");

            boolean result = reservationDBManager.modifyReservation(reservation);
            if(result)
                util.closeOnException(resp,"수정 완료");
            else
                util.htmlPrint(resp,"수정 실패");

            /* -----Exception----- */
        } catch (NumberFormatException e){ util.closeOnException(resp, "입력 형식이 잘못되었습니다."); }
        catch (SQLException e) { util.closeOnException(resp, ""); }

    }

    public ModifyReservation() {
        reservationDBManager = new ReservationDBManager();
        util = new HtmlUtil();
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnAuthority{
        HttpSession httpSession = req.getSession();
        int authority = (int)httpSession.getAttribute("authority");
        if(authority<2) throw new ExceptionOnAuthority("권한 없음");
    }
}
