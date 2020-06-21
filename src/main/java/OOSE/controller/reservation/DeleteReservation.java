package OOSE.controller.reservation;

import OOSE.db.ReservationDBManager;
import com.sun.deploy.security.SelectableSecurityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
        HttpSession httpSession = req.getSession();
        int authority = (int)httpSession.getAttribute("authority");
        if(authority<2) throw new ExceptionOnAuthority("권한 없음");
    }
}
