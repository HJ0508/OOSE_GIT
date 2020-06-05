package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.Model.Member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reqRegisterMember")
public class RegisterMember extends HttpServlet {
    MemberDBManager dbManager = new MemberDBManager();

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

        dbManager.registerMemberInfo(member);       //db에 입력

        resp.sendRedirect("/view/MemberView/registerMemberView.jsp");
    }
}