package OOSE.controller.FacilityManagement;

import OOSE.db.FacilityDBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        //처음 콤보박스에 값가져오기
        boolean check = dbManager.registerFacilityInforInfo("1234");
        if(check) {
            req.setAttribute("check", check);
            resp.sendRedirect("view/facility/FacilityRegister.jsp");
        }else {//실패
            req.setAttribute("check", check);
            resp.sendRedirect("view/facility/FacilityRegister.jsp");
        }
    }
}
