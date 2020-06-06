package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.model.Member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reqModifyMember")
public class ModifyMember extends HttpServlet
{
    private MemberDBManager dbManager=new MemberDBManager();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        Member member = new Member();
        member.setId(req.getParameter("id"));
        System.out.println(req.getParameter("id"));
        member.setPassword(req.getParameter("password"));
        member.setName(req.getParameter("name"));
        member.setAuthority(1);
        member.setPhoneNum(req.getParameter("phoneNumber"));

        dbManager.modifyMember(member);

        resp.sendRedirect("/view/MemberView/browseMemberView.jsp");

    }
}
