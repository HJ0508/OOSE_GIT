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

@WebServlet(name = "registerProduct", urlPatterns = {"/view/productPackage/registerProduct"})
public class RegisterController extends HttpServlet {
    ProductPackage pp;
    ProductPackageDBManager dbManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            checkAuthority(req);
            doPost(req, resp);
        }catch(ExceptionOnProductPackage e){
            req.setAttribute("result", 6);
        }finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/RegisterProductPackage.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            Object tempPrice = req.getParameter("price");
            int price;
            if (tempPrice.equals("")) {
                price = -1;
            } else {
                System.out.println(tempPrice);
                price = Integer.parseInt((String) tempPrice);
            }
            String state = req.getParameter("state");
            Object tempStock = req.getParameter("stock");
            int stock;
            if (tempStock.equals("")) {
                stock = -1;
            } else {
                stock = Integer.parseInt((String) tempStock);
            }
            String note = req.getParameter("note");

            pp = new ProductPackage();
            dbManager = new ProductPackageDBManager();
            pp.setName(name);
            pp.setPrice(price);
            pp.setState(state);
            pp.setStock(stock);
            pp.setNote(note);
            if (pp.getName() == null || pp.getPrice() == -1 || pp.getStock() == -1) {
                req.setAttribute("result", 2);
            } else {
                boolean result = dbManager.registerProductInfo(pp);
                if (result) {
                    req.setAttribute("result", 1);
                } else {
                    req.setAttribute("result", 3);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("result", 0);
        } catch (NumberFormatException e) {
            req.setAttribute("result", 4);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/RegisterProductPackage.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnProductPackage{
        try{
            HttpSession httpSession = req.getSession();
            int authority = (int)httpSession.getAttribute("authority");
            System.out.println("authority : " + authority);
            dbManager = new ProductPackageDBManager();
            if(!dbManager.checkAuthority(authority, "상품등록")){
                throw new ExceptionOnProductPackage("권한 없음");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
