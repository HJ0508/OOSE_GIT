package OOSE.Controller.AccomodationPayment;

import OOSE.Database.AccomodationPaymentDBManager;
import OOSE.Model.AccomodationPayment;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

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