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

    int authority = 3;      //관리자만 이용 가능

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        if(!checkAuthority((int)req.getSession().getAttribute("authority"))) //권한이 없다면
        {
            printAlert("권한이 없습니다",resp);
            System.out.println("asdfasdf");
            return;
        }
        Member member = new Member();
        member.setId(req.getParameter("id"));
        member.setPassword(req.getParameter("password"));
        member.setName(req.getParameter("name"));
        member.setAuthority(1);
        member.setPhoneNum(req.getParameter("phoneNumber"));

        if(!dbManager.checkMissingInfo(member))   //입력하지 않은 정보가 있을 경우
        {
            printAlert("입력되지 않은 정보가 있습니다",resp);
            return;
        }
        if(!dbManager.checkFormat(member))    //입력형식이 안맞으면
        {
            printAlert("입력 형식이 맞지 않습니다",resp);
            return;
        }
        if(dbManager.checkDuplicationInfo(member.getId()))        //중복이 있을 경우
        {
            printAlert("이미 있는 회원정보 입니다",resp);
        }
        if(!dbManager.registerMemberInfo(member))       //db에 입력하고 실패시
        {
            printAlert("서버 오류로 정보 입력 실패했습니다",resp);
            return;
        }
        resp.sendRedirect("/view/MemberView/registerMemberView.jsp");

    }
    public boolean checkAuthority(int authority)
    {
        System.out.println("asdf");
        if(dbManager.findAuthority("회원등록")>authority)        //권한이 없다면
            return false;
        return true;
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