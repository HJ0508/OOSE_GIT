package OOSE.Controller.AuthorityManagement;

import OOSE.Database.AuthorityDBManager;
import OOSE.Model.Authority;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ModifyAuthority extends HttpServlet {
    AuthorityDBManager authorityDBManager;
    HtmlUtil htmlUtil;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Authority authority = authorityDBManager.browseSpecificAuthority(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("authority",authority);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/Authority/ModifyAuthority.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            boolean result = authorityDBManager.modifyAuthority(Integer.parseInt(req.getParameter("originId")), Integer.parseInt(req.getParameter("authorityId")), req.getParameter("authorityName"), req.getParameter("authorityRange"));
            if(!result){
                resp.getWriter().print("<script>opener.location.reload();</script>");
                htmlUtil.closeOnException(resp,"수정 완료");
            } else {
                htmlUtil.htmlPrint(resp, "수정 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ModifyAuthority() {
        this.authorityDBManager = new AuthorityDBManager();
        this.htmlUtil = new HtmlUtil();
    }
}
