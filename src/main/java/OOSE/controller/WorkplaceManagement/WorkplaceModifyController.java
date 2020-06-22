package OOSE.controller.WorkplaceManagement;

import OOSE.model.*;
import OOSE.db.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/modifyWorkplaceManagement")
public class WorkplaceModifyController extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();

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
            boolean check = dbManager.modifyWorkplace(oldName, name);
            if(check) {
                req.setAttribute("check", check);
                resp.sendRedirect("view/workplace/workplaceModify.jsp");
            }else {//실패
                req.setAttribute("check", check);
                resp.sendRedirect("view/workplace/workplaceModify.jsp");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
