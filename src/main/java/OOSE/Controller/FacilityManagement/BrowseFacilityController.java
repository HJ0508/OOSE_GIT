package OOSE.Controller.FacilityManagement;

import OOSE.Database.*;
import OOSE.Model.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/browseFacilityManagement")
public class BrowseFacilityController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Facility> facility;
            facility = dbManager.browseFacilityInfo();
            req.setAttribute("facility", facility);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/facility/ManagementFacility.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
