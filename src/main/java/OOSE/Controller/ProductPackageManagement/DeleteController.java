package OOSE.Controller.ProductPackageManagement;

import OOSE.Database.ProductPackageDBManager;
import OOSE.Model.ProductPackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteProduct", urlPatterns = {"/view/productPackage/deleteProduct"})
public class DeleteController extends HttpServlet {
    ProductPackageDBManager dbManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            checkAuthority(req);
            dbManager = new ProductPackageDBManager();
            String name = req.getParameter("name");

            if(name != null){
                ProductPackage pp = new ProductPackage();
                pp.setName(name);

                try {
                    boolean result = dbManager.deleteProductInfo(pp);
                    if (result) {
                        req.setAttribute("result", 1);
                    } else {
                        req.setAttribute("result", 3);
                    }
                    //RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/deleteProduct");
                    //dispatcher.forward(req, resp);
                } catch (SQLException e) {
                    req.setAttribute("result", 2);
                }
            }

            try {
                ProductPackage[] pp = dbManager.browseProductInfo();
                req.setAttribute("productList", pp);
            } catch (SQLException e) {
                req.setAttribute("result", 4);
            }
        }catch(ExceptionOnProductPackage e){
            req.setAttribute("result", 6);
        }finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/DeleteProductPackage.jsp"); //돌려주는 방식은 좀 다르게 해야할 듯
            dispatcher.forward(req, resp);
        }
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnProductPackage{
        try{
            HttpSession httpSession = req.getSession();
            int authority = (int)httpSession.getAttribute("authority");
            System.out.println("authority : " + authority);
            dbManager = new ProductPackageDBManager();
            if(!dbManager.checkAuthority(authority, "상품삭제")){
                throw new ExceptionOnProductPackage("권한 없음");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
