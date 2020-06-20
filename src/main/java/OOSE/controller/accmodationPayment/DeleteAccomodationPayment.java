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

@WebServlet("/view/accomodationPayment/reqDeleteMember")
public class deleteAccomodationPayment {
    private AccomodationPaymentDBManager dbManager = new AccomodationPaymentDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AccomodationPayment payment = new AccomodationPayment();
        payment.setPaymentId(req.getParameter("paymentId"));
        dbManager.deleteAccomodationPayment(accomodationPayment);

        resp.sendRedirect("/view/accomodationPayment/accomodationPaymentbrowse.jsp");
    }
}
