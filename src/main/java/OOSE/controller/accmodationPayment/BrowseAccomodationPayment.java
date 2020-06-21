package OOSE.controller.accmodationPayment;

import OOSE.db.AccomodationPaymentDBManager;
import OOSE.model.AccomodationPayment;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@WebServlet("/reqBrowseAccomodationPayment")
public class BrowseAccomodationPayment extends HttpServlet {
    AccomodationPaymentDBManager accomodationPaymentDBManager = new AccomodationPaymentDBManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        {
            System.out.println("post");
            ArrayList<AccomodationPayment> accomodationPaymentList = new ArrayList<AccomodationPayment>();
            accomodationPaymentList= accomodationPaymentDBManager.browseAccomodationPaymentList();
            req.setAttribute("browseAccomodationPaymentList",accomodationPaymentList);
            req.getRequestDispatcher("/view/accomodationPayment/accmodationPaymentBrowse.jsp").forward(req, resp);
        }
    }
}