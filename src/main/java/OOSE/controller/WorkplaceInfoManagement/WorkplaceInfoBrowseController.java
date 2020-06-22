package OOSE.controller.WorkplaceInfoManagement;

import OOSE.db.WorkplaceDBManager;
import OOSE.model.Workplace;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebServlet("/workplace/browseWorkplaceInfo")
public class WorkplaceInfoBrowseController extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");

            if(checkAuthority(req, resp)){// 권한검사결과 true이면 진행

                workplaceInfoBrowse(req, resp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    public boolean checkAuthority(HttpServletRequest req, HttpServletResponse resp){ // 권한검사
        HttpSession session = req.getSession();
        int authority = (Integer)session.getAttribute("authority");
        boolean result = false;

        int menuAuthority = dbManager.selectAuthority("%사업장속성조회%");
        System.out.println(menuAuthority);
        if(menuAuthority == -1){
            htmlPrint(resp, "메뉴의 접근권한을 확인해주십시오.");
        }
        else {
            if (authority >= menuAuthority) {
                result = true;
            } else {
                String message = "권한이 없습니다.";
                htmlPrint(resp, message);
            }
        }
        return result;
    }
    public void workplaceInfoBrowse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Workplace workplace = new Workplace();

        String reqWorkplaceId = req.getParameter("workplaceId"); // req에서 id받아옴
        System.out.println(reqWorkplaceId);

        int intWorkplaceId = 0;
        if (reqWorkplaceId == null || reqWorkplaceId.equals(""))
            htmlPrint(resp, "id 조회불가, 다시 시도해 주세요");
        else
            intWorkplaceId = Integer.parseInt(reqWorkplaceId);// 받아온 사업장 id를 사용해 db에서 조회
        workplace = dbManager.selectWorkplaceInfo(intWorkplaceId);

        if (workplace == null) { // 조회결과 없을경우
            System.out.println("조회결과없음");
            String message = "조회결과없음. 다시 시도해 주십시오";
            htmlPrint(resp, message);
        } else {
            System.out.println(workplace.getName());
            req.setAttribute("content", workplace);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/workplaceInfoBrowse.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void htmlPrint(HttpServletResponse res, String message){
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
