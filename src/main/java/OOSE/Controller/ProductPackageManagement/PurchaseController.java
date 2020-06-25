package OOSE.Controller.ProductPackageManagement;

import OOSE.Database.ProductPackageDBManager;
import OOSE.Database.ProductPackagePaymentDBManager;
import OOSE.Model.ProductPackage;
import OOSE.Model.ProductPackagePayment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "purchaseProduct", urlPatterns = {"/view/productPackage/purchaseProduct"})
public class PurchaseController extends HttpServlet {
    ProductPackageDBManager productPackageDBManager;
    ProductPackagePaymentDBManager productPackagePaymentDBManager;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");

        if(productName != null){
            try{
                ProductPackagePayment pp = new ProductPackagePayment();
                Object tempAmount = req.getParameter("amount");
                int amount;
                if(!tempAmount.equals("")){
                    amount = Integer.parseInt((String)tempAmount);
                }else {
                    amount = -1;
                }

                String paymentOption = req.getParameter("paymentOption");
                String refundAccount = req.getParameter("refundAccount");
                for(int i =0; i < refundAccount.length(); i++){
                    char tempChar = refundAccount.charAt(i);
                    if((tempChar != '=') && ('0' >= tempChar || tempChar >= '9')){
                        throw new NumberFormatException();
                    }
                }

                if(amount == -1 || refundAccount.equals("")){
                    req.setAttribute("result", 2); //누락
                }else {
                    HttpSession httpSession = req.getSession();
                    String id = (String)httpSession.getAttribute("id");
                    pp.setProductName(productName);
                    pp.setAmount(amount);
                    pp.setPaymentOption(paymentOption);
                    pp.setRefundAccount(refundAccount);
                    productPackagePaymentDBManager = new ProductPackagePaymentDBManager();
                    boolean tmp = productPackagePaymentDBManager.registerProductPackagePaymentInfo(pp, id);
                    if (tmp) {
                        req.setAttribute("result", 1);
                    } else {
                        req.setAttribute("result", 3); // 재고 부족
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
                req.setAttribute("result", 0); //오류
            }catch(NumberFormatException e){
                req.setAttribute("result", 5); //숫자에 문자로
            }
        }

        try{
            productPackageDBManager = new ProductPackageDBManager();
            ProductPackage[] pp = productPackageDBManager.browseProductInfo();
            req.setAttribute("productList", pp);
        }catch (SQLException e){
            req.setAttribute("result", 4); //조회 오류
        }finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/PurchaseProduct.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
