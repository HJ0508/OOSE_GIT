package OOSE.controller.WorkplaceManagement;

import OOSE.db.*;
import OOSE.model.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/browseWorkplaceManagement")
public class WorkplaceBrowseController extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Workplace> workplace;
            workplace = dbManager.browseWorkplace();
            req.setAttribute("workplace", workplace);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/workplace/WorkplaceManagement.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
