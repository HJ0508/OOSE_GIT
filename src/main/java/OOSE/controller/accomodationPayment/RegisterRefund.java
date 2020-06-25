package OOSE.controller.accomodationPayment;

import OOSE.db.AccommodationPaymentDBManager;
import OOSE.model.AccommodationPayment;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reqRegisterRefund")
public class RegisterRefund extends HttpServlet {
    AccommodationPaymentDBManager accommodationPaymentDBManager = new AccommodationPaymentDBManager();
    int authority = 3;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(checkAuthority((int)req.getSession().getAttribute("authority"))==false) //권한이 없다면
        {
            printAlert("권한이 없습니다",resp);
            return;
        }
        AccommodationPayment accommodationPayment= new AccommodationPayment();
        accommodationPayment.setPaymentId(Integer.parseInt(req.getParameter("paymentId")));
        accommodationPayment.setUserId(req.getParameter("userId"));
        accommodationPayment.setAccommodationId(Integer.parseInt(req.getParameter("accommodationId")));
        accommodationPayment.setTotalPeople(Integer.parseInt(req.getParameter("totalPeople")));
        accommodationPayment.setMoney(Integer.parseInt(req.getParameter("money")));
        accommodationPayment.setPaymentWay(req.getParameter("paymentWay"));
        accommodationPayment.setRefund(req.getParameter("refund"));
        accommodationPayment.setDivision(Integer.parseInt(req.getParameter("division")));
        accommodationPayment.setPaidDate(req.getParameter("paidDate"));
        if(accommodationPaymentDBManager.checkDuplicationInfo(String.valueOf(accommodationPayment.getPaymentId())))
        {
            printAlert("이미 있는 정보 입니다",resp);
        }
        if(!accommodationPaymentDBManager.registerAccommodationPayment(accommodationPayment))       //db에 입력하고 실패시
        {
            printAlert("정보 입력에 실패했습니다",resp);
            return;
        }
        resp.sendRedirect("/view/accommodationPayment/refundRegister.jsp");
    }

    public boolean checkAuthority(int authority)
    {
        if(authority==1)        //권한이 없다면
            return false;
        return true;
    }
    public void printAlert(String msg, HttpServletResponse resp) throws IOException
    {
        PrintWriter out = resp.getWriter();
        out.println("<script>");
        out.println("alert('" + msg + "');");
        out.println("history.back(-1);");
        out.println("</script>");
    }
}