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
}