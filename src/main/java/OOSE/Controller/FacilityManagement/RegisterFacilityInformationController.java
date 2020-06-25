package OOSE.Controller.FacilityManagement;

import OOSE.Database.FacilityDBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerFacilityInformation")
public class RegisterFacilityInformationController extends HttpServlet {
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
        String name = req.getParameter("name");
        String workPlaceId = req.getParameter("workPlaceId");
        String facilityState = req.getParameter("facilityState");
        String fee = req.getParameter("fee");
        String openTime = req.getParameter("openTime");
        String closeTime = req.getParameter("closeTime");
        String manager = req.getParameter("manager");
        String capacity = req.getParameter("capacity");
        //처음 콤보박스에 값가져오기
        if (checkAuthority(req)) {
            boolean check = dbManager.registerFacilityInforInfo(name, workPlaceId, facilityState, fee, openTime, closeTime, manager, capacity);
            if (check)
                util.closeOnException(resp, "등록 완료");
            else
                util.htmlPrint(resp, "등록 실패");
        } else {
            util.closeOnException(resp, "권한 없음");
        }
    }

    private boolean checkAuthority(HttpServletRequest req) {
        HttpSession httpSession = req.getSession();
        String user = httpSession.getAttribute("id").toString();
        if (dbManager.checkAuthority(user, "시설정보등록")) {
            return true;
        } else {
            return false;
        }
    }
}
