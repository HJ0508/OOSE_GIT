package OOSE.Controller.WorkplaceManagement;

import OOSE.Database.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/modifyWorkplaceManagement")
public class ModifyWorkplaceController extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String newId = req.getParameter("newId");
            String oldId = req.getParameter("oldId");
            boolean check = dbManager.modifyWorkplace(oldId, newId);
            if(check) {
                htmlPrint(resp, "수정 성공");
            }else {//실패
                htmlPrint(resp, "수정 실패, 시설에서 사용중인지 확인해주세요");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void htmlPrint(HttpServletResponse res, String message) {
        try {
            res.setContentType("text/html; charset=euc-kr");
            PrintWriter out = null;
            out = res.getWriter();
            out.println("<script>");
            out.println("alert('" + message + "');");
            out.println("window.opener.location.reload();"); //부모 페이지 새로고침 -> 반영된 결과 새로 조회
            out.println("window.close();"); //팝업은 닫기
            out.println("</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
