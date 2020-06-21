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

public class RegisterReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;
    HtmlUtil util;

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
        util = new HtmlUtil();
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnAuthority{
        HttpSession httpSession = req.getSession();
        int authority = (int)httpSession.getAttribute("authority");
        if(authority<2) throw new ExceptionOnAuthority("권한 없음");
    }
}


