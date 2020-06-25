package OOSE.Controller.AccomodationPayment;

import OOSE.Database.AccommodationPaymentDBManager;
import OOSE.Model.AccommodationPayment;
import OOSE.Model.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reqDeleteAccommodationPayment")
public class DeleteAccommodationPayment extends HttpServlet {
    private AccommodationPaymentDBManager dbManager = new AccommodationPaymentDBManager();
    int authority = 3;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if(!checkAuthority((int) req.getSession().getAttribute("authority")))
            {
                printAlert("권한이 없습니다",resp);
                return;
            }
            req.setCharacterEncoding("UTF-8");
            String userId = req.getParameter("userId");
            boolean check = dbManager.deleteAccommodationPayment(userId);
            if(check) {
                req.setAttribute("check", check);
                resp.sendRedirect("view/AccommodationPayment/accommodationPaymentDelete.jsp");
            }else {//실패
                req.setAttribute("check", check);
                resp.sendRedirect("view/AccommodationPayment/accommodationPaymentDelete.jsp");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
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