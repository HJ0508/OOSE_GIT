package OOSE.controller.ProductPackageManagement;

import OOSE.db.ProductPackageDBManager;
import OOSE.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "browseProductPackage", urlPatterns = {"/view/productPackage/browseProductPackage"})
public class BrowseController extends HttpServlet {

    private final ProductPackageDBManager dbManager = new ProductPackageDBManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ProductPackage[] productPackages = dbManager.browseProductInfo();
            req.setAttribute("productPackages", productPackages);
            // ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/browseProductPackage.jsp"); /*경로 변경*/

            dispatcher.forward(req, resp);
            System.out.println("Success");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}