package OOSE.Controller.FacilityManagement;


import OOSE.Database.FacilityDBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/modifyFacilityManagement")
public class ModifyFacilityController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();
    FacilityUtil util = new FacilityUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String oldName = req.getParameter("oldName");
        if (checkAuthority(req)) {
            boolean check = dbManager.modifyFacilityInfo(oldName, name);
            if (check)
                util.closeOnException(resp, "수정 완료");
            else
                util.htmlPrint(resp, "수정 실패");
        } else {
            util.closeOnException(resp, "권한 없음");
        }
    }

    private boolean checkAuthority(HttpServletRequest req) {
        HttpSession httpSession = req.getSession();
        String user = httpSession.getAttribute("id").toString();
        if (dbManager.checkAuthority(user, "시설수정")) {
            return true;
        } else {
            return false;
        }
    }
}
