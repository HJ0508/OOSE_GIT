package OOSE.Controller.ProductPackageManagement;

import OOSE.Database.ProductPackageDBManager;
import OOSE.Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "browseProductPackage", urlPatterns = {"/view/ProductPackage/BrowseProductPackage"})
public class BrowseController extends HttpServlet {

    private final ProductPackageDBManager dbManager = new ProductPackageDBManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession httpSession = req.getSession();
            int autority = (int)httpSession.getAttribute("authority");
            System.out.println(autority); //얘네는 테스트용

            ProductPackage[] productPackages = dbManager.browseProductInfo();
            req.setAttribute("productPackages", productPackages);
            // ServletContext context = req.getServletContext();
            System.out.println("Success");
        }catch(SQLException e){
            req.setAttribute("error", 1);
            e.printStackTrace();
        }finally{

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/ProductPackage/BrowseProductPackage.jsp");
            dispatcher.forward(req, resp);
        }
    }
}