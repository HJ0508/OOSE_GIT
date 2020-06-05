package OOSE.controller.FacilityManagement;


import OOSE.Model.Facility;
import OOSE.db.FacilityDBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/registerFacilityManagement")
public class RegisterFacilityController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            System.out.println("123");
            boolean check = dbManager.registerFacilityInfo(name);
            System.out.println("234");
            if(check) {
                req.setAttribute("check", check);
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/facility/FacilityManagement.jsp");
                System.out.println("345");
                dispatcher.forward(req, resp);
            }else {//실패
                req.setAttribute("check", check);
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/facility/FacilityManagement.jsp");
                dispatcher.forward(req, resp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
