package OOSE.controller.FacilityManagement;

import OOSE.db.FacilityDBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerFacilityInformation")
public class RegisterFacilityInformationController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //값가지고오기
        String name = req.getParameter("name");
        String workspaceId = req.getParameter("workspaceId");
        String facilityState = req.getParameter("facilityState");
        String fee = req.getParameter("fee");
        String openTime = req.getParameter("openTime");
        String closeTime = req.getParameter("closeTime");
        String manager = req.getParameter("manager");
        String capacity = req.getParameter("capacity");
        //처음 콤보박스에 값가져오기
        boolean check = dbManager.registerFacilityInforInfo(name, workspaceId, facilityState, fee, openTime, closeTime, manager, capacity);
        if(check) {
            req.setAttribute("check", check);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/facility/FacilityInformationRegister.jsp");
            dispatcher.forward(req, resp);
        }else {//실패
            req.setAttribute("check", check);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/facility/FacilityInformationRegister.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
