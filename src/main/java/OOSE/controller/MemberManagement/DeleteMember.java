package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.model.Member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/MemberView/reqDeleteMember")
public class DeleteMember extends HttpServlet
{
    private MemberDBManager dbManager = new MemberDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        if(!checkAuthority((int) req.getSession().getAttribute("authority")))
        {
            printAlert("권한이 없습니다",resp);
            return;
        }
        Member member = new Member();
        member.setId(req.getParameter("id"));
        if(!dbManager.deleteMemberInfo(member)) //삭제 실패한 경우
        {
            printAlert("서버 오류로 정보 입력 실패했습니다",resp);
            return;
        }
        resp.sendRedirect("/view/MemberView/browseMemberView.jsp");
    }
    public boolean checkAuthority(int authority)
    {
        if(authority>dbManager.findAuthority("회원삭제")||authority==1)      //회원이거나 관리자일 경우
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
