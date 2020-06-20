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

@WebServlet("/reqModifyAccomodationPayment")
public class ModifyAccomodationPayment extends HttpServlet
{
    private AccomodationPaymentDBManager accomodationPaymentDBManager=new AccomodationPaymentDBManager();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        AccomodationPayment accomodationPayment = new AccomodationPayment();
        accomodationPayment.setPaymentId(Integer.parseInt(req.getParameter("paymentId")));
        System.out.println(req.getParameter("paymentId"));
        accomodationPayment.setTotalPeople(Integer.parseInt(req.getParameter("totalPeople")));
        accomodationPayment.setMoney(Integer.parseInt(req.getParameter("money")));
        accomodationPayment.setPaymentWay(req.getParameter("paymentWay"));
        accomodationPayment.setRefund(req.getParameter("refund"));
        accomodationPayment.setDivision(Integer.parseInt(req.getParameter("division")));
        accomodationPayment.setPaidDate(req.getParameter("paidDate"));
        accomodationPaymentDBManager.modifyAccomodationPayment(accomodationPayment);

        resp.sendRedirect("/view/accomodationPayment/accomodationPaymentRegister.jsp");
        resp.sendRedirect("/view/accomodationPayment/refundRegister.jsp");
    }
}
