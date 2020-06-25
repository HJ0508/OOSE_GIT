package OOSE.Controller.WorkplaceManagement;

import OOSE.Database.*;
import OOSE.Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class WorkplaceController extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("123");
            ArrayList<Workplace> workplace;
            workplace = dbManager.browseWorkplace();
            req.setAttribute("workplace", workplace);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workplace/ManagementWorkplace.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
