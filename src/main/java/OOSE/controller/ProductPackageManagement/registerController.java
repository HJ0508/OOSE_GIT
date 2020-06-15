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

@WebServlet(name = "registerProduct", urlPatterns = {"/view/productPackage/registerProduct"})
//@WebFilter( value = {"/val1", "/val2"}, initParams = @WebInitParam(name = "encoding", value = "UTF-8") )
public class registerController extends HttpServlet {
    ProductPackage pp;
    ProductPackageDBManager dbManager;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //System.out.println(new String(req.getParameter("name").getBytes("8859-1"), "euc-kr"));

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        String state = req.getParameter("state");
        int stock = Integer.parseInt(req.getParameter("stock"));
        String note = req.getParameter("note");

        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        pp = new ProductPackage();
        dbManager = new ProductPackageDBManager();
        pp.setName(name);
        pp.setPrice(price);
        pp.setState(state);
        pp.setStock(stock);
        pp.setNote(note);

        try{
            boolean result = dbManager.registerProductInfo(pp);

            if(result){
                req.setAttribute("result", "1");
            }else{
                req.setAttribute("result", "0");
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/registerProductPackage.jsp");
            dispatcher.forward(req, resp);
        }catch(SQLException e){
            e.printStackTrace();
            //예외 발생 시 처리
        }
    }
}
