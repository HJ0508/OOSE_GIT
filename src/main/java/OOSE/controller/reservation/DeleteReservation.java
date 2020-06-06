package OOSE.controller.reservation;

import OOSE.db.ReservationDBManager;
import com.sun.deploy.security.SelectableSecurityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if(reservationDBManager.deleteReservation(req.getParameter("id")))
                htmlPrint(resp, "삭제 완료");
            else
                htmlPrint(resp, "삭제 실패");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public DeleteReservation() {
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
