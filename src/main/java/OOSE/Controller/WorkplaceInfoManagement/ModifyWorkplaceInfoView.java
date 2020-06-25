package OOSE.Controller.WorkplaceInfoManagement;

import OOSE.Database.WorkplaceDBManager;
import OOSE.Model.Workplace;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/workplace/viewModifyWorkplaceInfo")
public class ModifyWorkplaceInfoView extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setCharacterEncoding("UTF-8");

            checkAuthority(req, resp);

            isChecked(req, resp);

            viewWorkplaceModify(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    private void checkAuthority(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        int authority = (Integer)session.getAttribute("authority");
        int menuAuthority = dbManager.selectAuthority("%사업장속성수정%");
        if(menuAuthority == -1){
            htmlPrint(resp, "메뉴의 접근권한을 확인해주십시오.");
        }
        //권한 검사
        if(authority < menuAuthority){
            String message = "권한이 없습니다.";
            htmlPrint(resp,message);
        }
    }

    private void  viewWorkplaceModify(HttpServletRequest req, HttpServletResponse resp){
        try {
            Workplace workplace = new Workplace();

            String reqWorkplaceId = req.getParameter("workplaceId"); // req에서 id받아옴

            int intWorkplaceId = Integer.parseInt(reqWorkplaceId);// 나중엔 세션에서 받아오는걸로 교체할예정
            workplace = dbManager.selectWorkplaceInfo(intWorkplaceId);


            String[] isVisible = new String[11];
            isVisible = setVisible(req,resp,isVisible);

            req.setAttribute("isVisible", isVisible);
            System.out.println(workplace.getName());
            req.setAttribute("content", workplace);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/WorkPlaceInfo/ModifyWorkplaceInfo.jsp");

                dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] setVisible(HttpServletRequest req, HttpServletResponse resp, String[] isVisible){
        String[] checkedList = req.getParameterValues("workplaceInfo");

        for(int i = 0; i<11; i++){ isVisible[i] = "style=display:none"; }

        for(int i = 0; i<checkedList.length; i++){
            switch(checkedList[i]){
                case "workplaceId":
                    isVisible[0] = "style=display:block";
                    break;
                case "workplaceName":
                    isVisible[1] = "style=display:block";
                    break;
                case "manager":
                    isVisible[2] = "style=display:block";
                    break;
                case "address":
                    isVisible[3] = "style=display:block";
                    break;
                case "phoneNumber":
                    isVisible[4] = "style=display:block";
                    break;
                case "workplaceStatus":
                    isVisible[5] = "style=display:block";
                    break;
                case "fee":
                    isVisible[6] = "style=display:block";
                    break;
                case "openingTime":
                    isVisible[7] = "style=display:block";
                    break;
                case "closingTime":
                    isVisible[8] = "style=display:block";
                    break;
                case "squareMeasure":
                    isVisible[9] = "style=display:block";
                    break;
                case "otherInfo":
                    isVisible[10] = "style=display:block";
                    break;

            }
        }
        return isVisible;
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

    private void isChecked(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameterValues("workplaceInfo") == null){ //체크된 것이 없다면
            htmlPrint(resp,"하나 이상 항목을 선택해주세요");
        }
    }

}