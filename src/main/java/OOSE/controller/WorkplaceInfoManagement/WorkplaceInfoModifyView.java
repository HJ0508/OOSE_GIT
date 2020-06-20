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

@WebServlet("/workplace/viewModifyWorkplaceInfo")
public class WorkplaceInfoModifyView extends HttpServlet {
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


            String[] isVisible = new String[11];
            isVisible = setVisible(req,isVisible);

            req.setAttribute("isVisible", isVisible);
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

    public String[] setVisible(HttpServletRequest req, String[] isVisible){
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
}