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

@WebServlet("/facilitycontrol")
public class FacilityController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

//    boolean facilityRegister(String s) {
//        dbManager.registerFacilityInfo(s);
//        return false;
//    }
//
//    boolean facilityModify(String s) {
//        dbManager.modifyFacilityInfo(s);
//        return false;
//    }
//
//    boolean facilityDelete(String s) {
//        dbManager.deleteFacilityInfo(s);
//        return false;
//    }
//
//    String[] facilityBrowse() {
//        return dbManager.browseFacilityInfo();
//    }
//
//    void identifyReqView(String s, int n) {
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String[] result;
            result = dbManager.browseFacilityInfo();
            req.setAttribute("result", result);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/facility/FacilityManagement.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
