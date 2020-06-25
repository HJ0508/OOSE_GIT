package OOSE.controller.FacilityManagement;

import OOSE.db.FacilityDBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/modifyFacilityInformation")
public class ModifyFacilityInformationController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();
    FacilityUtil util = new FacilityUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //값가지고오기
        String oldName = req.getParameter("oldName");
        String name = req.getParameter("name");
        String workPlaceId = req.getParameter("workPlaceId");
        String facilityState = req.getParameter("facilityState");
        String fee = req.getParameter("fee");
        String openTime = req.getParameter("openTime");
        String closeTime = req.getParameter("closeTime");
        String manager = req.getParameter("manager");
        String capacity = req.getParameter("capacity");
        if (checkAuthority(req)) {
            //처음 콤보박스에 값가져오기
            boolean check = dbManager.modifyFacilityInforInfo(oldName, name, workPlaceId, facilityState, fee, openTime, closeTime, manager, capacity);
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
        if (dbManager.checkAuthority(user, "시설정보수정")) {
            return true;
        } else {
            return false;
        }
    }
}
