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
            String[] modifyEditable = new String[11];
            for(int i = 0; i<11; i++){ modifyEditable[i] = "hidden"; }

            for(int i = 0; i<checkedList.length; i++){
                switch(checkedList[i]){
                    case "workplaceId":
                        modifyEditable[0] = "text";
                        workplace.setId(0);
                        break;
                    case "workplaceName":
                        modifyEditable[1] = "text";
                        workplace.setName("");
                        break;
                    case "manager":
                        modifyEditable[2] = "text";
                        workplace.setManager("");
                        break;
                    case "address":
                        modifyEditable[3] = "text";
                        workplace.setAddress("");
                        break;
                    case "phoneNumber":
                        modifyEditable[4] = "text";
                        workplace.setPhoneNumber("");
                        break;
                    case "workplaceStatus":
                        modifyEditable[5] = "text";
                        workplace.setStatus("");
                        break;
                    case "fee":
                        modifyEditable[6] = "text";
                        workplace.setFee(0);
                        break;
                    case "openingTime":
                        modifyEditable[7] = "text";
                        workplace.setOpeningTime("");
                        break;
                    case "closingTime":
                        modifyEditable[8] = "text";
                        workplace.setClosingTime("");
                        break;
                    case "squareMeasure":
                        modifyEditable[9] = "text";
                        workplace.setSquare(0);
                        break;
                    case "otherInfo":
                        modifyEditable[10] = "text";
                        workplace.setOtherInfo("");
                        break;

                }
            }

            req.setAttribute("modifyEditable", modifyEditable);
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
}