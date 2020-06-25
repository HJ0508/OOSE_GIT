package OOSE.controller.AuthorityManagement;

import OOSE.db.AuthorityDBManager;
import OOSE.model.Authority;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterAuthority extends HttpServlet {
    AuthorityDBManager authorityDBManager;
    HtmlUtil htmlUtil;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println(req.getParameter("accommodation"));
            Authority authority = new Authority(Integer.parseInt(req.getParameter("authorityId")), req.getParameter("authorityName"), req.getParameter("authorityRange"));
            if(authorityDBManager.checkDuplicatedInfo(Integer.parseInt(req.getParameter("authorityId"))))
                htmlUtil.closeOnException(resp, "중복된 권한정보가 존재합니다.");
            else {
                boolean result = authorityDBManager.registerAuthority(authority);
                if (!result) {
                    resp.getWriter().print("<script>opener.location.reload();</script>");
                    htmlUtil.closeOnException(resp, "저장 완료");
                } else
                    htmlUtil.htmlPrint(resp, "저장 실패");
            }
            /* -----Exception----- */
        } catch (NumberFormatException e){ htmlUtil.closeOnException(resp, "입력 형식이 잘못되었습니다."); e.printStackTrace();}
        catch (SQLException e) { htmlUtil.closeOnException(resp, ""); e.printStackTrace();}
    }

    public RegisterAuthority() {
        this.authorityDBManager = new AuthorityDBManager();
        this.htmlUtil = new HtmlUtil();
    }
}
