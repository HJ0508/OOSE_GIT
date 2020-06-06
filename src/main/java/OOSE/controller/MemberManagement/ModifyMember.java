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

        dbManager.modifyMemberInfo(member);

        resp.sendRedirect("/view/MemberView/browseMemberView.jsp");     //회원쪽 사이트에서도 이용하려면 바꾸거나 다른 처리르 해 줘야됨

//        PrintWriter out = resp.getWriter();
//        out.println("<script>");
//        out.println("history.back();");       //이전 페이지로 가는 함순데 자꾸 똑같은 페이지만 보여줌 ㅠ
//        out.println("</script>");
        //작동을 안하는데..?
    }
}
