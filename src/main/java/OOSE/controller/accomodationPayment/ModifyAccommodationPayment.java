package OOSE.controller.accomodationPayment;

import OOSE.db.AccommodationPaymentDBManager;
import OOSE.model.AccommodationPayment;
import OOSE.model.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reqModifyAccommodationPayment")
public class ModifyAccommodationPayment extends HttpServlet
{
    private AccommodationPaymentDBManager accommodationPaymentDBManager=new AccommodationPaymentDBManager();
    int authority = 3;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
        if (!checkAuthority((int) req.getSession().getAttribute("authority")))  //권한이 없는 경우
        {
            printAlert("권한이 없습니다",resp);
            return;
        }
        AccommodationPayment accommodationPayment = new AccommodationPayment();
        accommodationPayment.setPaymentId(Integer.parseInt(req.getParameter("paymentId")));
        accommodationPayment.setUserId(req.getParameter("userId"));
        accommodationPayment.setAccommodationId(Integer.parseInt(req.getParameter("accommodationId")));
        accommodationPayment.setTotalPeople(Integer.parseInt(req.getParameter("totalPeople")));
        accommodationPayment.setMoney(Integer.parseInt(req.getParameter("money")));
        accommodationPayment.setPaymentWay(req.getParameter("paymentWay"));
        accommodationPayment.setRefund(req.getParameter("refund"));
        accommodationPayment.setDivision(Integer.parseInt(req.getParameter("division")));
        accommodationPayment.setPaidDate(req.getParameter("paidDate"));
        if(!accommodationPaymentDBManager.modifyAccommodationPayment(accommodationPayment)) //수정 실패시
        {
            printAlert("수정실패",resp);
        }
        PrintWriter out = resp.getWriter();
        out.println("<script>");
        out.println("history.back(-1);");
        out.println("</script>");
    }
    public boolean checkAuthority(int authority)
    {
        if(authority==3||authority==2)      //회원이거나 관리자일 경우
            return true;
        return false;       //권한 없음
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
