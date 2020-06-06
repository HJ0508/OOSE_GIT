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


            String[] modifyEditable = new String[11];
            for(int i = 0; i<11; i++){ modifyEditable[i] = "hidden"; }

            if(req.getParameter("workplaceId").equals("") || req.getParameter("workplaceId")==null){
                modifyEditable[0] = "text";
            }
            else if(req.getParameter("workplaceName").equals("") || req.getParameter("workplaceName")==null){
                modifyEditable[1] = "text";
            }
            else if(req.getParameter("manager").equals("") || req.getParameter("manager")==null){
                modifyEditable[2] = "text";
            }
            else if(req.getParameter("address").equals("") || req.getParameter("address")==null){
                modifyEditable[3] = "text";
            }
            else if(req.getParameter("phoneNumber").equals("") || req.getParameter("phoneNumber")==null){
                modifyEditable[4] = "text";
            }
            else if(req.getParameter("workplaceStatus").equals("") || req.getParameter("workspaceStatus")==null){
                modifyEditable[5] = "text";
            }
            else if(req.getParameter("fee").equals("") || req.getParameter("fee").equals("0") || req.getParameter("fee")==null){
                modifyEditable[6] = "text";
            }
            else if(req.getParameter("openingTime").equals("") || req.getParameter("openingTime")==null){
                modifyEditable[7] = "text";
            }
            else if(req.getParameter("closingTime").equals("") || req.getParameter("closingTime")==null){
                modifyEditable[8] = "text";
            }
            else if(req.getParameter("squareMeasure").equals("")|| req.getParameter("squareMeasure").equals("0") || req.getParameter("squareMeasure")==null){
                modifyEditable[9] = "text";
            }
            else if(req.getParameter("otherInfo").equals("") || req.getParameter("otherInfo")==null){
                modifyEditable[10] = "text";
            }


            req.setAttribute("modifyEditable", modifyEditable);
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
}