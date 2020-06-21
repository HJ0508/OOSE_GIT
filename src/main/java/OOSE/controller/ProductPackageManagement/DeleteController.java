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
        try{
            ProductPackageDBManager dbManager = new ProductPackageDBManager();
            checkAuthority(req);
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
                    e.printStackTrace();
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
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/deleteProductPackage.jsp"); //돌려주는 방식은 좀 다르게 해야할 듯
            dispatcher.forward(req, resp);
        }
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnProductPackage{
        //HttpSession httpSession = req.getSession();
        //int autority = (int)httpSession.getAttribute("autority");

        //아직은 세션에 담고있는 권한이 없어 위의 두 줄은 주석처리하고 임의로 권한을 주어 검사
        int autority = 2;
        if(autority < 3) throw new ExceptionOnProductPackage("권한 없음");
    }
}
