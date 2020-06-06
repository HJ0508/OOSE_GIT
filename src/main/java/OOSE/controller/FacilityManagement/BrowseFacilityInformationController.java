package OOSE.controller.FacilityManagement;

import OOSE.Model.Facility;
import OOSE.db.FacilityDBManager;
import OOSE.db.FacilityInformationDBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/browseFacilityInformationManagement")
public class BrowseFacilityInformationController extends HttpServlet {
    FacilityInformationDBManager dbManager = new FacilityInformationDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //고쳐
            ArrayList<Facility> facility;
            facility = dbManager.browseFacilityInforInfo();
            req.setAttribute("facility", facility);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/facility/FacilityInformationManagement.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
