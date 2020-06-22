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

            int intWorkplaceId = Integer.parseInt(reqWorkplaceId);
            workplace = dbManager.selectWorkplaceInfo(intWorkplaceId);


            String[] isVisible = new String[11];
            isVisible = setIsVisible(req, isVisible);



            req.setAttribute("isVisible", isVisible);
            System.out.println(workplace.getName());
            req.setAttribute("content", workplace);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/workplaceInfoRegister.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    public String[] setIsVisible(HttpServletRequest req, String[] isVisible){
        String[] checkedList = req.getParameterValues("workplaceInfo");
        for(int i = 0; i<11; i++){ isVisible[i] = "style=display:none"; }



        for(int i = 0; i<checkedList.length; i++){
            switch(checkedList[i]){
                case "workplaceId":
                    if(req.getParameter("workplaceId").equals("") || req.getParameter("workplaceId")==null){
                        isVisible[0] = "style=display:block";
                    }
                    break;
                case "workplaceName":
                    if(req.getParameter("workplaceName").equals("") || req.getParameter("workplaceName")==null){
                        isVisible[1] = "style=display:block";
                    }
                    break;
                case "manager":
                    if(req.getParameter("manager").equals("") || req.getParameter("manager")==null){
                        isVisible[2] = "style=display:block";
                    }
                    break;
                case "address":
                    if(req.getParameter("address").equals("") || req.getParameter("address")==null){
                        isVisible[3] = "style=display:block";
                    }
                    break;
                case "phoneNumber":
                    if(req.getParameter("phoneNumber").equals("") || req.getParameter("phoneNumber")==null){
                        isVisible[4] = "style=display:block";
                    }
                    break;
                case "workplaceStatus":
                    if(req.getParameter("workplaceStatus").equals("") || req.getParameter("workspaceStatus")==null){
                        isVisible[5] = "style=display:block";
                    }
                    break;
                case "fee":
                    if(req.getParameter("fee").equals("") || req.getParameter("fee").equals("0") || req.getParameter("fee")==null){
                        isVisible[6] = "style=display:block";
                    }
                    break;
                case "openingTime":
                    if(req.getParameter("openingTime").equals("") || req.getParameter("openingTime")==null){
                        isVisible[7] = "style=display:block";
                    }
                    break;
                case "closingTime":
                    if(req.getParameter("closingTime").equals("") || req.getParameter("closingTime")==null){
                        isVisible[8] = "style=display:block";
                    }
                    break;
                case "squareMeasure":
                    if(req.getParameter("squareMeasure").equals("")|| req.getParameter("squareMeasure").equals("0") || req.getParameter("squareMeasure")==null){
                        isVisible[9] = "style=display:block";
                    }
                    break;
                case "otherInfo":
                    if(req.getParameter("otherInfo").equals("") || req.getParameter("otherInfo")==null){
                        isVisible[10] = "style=display:block";
                    }
                    break;

            }
        }

        return isVisible;
    }
}