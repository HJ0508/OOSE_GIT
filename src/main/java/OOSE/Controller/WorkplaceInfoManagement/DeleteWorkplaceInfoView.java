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

@WebServlet("/workplace/viewDeleteWorkplaceInfo")
public class DeleteWorkplaceInfoView extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            checkAuthority(req, resp);
            isChecked(req,resp);
            viewWorkplaceDelete(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    private void checkAuthority(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        int authority = (Integer)session.getAttribute("authority");
        int menuAuthority = dbManager.selectAuthority("%사업장속성삭제%");
        if(menuAuthority == -1){
            htmlPrint(resp, "메뉴의 접근권한을 확인해주십시오.");
        }
        //권한 검사
        if(authority < menuAuthority){
            String message = "권한이 없습니다.";
            htmlPrint(resp,message);
        }
    }
    public void viewWorkplaceDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Workplace workplace = new Workplace();

        String reqWorkplaceId = req.getParameter("workplaceId"); // req에서 id받아옴

        int intWorkplaceId = Integer.parseInt(reqWorkplaceId);
        workplace = dbManager.selectWorkplaceInfo(intWorkplaceId);

        String[] checkedList = req.getParameterValues("workplaceInfo"); //체크된목록



        String[] isVisible = new String[11];

        //화면에 보여줄 기존의 정보
        String[] pastInfo = {Integer.toString(workplace.getId()), workplace.getName(), workplace.getManager(), workplace.getAddress(), workplace.getPhoneNumber(), workplace.getStatus(), Integer.toString(workplace.getFee()), workplace.getOpeningTime(), workplace.getClosingTime(), Integer.toString(workplace.getSquare()), workplace.getOtherInfo()};
        for(int i = 0; i<11; i++){
            System.out.println(pastInfo[i]);
        }

        isVisible = setVisible(req,workplace,isVisible);

        req.setAttribute("isVisible", isVisible);
        req.setAttribute("pastInfo",pastInfo);
        req.setAttribute("content", workplace);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/DeleteWorkplaceInfo.jsp");
        dispatcher.forward(req, resp);
    }

    public String[] setVisible(HttpServletRequest req,  Workplace workplace, String[] isVisible){
        String[] checkedList = req.getParameterValues("workplaceInfo");
        for(int i = 0; i<11; i++){ isVisible[i] = "style=display:none"; }

        for(int i = 0; i<checkedList.length; i++){
            switch(checkedList[i]){
                case "workplaceId":
                    isVisible[0] = "";
                    workplace.setId(0);
                    break;
                case "workplaceName":
                    isVisible[1] = "";
                    workplace.setName("");
                    break;
                case "manager":
                    isVisible[2] = "";
                    workplace.setManager("");
                    break;
                case "address":
                    isVisible[3] = "";
                    workplace.setAddress("");
                    break;
                case "phoneNumber":
                    isVisible[4] = "";
                    workplace.setPhoneNumber("");
                    break;
                case "workplaceStatus":
                    isVisible[5] = "";
                    workplace.setStatus("");
                    break;
                case "fee":
                    isVisible[6] = "";
                    workplace.setFee(0);
                    break;
                case "openingTime":
                    isVisible[7] = "";
                    workplace.setOpeningTime("");
                    break;
                case "closingTime":
                    isVisible[8] = "";
                    workplace.setClosingTime("");
                    break;
                case "squareMeasure":
                    isVisible[9] = "";
                    workplace.setSquare(0);
                    break;
                case "otherInfo":
                    isVisible[10] = "";
                    workplace.setOtherInfo("");
                    break;

            }
        }
        return isVisible;
    }
    private void isChecked(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameterValues("workplaceInfo") == null){ //체크된 것이 없다면
            htmlPrint(resp,"하나 이상 항목을 선택해주세요");
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