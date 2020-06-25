package OOSE.controller.WorkplaceInfoManagement;

import OOSE.db.WorkplaceDBManager;
import OOSE.model.Workplace;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
/*
@WebServlet("/workplaceInfoBrowse")
public class WorkplaceInfoBrowserView extends HttpServlet {

    @Override
    public void init(ServletConfig sc) throws ServletException {

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WorkplaceDBManager dbManager = new WorkplaceDBManager();
        Workplace[] workplaces;
        PrintWriter out = resp.getWriter();
        String reqWorkplaceId = req.getParameter("workplaceId");
        System.out.println(reqWorkplaceId);

        int intWorkplaceId = Integer.parseInt(reqWorkplaceId);
        try {
            workplaces = dbManager.selectWorkplaceInfo(intWorkplaceId);
            System.out.println(workplaces[0].getId());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getId());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getName());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getManager());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getAddress());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getPhoneNumber());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getStatus());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getFee());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getOpeningTime());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getClosingTime());
            out.printf("디비조회결과 사업장 속성: %s<br>",workplaces[0].getSquare());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String[] test = req.getParameterValues("workplaceInfo");
        int length = test.length;
        for(int i = 0; i<length; i++) {
            System.out.println(test[i]);

            out.printf("workplace id: %s<br>", test[i]);

        }

    }
    void showWorkplaceRegisterView(){

    }
}*/
