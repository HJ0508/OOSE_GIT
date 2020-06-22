package OOSE.controller.ProductPackageManagement;


import OOSE.db.ProductPackageDBManager;
import OOSE.model.ProductPackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "modifyProduct", urlPatterns = {"/view/productPackage/modifyProduct"})
public class modifyController extends HttpServlet {
    ProductPackageDBManager dbManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //doPost(req, resp);
            checkAuthority(req);
            dbManager = new ProductPackageDBManager();
            String name = req.getParameter("name");
            if (name != null) {
                try {
                    Object tempPrice = req.getParameter("price");
                    int price;
                    if(!tempPrice.equals("")){
                        price = Integer.parseInt((String)tempPrice);
                    }else{
                        price = -1;
                    }

                    String state = req.getParameter("state");

                    Object tempStock = req.getParameter("stock");
                    int stock;
                    if(!tempStock.equals("")){
                        stock = Integer.parseInt((String)tempStock);
                    }else{
                        stock = -1;
                    }

                    String note = req.getParameter("note");

                    if(price == -1 || state.equals("") || stock == -1){
                        req.setAttribute("result", 2); // 정보 누락
                    }else{
                        ProductPackage pp = new ProductPackage();
                        dbManager = new ProductPackageDBManager();
                        pp.setName(name);
                        pp.setPrice(price);
                        pp.setState(state);
                        pp.setStock(stock);
                        pp.setNote(note);

                        boolean result = dbManager.modifyProductInfo(pp);

                        if (result) {
                            req.setAttribute("result", 1); // 수정 성공
                        } else {
                            req.setAttribute("result", 3); // 수정 실패
                        }
                    }
                } catch (SQLException e) {
                    req.setAttribute("result", 0);
                } catch (NumberFormatException e){
                    req.setAttribute("result" , 5); // 숫자 입력에 문자 입력
                }
            }

            try {
                ProductPackage[] pp = dbManager.browseProductInfo();
                req.setAttribute("productList", pp);
            } catch (SQLException e) {
                req.setAttribute("result", 4); //조회 오류
            }
        }catch (ExceptionOnProductPackage e){
            req.setAttribute("result" , 6); // 권한에 대한 예외 처리
        }finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/productPackage/modifyProductPackage.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void checkAuthority(HttpServletRequest req) throws ExceptionOnProductPackage{
        try{
            HttpSession httpSession = req.getSession();
            int authority = (int)httpSession.getAttribute("authority");
            System.out.println("authority : " + authority);
            dbManager = new ProductPackageDBManager();
            if(!dbManager.checkAuthority(authority, "상품수정")){
                throw new ExceptionOnProductPackage("권한 없음");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
