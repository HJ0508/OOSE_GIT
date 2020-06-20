package OOSE.controller.FacilityManagement;

import OOSE.db.*;
import sun.misc.Request;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class FacilityController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("123");
            ArrayList<String> facility;
            facility = dbManager.browseFacilityInfo();
            req.setAttribute("facility", facility);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/facility/FacilityManagement.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
