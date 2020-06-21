package OOSE.controller.FacilityManagement;


import OOSE.model.Facility;
import OOSE.db.FacilityDBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/modifyFacilityManagement")
public class ModifyFacilityController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String oldName = req.getParameter("oldName");
            boolean check = dbManager.modifyFacilityInfo(oldName, name);
            if(check) {
                req.setAttribute("check", check);
                resp.sendRedirect("view/facility/FacilityModify.jsp");
            }else {//실패
                req.setAttribute("check", check);
                resp.sendRedirect("view/facility/FacilityModify.jsp");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
