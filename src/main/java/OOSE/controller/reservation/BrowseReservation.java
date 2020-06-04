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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowseReservation extends HttpServlet {
    ReservationDBManager reservationDBManager;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        String keyword = req.getParameter("keyword");
        String category = req.getParameter("option-category");
        int tmp=0;
        System.out.println("ㅎㅇ");
        switch (category){
            case "회원명":
                tmp=1;
                break;
            case "시설명":
                tmp=2;
                break;
        }
        try {
            Reservation[] data = reservationDBManager.browseReservation(keyword, tmp);
            List<Reservation> list = new ArrayList<>(Arrays.asList(data));
            req.setAttribute("list", list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/reservation/reservationBrowse.jsp");
            dispatcher.forward(req,resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    public BrowseReservation() {
        this.reservationDBManager = new ReservationDBManager();
    }
}
