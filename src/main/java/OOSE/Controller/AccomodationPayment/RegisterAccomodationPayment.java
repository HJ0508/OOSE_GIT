package OOSE.Controller.AccomodationPayment;

import OOSE.Database.AccomodationPaymentDBManager;
import OOSE.Model.AccomodationPayment;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reqRegisterAccomodationPayment")
public class RegisterAccomodationPayment extends HttpServlet {
    AccomodationPaymentDBManager accomodationPaymentDBManager=new AccomodationPaymentDBManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        AccomodationPayment accomodationPayment  = new AccomodationPayment();
        accomodationPayment.setPaymentId(Integer.parseInt(req.getParameter("paymentId")));
        System.out.println(req.getParameter("paymentId"));
        accomodationPayment.setTotalPeople(Integer.parseInt(req.getParameter("totalPeople")));
        accomodationPayment.setMoney(Integer.parseInt(req.getParameter("money")));
        accomodationPayment.setPaymentWay(req.getParameter("paymentWay"));
        accomodationPayment.setRefund(req.getParameter("refund"));
        accomodationPayment.setDivision(Integer.parseInt(req.getParameter("division")));
        accomodationPayment.setPaidDate(req.getParameter("paidDate"));
        accomodationPaymentDBManager.registerAccomodationPayment(accomodationPayment);       //db에 입력

        resp.sendRedirect("/view/accomodationPayment/RegisterAccomodationPayment.jsp");
        resp.sendRedirect("/view/accomodationPayment/RegisterRefund.jsp");
    }
}