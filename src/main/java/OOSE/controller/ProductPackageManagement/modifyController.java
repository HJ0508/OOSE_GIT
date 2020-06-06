package OOSE.controller.ProductPackageManagement;


import OOSE.db.ProductPackageDBManager;
import OOSE.model.ProductPackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "modifyProduct", urlPatterns = {"/view/modifyProduct"})
public class modifyController extends HttpServlet {
    ProductPackageDBManager dbManager = new ProductPackageDBManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");

            if(name== null){
                ProductPackage[] pp = dbManager.browseProductInfo();
                req.setAttribute("productList", pp);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/modifyProductPackage.jsp"); //돌려주는 방식은 좀 다르게 해야할 듯
                dispatcher.forward(req, resp);
            }else{
                resp.setContentType("application/json;charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");

                int price = Integer.parseInt(req.getParameter("price"));
                String state = req.getParameter("state");
                int stock = Integer.parseInt(req.getParameter("stock"));
                String note = req.getParameter("note");

                ProductPackage pp = new ProductPackage();
                dbManager = new ProductPackageDBManager();
                pp.setName(name);
                pp.setPrice(price);
                pp.setState(state);
                pp.setStock(stock);
                pp.setNote(note);

                try{
                    boolean result = dbManager.modifyProductInfo(pp);

                    if(result){
                        req.setAttribute("result", "1");
                    }else{
                        req.setAttribute("result", "0");
                    }
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/view/modifyProductPackage.jsp");
                    dispatcher.forward(req, resp);
                }catch(SQLException e){
                    e.printStackTrace();
                    //예외 발생 시 처리
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
