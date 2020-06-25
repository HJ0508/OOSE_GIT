package OOSE.Controller.WorkplaceInfoManagement;

import OOSE.Database.WorkplaceDBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/workplace/registerWorkplaceInfo")
public class RegisterWorkplaceInfoController extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        
        checkAuthority(req, resp);
        
        if(checkFormat(req)){
            workplaceInfoRegister(req, resp);
        }
        else {
            htmlPrint(resp, "잘못된 입력입니다. 다시시도해주십시오");
        }






    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
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

    public boolean checkFormat(HttpServletRequest req){ //형식 검사
        int workplaceId = Integer.parseInt(req.getParameter("workplaceId"));
        String workplaceName = req.getParameter("workplaceName");
        String manager = req.getParameter("manager");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String status = req.getParameter("workplaceStatus");
        String fee = req.getParameter("fee");
        String openTime = req.getParameter("openingTime");
        String closeTime = req.getParameter("closingTime");
        String square = req.getParameter("squareMeasure");
        String otherInfo = req.getParameter("otherInfo");

        if(isNumber(fee) == false || isNumber(square) == false){ //숫자인지 검사
            return false;
        }
        else{ // 길이검사
            if(workplaceName.length() > 20)
                return false;
            if(manager.length() > 20)
                return false;
            if(address.length() > 100)
                return false;
            if(phoneNumber.length() > 13)
                return false;
            if(status.length() > 5)
                return false;
            if(fee.length() > 13)
                return false;
            if(openTime.length() > 20) // time은 애매해서 20으로 놔둠
                return false;
            if(closeTime.length() > 20)
                return false;
            if(square.length() > 13)
                return false;
            if(otherInfo.length() > 65535)
                return false;

        }

        return true;
    }

    public boolean isNumber(String input){ // 숫자인지 검사
        char temp;
        for(int i = 0; i < input.length(); i++){
            temp = input.charAt(i);
            if(Character.isDigit(temp) == false){ // 숫자가 아니라면 false
                return false;
            }
        }
        return true; // 숫자면 true
    }

    public void workplaceInfoRegister(HttpServletRequest req, HttpServletResponse resp){
        int workplaceId = Integer.parseInt(req.getParameter("workplaceId"));
        String workplaceName = req.getParameter("workplaceName");
        String manager = req.getParameter("manager");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String status = req.getParameter("workplaceStatus");
        int fee = Integer.parseInt(req.getParameter("fee"));
        String openTime = req.getParameter("openingTime");
        String closeTime = req.getParameter("closingTime");
        int square = Integer.parseInt(req.getParameter("squareMeasure"));
        String otherInfo = req.getParameter("otherInfo");

        boolean result = dbManager.updateWorkplaceInfo(workplaceId, workplaceName, manager, address, phoneNumber, status, fee, openTime, closeTime, square, otherInfo);

        if(result == true){ htmlPrint(resp, "등록 성공"); }
        else{ htmlPrint(resp, "등록 실패"); }
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