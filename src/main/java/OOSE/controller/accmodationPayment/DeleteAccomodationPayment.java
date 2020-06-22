package OOSE.controller.accmodationPayment;

import OOSE.db.AccomodationPaymentDBManager;
import OOSE.db.MemberDBManager;
import OOSE.model.AccomodationPayment;
import OOSE.model.Member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/view/accomodationPayment/reqDeleteMember")
public class DeleteAccomodationPayment extends HttpServlet {
    private AccomodationPaymentDBManager dbManager = new AccomodationPaymentDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            AccomodationPayment payment = new AccomodationPayment();
            payment.setPaymentId(Integer.parseInt(req.getParameter("paymentId")));
            dbManager.deleteAccomodationPayment(payment);

            resp.sendRedirect("/view/accomodationPayment/accomodationPaymentbrowse.jsp");
        } catch (SQLException e) {e.printStackTrace();}
    }
}
