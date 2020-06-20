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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowseReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;
    HtmlUtil util;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        try {

            checkAuthority(req);
            String keyword = req.getParameter("keyword");
            String category = req.getParameter("option-category");
            String reservationCode = req.getParameter("condition");
            int tmp=0;
            switch (category){
                case "회원명":
                    tmp=1;
                    break;
                case "시설명":
                    tmp=2;
                    break;
            }
            List<Reservation> list = new ArrayList(Arrays.asList(reservationDBManager.browseReservation(keyword, tmp, reservationCode)));
            req.setAttribute("list", list);
            if(reservationCode.equals("예약")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/reservation/reservationBrowse.jsp");
                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/reservation/reservationCancelBrowse.jsp");
                dispatcher.forward(req, resp);
            }

        } catch (ExceptionOnAuthority e) { util.closeOnException(resp, "권한이 없습니다."); e.printStackTrace(); }
        catch (SQLException e) {
            util.htmlPrint(resp, "부합하는 정보가 없습니다.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    public BrowseReservation() {
        this.reservationDBManager = new ReservationDBManager();
        util = new HtmlUtil();
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnAuthority{
        HttpSession httpSession = req.getSession();
        int authority = (int)httpSession.getAttribute("authority");
        if(authority<2) throw new ExceptionOnAuthority("권한 없음");
    }

}
