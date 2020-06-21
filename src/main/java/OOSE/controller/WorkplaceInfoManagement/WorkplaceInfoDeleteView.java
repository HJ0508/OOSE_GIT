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

@WebServlet("/workplace/viewDeleteWorkplaceInfo")
public class WorkplaceInfoDeleteView extends HttpServlet {
    WorkplaceDBManager dbManager = new WorkplaceDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");

            Workplace workplace = new Workplace();

            String reqWorkplaceId = req.getParameter("workplaceId"); // req에서 id받아옴
            System.out.println(reqWorkplaceId);

            int intWorkplaceId = Integer.parseInt(reqWorkplaceId);// 나중엔 세션에서 받아오는걸로 교체할예정
            workplace = dbManager.selectWorkplaceInfo(intWorkplaceId);

            String[] checkedList = req.getParameterValues("workplaceInfo");
            String[] isVisible = new String[11];
            isVisible = setVisible(req,workplace,isVisible);

            req.setAttribute("isVisible", isVisible);
            System.out.println(workplace.getName());
            req.setAttribute("content", workplace);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/workplaceInfoDelete.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    public String[] setVisible(HttpServletRequest req,  Workplace workplace, String[] isVisible){
        String[] checkedList = req.getParameterValues("workplaceInfo");
        for(int i = 0; i<11; i++){ isVisible[i] = "style=display:none"; }

        for(int i = 0; i<checkedList.length; i++){
            switch(checkedList[i]){
                case "workplaceId":
                    isVisible[0] = "text";
                    workplace.setId(0);
                    break;
                case "workplaceName":
                    isVisible[1] = "text";
                    workplace.setName("");
                    break;
                case "manager":
                    isVisible[2] = "text";
                    workplace.setManager("");
                    break;
                case "address":
                    isVisible[3] = "text";
                    workplace.setAddress("");
                    break;
                case "phoneNumber":
                    isVisible[4] = "text";
                    workplace.setPhoneNumber("");
                    break;
                case "workplaceStatus":
                    isVisible[5] = "text";
                    workplace.setStatus("");
                    break;
                case "fee":
                    isVisible[6] = "text";
                    workplace.setFee(0);
                    break;
                case "openingTime":
                    isVisible[7] = "text";
                    workplace.setOpeningTime("");
                    break;
                case "closingTime":
                    isVisible[8] = "text";
                    workplace.setClosingTime("");
                    break;
                case "squareMeasure":
                    isVisible[9] = "text";
                    workplace.setSquare(0);
                    break;
                case "otherInfo":
                    isVisible[10] = "text";
                    workplace.setOtherInfo("");
                    break;

            }
        }
        return isVisible;
    }
}