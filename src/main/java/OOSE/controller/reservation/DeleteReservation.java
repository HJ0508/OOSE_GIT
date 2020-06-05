package OOSE.controller.reservation;

import OOSE.db.ReservationDBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    public DeleteReservation() {
            this.reservationDBManager = new ReservationDBManager();
    }
}
