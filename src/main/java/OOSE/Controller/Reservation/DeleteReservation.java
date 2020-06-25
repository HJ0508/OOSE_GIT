package OOSE.Controller.Reservation;

import OOSE.Database.ReservationDBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;
    HtmlUtil util;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkAuthority(req);
            if(reservationDBManager.deleteReservation(req.getParameter("id"), req.getParameter("reservation")))
                util.htmlPrint(resp, "삭제 완료");
            else
                util.htmlPrint(resp, "삭제 실패");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DeleteReservation() {
        this.reservationDBManager = new ReservationDBManager();
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
