package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view/MemberView/reqBrowseMemberView_member")      //회원페이지의 화면 요청
public class BrowseMember_member extends HttpServlet
{
    MemberDBManager dbManager = new MemberDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException
    {
        try
        {
            Member member = new Member();
            member.setId((String)req.getSession().getAttribute("id"));
            member = dbManager.browseMemberInfo(member);

            req.setAttribute("member", member);
            req.getRequestDispatcher("/view/MemberView/browseMemberView_member.jsp").forward(req,resp);
        }
        catch(IOException e)
        {
            e.getStackTrace();
        }
    }
}
