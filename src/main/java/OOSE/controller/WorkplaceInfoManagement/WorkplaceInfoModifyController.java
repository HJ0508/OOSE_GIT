package OOSE.controller.WorkplaceInfoManagement;

import OOSE.db.WorkplaceDBManager;
import OOSE.model.Workplace;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/workplace/modifyWorkplaceInfo")
public class WorkplaceInfoModifyController extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");

            int workplaceId = Integer.parseInt(req.getParameter("workplaceId"));
            String workplaceName = req.getParameter("workplaceName");
            String manager = req.getParameter("manager");
            String address = req.getParameter("address");
            String phoneNumber = req.getParameter("phoneNumber");
            String status = req.getParameter("workplaceStatus");
            int fee = Integer.parseInt(req.getParameter("fee"));
            String openTime = req.getParameter("openingTime");
            String closeTime = req.getParameter("closingTime");
            String sqare = req.getParameter("sqareMeasure");
            String otherInfo = req.getParameter("otherInfo");

            dbManager.updateWorkplaceInfo(workplaceId, workplaceName, manager, address, phoneNumber, status, fee, openTime, closeTime, sqare, otherInfo);








            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/workplaceInfoModify.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}