package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.model.Member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reqRegisterMember")
public class RegisterMember extends HttpServlet
{
    MemberDBManager dbManager = new MemberDBManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        Member member = new Member();
        member.setId(req.getParameter("id"));
        member.setPassword(req.getParameter("password"));
        member.setName(req.getParameter("name"));
        member.setAuthority(1);
        member.setPhoneNum(req.getParameter("phoneNumber"));

        if(!dbManager.checkMissingInfo(member))   //입력하지 않은 정보가 있을 경우
        {
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('입력값이 빠졌습니다');");
            out.println("history.back(-1);");
            out.println("</script>");
            return;
        }
        if(dbManager.checkDuplicationInfo(member.getId())==false)   //중복이 없을 경우
        {
            dbManager.registerMemberInfo(member);       //db에 입력
            resp.sendRedirect("/view/MemberView/registerMemberView.jsp");
        }
        else if(dbManager.checkDuplicationInfo(member.getId()))        //중복이 있을 경우
        {
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('이미 있는 회원 정보입니다');");
            out.println("history.back(-1);");
            out.println("</script>");
        }
    }
}