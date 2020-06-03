package OOSE.controller.ProductPackageManagement;

import OOSE.db.ProductPackagePaymentDBManager;
import OOSE.model.ProductPackagePayment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ap", urlPatterns = {"/view/ap"})
public class AggregateController extends HttpServlet {
    ProductPackagePaymentDBManager dbManager = new ProductPackagePaymentDBManager();

    //@Override
    //protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    try {
    //        ProductPackagePayment[] productPackagePayments = dbManager.browseProductPaymentInfo("2020.04.01");
    //        req.setAttribute("productPackagePayments", productPackagePayments);

    //        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/performanceAggregate.jsp");
    //        dispatcher.forward(req, resp);
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("d");

        try {
            if(!date.equals("")) {
                ProductPackagePayment[] productPackagePayments = dbManager.browseProductPaymentInfo(date);
                req.setAttribute("productPackagePayments", productPackagePayments);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/performanceAggregate.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
