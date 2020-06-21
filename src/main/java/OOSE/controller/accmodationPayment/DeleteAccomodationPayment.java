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


/* 수정사항 (읽고 삭제바람)
* 클래스 이름 다름 (delete가 아닌 Delete)
* HttpServlet 상속하지 않음
* 변수이름 다름 (accommodationPayment -> payment)
* SQLException 처리
* */
@WebServlet("/view/accomodationPayment/reqDeleteMember")
public class DeleteAccomodationPayment extends HttpServlet{
    private AccomodationPaymentDBManager dbManager = new AccomodationPaymentDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            AccomodationPayment payment = new AccomodationPayment();
            payment.setPaymentId(Integer.parseInt(req.getParameter("paymentId")));
            dbManager.deleteAccomodationPayment(payment);

            resp.sendRedirect("/view/accomodationPayment/accomodationPaymentbrowse.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
