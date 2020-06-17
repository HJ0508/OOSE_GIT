package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.model.Member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reqModifyMember")
public class ModifyMember extends HttpServlet
{
    private MemberDBManager dbManager=new MemberDBManager();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        Member member = new Member();
        member.setId(req.getParameter("id"));
        member.setPassword(req.getParameter("password"));
        member.setName(req.getParameter("name"));
        member.setAuthority(1);
        member.setPhoneNum(req.getParameter("phoneNumber"));

        if(!dbManager.checkMissingInfo(member))
        {
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('입력값이 빠졌습니다');");
            out.println("history.back();");
            out.println("</script>");
            return;
        }
        if(dbManager.modifyMemberInfo(member))       //수정 성공
            resp.sendRedirect("/view/MemberView/browseMemberView.jsp");
        else
        {
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('업데이트 실패했습니다');");
            out.println("history.back();");
            out.println("</script>");
        }
    }
}
