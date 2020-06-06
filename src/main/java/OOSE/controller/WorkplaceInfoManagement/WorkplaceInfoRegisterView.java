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

@WebServlet("/workplace/viewRegisterWorkplaceInfo")
public class WorkplaceInfoRegisterView  extends HttpServlet {
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
            for(int i = 0; i<11; i++){ modifyEditable[i] = "readonly"; }

            for(int i = 0; i<checkedList.length; i++){
                switch(checkedList[i]){
                    case "workplaceId":
                        modifyEditable[0] = "";
                        break;
                    case "workplaceName":
                        modifyEditable[1] = "";
                        break;
                    case "manager":
                        modifyEditable[2] = "";
                        break;
                    case "address":
                        modifyEditable[3] = "";
                        break;
                    case "phoneNumber":
                        modifyEditable[4] = "";
                        break;
                    case "workplaceStatus":
                        modifyEditable[5] = "";
                        break;
                    case "fee":
                        modifyEditable[6] = "";
                        break;
                    case "openingTime":
                        modifyEditable[7] = "";
                        break;
                    case "closingTime":
                        modifyEditable[8] = "";
                        break;
                    case "sqareMeasure":
                        modifyEditable[9] = "";
                        break;
                    case "otherInfo":
                        modifyEditable[10] = "";
                        break;
                }
            }

            req.setAttribute("modifyEditable", modifyEditable);
            System.out.println(workplace.getName());
            req.setAttribute("content", workplace);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/workplaceInfoModify.jsp");
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