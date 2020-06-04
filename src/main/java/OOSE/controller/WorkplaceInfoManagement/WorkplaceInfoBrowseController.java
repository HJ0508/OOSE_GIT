package OOSE.controller.WorkplaceInfoManagement;

import OOSE.db.WorkplaceDBManager;
import OOSE.model.Workplace;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class WorkplaceInfoBrowseController extends HttpServlet {

//    @Override
//    public void init(ServletConfig sc) throws ServletException {
//        super.init(getServletConfig());
//    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            WorkplaceDBManager dbManager = new WorkplaceDBManager();
            Workplace workplace = new Workplace();
//        PrintWriter out = resp.getWriter();
            String reqWorkplaceId = req.getParameter("workplaceId"); // req에서 id받아옴
            System.out.println(reqWorkplaceId);

            int intWorkplaceId = Integer.parseInt(reqWorkplaceId);
            workplace = dbManager.selectWorkplaceInfo(intWorkplaceId);

//        System.out.println(workplace.getId());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getId());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getName());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getManager());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getAddress());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getPhoneNumber());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getStatus());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getFee());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getOpeningTime());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getClosingTime());
//            out.printf("디비조회결과 사업장 속성: %s<br>",workplace.getSquare());
//
//
//        String[] test = req.getParameterValues("workplaceInfo");
//        int length = test.length;
//        for(int i = 0; i<length; i++) {
//            System.out.println(test[i]);
//
//            out.printf("workplace id: %s<br>", test[i]);
//
//        }
            System.out.println(workplace.getName());
            req.setAttribute("content", "test");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/workPlaceInfo/workplaceInfoBrowse.jsp");
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
