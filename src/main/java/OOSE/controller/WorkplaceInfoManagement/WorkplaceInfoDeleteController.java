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
import java.io.PrintWriter;

@WebServlet("/workplace/deleteWorkplaceInfo")
public class WorkplaceInfoDeleteController extends HttpServlet {
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
            String sqare = req.getParameter("squareMeasure");
            String otherInfo = req.getParameter("otherInfo");

            dbManager.updateWorkplaceInfo(workplaceId, workplaceName, manager, address, phoneNumber, status, fee, openTime, closeTime, sqare, otherInfo);

            htmlPrint(resp, "삭제 성공");






//            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/workplaceInfoBrowse.jsp");
//            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    private void htmlPrint(HttpServletResponse res, String message)
            throws IOException {
        res.setContentType("text/html; charset=euc-kr");
        PrintWriter out = res.getWriter();
        out.println("<script>");
        out.println("alert('" + message + "');");
        out.println("window.opener.location.reload();"); //부모 페이지 새로고침 -> 반영된 결과 새로 조회
        out.println("window.close();"); //팝업은 닫기
        out.println("</script>");
    }
}