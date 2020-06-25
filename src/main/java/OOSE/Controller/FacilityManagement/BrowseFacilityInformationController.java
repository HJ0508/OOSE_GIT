package OOSE.Controller.FacilityManagement;

import OOSE.Database.FacilityDBManager;
import OOSE.Model.Facility;

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
    FacilityDBManager dbManager = new FacilityDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Facility> facility;
            facility = dbManager.browseFacilityInforInfo();
            req.setAttribute("facility", facility);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/facility/ManagementFacilityInformation.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
