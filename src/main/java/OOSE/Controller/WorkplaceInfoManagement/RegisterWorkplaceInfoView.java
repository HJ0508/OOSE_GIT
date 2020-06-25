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

@WebServlet("/workplace/viewRegisterWorkplaceInfo")
public class RegisterWorkplaceInfoView extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        checkAuthority(req, resp);
        isChecked(req, resp);
        viewWorkplaceInfoRegister(req, resp);

    }
    private void checkAuthority(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        int authority = (Integer)session.getAttribute("authority");
        int menuAuthority = dbManager.selectAuthority("%사업장속성등록%");
        if(menuAuthority == -1){
            htmlPrint(resp, "메뉴의 접근권한을 확인해주십시오.");
        }
        //권한 검사
        if(authority < menuAuthority){
            String message = "권한이 없습니다.";
            htmlPrint(resp,message);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    public void viewWorkplaceInfoRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Workplace workplace = new Workplace();

        String reqWorkplaceId = req.getParameter("workplaceId"); // req에서 id받아옴

        int intWorkplaceId = Integer.parseInt(reqWorkplaceId);
        workplace = dbManager.selectWorkplaceInfo(intWorkplaceId);


        String[] isVisible = new String[11];
        isVisible = setIsVisible(req,resp, isVisible);
        if(isVisible != null) {
            req.setAttribute("isVisible", isVisible);
            System.out.println(workplace.getName());
            req.setAttribute("content", workplace);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/WorkPlaceInfo/RegisterWorkPlaceInfo.jsp");
            dispatcher.forward(req, resp);
        }
        else{
            htmlPrint(resp,"등록할 항목이 없습니다.");
        }
    }

    public String[] setIsVisible(HttpServletRequest req,HttpServletResponse resp, String[] isVisible){
        String[] checkedList = req.getParameterValues("workplaceInfo");
        int count=0;
        for(int i = 0; i<11; i++){ isVisible[i] = "style=display:none"; }



        for(int i = 0; i<checkedList.length; i++){
            switch(checkedList[i]){
                case "workplaceId":
                    if(req.getParameter("workplaceId").equals("") || req.getParameter("workplaceId")==null){
                        isVisible[0] = "style=display:block";
                        count++;
                    }
                    break;
                case "workplaceName":
                    if(req.getParameter("workplaceName").equals("") || req.getParameter("workplaceName")==null){
                        isVisible[1] = "style=display:block";
                        count++;
                    }
                    break;
                case "manager":
                    if(req.getParameter("manager").equals("") || req.getParameter("manager")==null){
                        isVisible[2] = "style=display:block";
                        count++;
                    }
                    break;
                case "address":
                    if(req.getParameter("address").equals("") || req.getParameter("address")==null){
                        isVisible[3] = "style=display:block";
                        count++;
                    }
                    break;
                case "phoneNumber":
                    if(req.getParameter("phoneNumber").equals("") || req.getParameter("phoneNumber")==null){
                        isVisible[4] = "style=display:block";
                        count++;
                    }
                    break;
                case "workplaceStatus":
                    if(req.getParameter("workplaceStatus").equals("") || req.getParameter("workplaceStatus")==null){
                        isVisible[5] = "style=display:block";
                        count++;
                    }
                    break;
                case "fee":
                    if(req.getParameter("fee").equals("") || req.getParameter("fee").equals("0") || req.getParameter("fee")==null){
                        isVisible[6] = "style=display:block";
                        count++;
                    }
                    break;
                case "openingTime":
                    if(req.getParameter("openingTime").equals("") || req.getParameter("openingTime")==null){
                        isVisible[7] = "style=display:block";
                        count++;
                    }
                    break;
                case "closingTime":
                    if(req.getParameter("closingTime").equals("") || req.getParameter("closingTime")==null){
                        isVisible[8] = "style=display:block";
                        count++;
                    }
                    break;
                case "squareMeasure":
                    if(req.getParameter("squareMeasure").equals("")|| req.getParameter("squareMeasure").equals("0") || req.getParameter("squareMeasure")==null){
                        isVisible[9] = "style=display:block";
                        count++;
                    }
                    break;
                case "otherInfo":
                    if(req.getParameter("otherInfo").equals("") || req.getParameter("otherInfo")==null){
                        isVisible[10] = "style=display:block";
                        count++;
                    }
                    break;

            }
        }

        if(count <= 0){
            return null; //선택된 것이 없을때
        }else {
            return isVisible;
        }
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