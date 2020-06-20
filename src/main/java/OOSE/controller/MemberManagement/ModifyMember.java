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
    int authority=3;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        //로그인 구현 쪽 병합시 테스트해볼 예정
//        if (checkAuthority((int) req.getSession().getAttribute("authority")))
//        {
//            printAlert("권한이 없습니다",resp);
//            return;
//        }
        Member member = new Member();
        member.setId(req.getParameter("id"));
        member.setPassword(req.getParameter("password"));
        member.setName(req.getParameter("name"));
        member.setAuthority(1);
        member.setPhoneNum(req.getParameter("phoneNumber"));

        if(!dbManager.checkMissingInfo(member)) //입력값이 빠진게 있으면
        {
           printAlert("입력되지 않은 정보가 있습니다",resp);
            return;
        }
        if(!dbManager.checkFormat(member))    //입력형식이 안맞으면
        {
            printAlert("입력 형식이 맞지 않습니다",resp);
            return;
        }
        if(!dbManager.modifyMemberInfo(member)) //수정 실패시
        {
            printAlert("서버 오류로 정보수정 실패했습니다",resp);
        }
        resp.sendRedirect("/view/MemberView/browseMemberView.jsp");
    }
    public boolean checkAuthority(int authority)
    {
        if(authority>this.authority||authority==1)      //회원이거나 관리자일 경우
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
