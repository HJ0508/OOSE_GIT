package OOSE.Controller.AccomodationPayment;

import OOSE.Database.AccommodationPaymentDBManager;
import OOSE.Model.AccommodationPayment;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/reqBrowseRefund")
public class BrowseRefund extends HttpServlet {
    AccommodationPaymentDBManager accommodationPaymentDBManager = new AccommodationPaymentDBManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            ArrayList<AccommodationPayment> accommodationPaymentList=new ArrayList<AccommodationPayment>();
            accommodationPaymentList=accommodationPaymentDBManager.browseAccommodationPaymentList();
            req.setAttribute("accommodationPaymentList",accommodationPaymentList);
            req.getRequestDispatcher("/view/AccommodationPayment/refundBrowse.jsp").forward(req,resp);
        }
    }
}