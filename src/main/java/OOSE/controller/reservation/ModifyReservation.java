package OOSE.controller.reservation;

import OOSE.db.ReservationDBManager;
import OOSE.model.Reservation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ModifyReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Reservation[] reservations = reservationDBManager.browseReservation(req.getParameter("reservation"), 3);
            req.setAttribute("reservations", reservations[0]);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/reservation/modifyReservationPopup.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("->"+req.getParameter("reservationId"));
            Reservation reservation = new Reservation(Integer.parseInt(req.getParameter("reservationId")), Integer.parseInt(req.getParameter("accommodation")),
                    Integer.parseInt(req.getParameter("roomNumber")), req.getParameter("name"), req.getParameter("tel"), req.getParameter("carNumber"),
                    req.getParameter("checkIn"), req.getParameter("checkOut"), 0, "예약", Integer.parseInt(req.getParameter("headCount")));
            boolean result = reservationDBManager.modifyReservation(reservation);
            if(result)
                htmlPrint(resp,"수정 완료");
            else
                htmlPrint(resp,"수정 실패");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void htmlPrint(HttpServletResponse res, String message)
            throws IOException {
        res.setContentType("text/html; charset=euc-kr");
        PrintWriter out = res.getWriter();
        out.println("<script>");
        out.println("alert('" + message + "');");
        out.println("history.back(-1);");
        out.println("</script>");
    }
    public ModifyReservation() { reservationDBManager = new ReservationDBManager();
    }
}
