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

@WebServlet(name = "productList", urlPatterns = {"/productList"})
public class BrouseControllerForMember extends HttpServlet {

    private final ProductPackageDBManager dbManager = new ProductPackageDBManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ProductPackage[] productPackages = dbManager.browseProductInfo();
            req.setAttribute("productPackages", productPackages);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/browseProductForMember.jsp");
            dispatcher.forward(req, resp);
            System.out.println("Success!!!");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
