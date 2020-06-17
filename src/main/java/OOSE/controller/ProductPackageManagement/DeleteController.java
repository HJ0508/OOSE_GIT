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

@WebServlet(name = "deleteProduct", urlPatterns = {"/view/productPackage/deleteProduct"})
public class DeleteController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductPackageDBManager dbManager = new ProductPackageDBManager();
        String name = req.getParameter("name");
        if (name == null) {
            try {
                ProductPackage[] pp = dbManager.browseProductInfo();
                req.setAttribute("productList", pp);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/deleteProductPackage.jsp"); //돌려주는 방식은 좀 다르게 해야할 듯
                dispatcher.forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } else {
            resp.setContentType("application/json;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");


            ProductPackage pp = new ProductPackage();
            pp.setName(req.getParameter("name"));
            System.out.println(pp.getName());

            try {
                boolean result = dbManager.deleteProductInfo(pp);

                if (result) {
                    req.setAttribute("result", "1");
                } else {
                    req.setAttribute("result", "0");
                }
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/deleteProductPackage.jsp");
                dispatcher.forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                //예외 발생 시 처리
            }
        }
    }
}
