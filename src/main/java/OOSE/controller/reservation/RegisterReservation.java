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

public class RegisterReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("accommodation"));
        Reservation reservation = new Reservation(0, Integer.parseInt(request.getParameter("accommodation")),
                Integer.parseInt(request.getParameter("roomNumber")), request.getParameter("name"), request.getParameter("tel"), request.getParameter("carNumber"),
                request.getParameter("checkIn"), request.getParameter("checkOut"), 0 , request.getParameter("condition"), Integer.parseInt(request.getParameter("headCount")));
        boolean result = reservationDBManager.registerReservation(reservation);
        request.setAttribute("result", result);
        if(result) {
           htmlPrint(response, "저장 완료");
           response.getWriter().print("<script>self.close()</script>");
        }
        else
            htmlPrint(response, "저장 실패");
    }

    public RegisterReservation() {
        this.reservationDBManager = new ReservationDBManager();
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
}
