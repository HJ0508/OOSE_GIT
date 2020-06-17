package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/reqBrowseMember")
public class BrowseMember extends HttpServlet
{
    MemberDBManager dbManager= new MemberDBManager();

    //    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
//    {
//        super.service(req, resp);
//        System.out.println("작동은 하네?");
//        boolean authorityCheckResult=dbManager.checkAuthority(id);
//
//        if(authorityCheckResult==true)        //권한검사를 통과하면
//        {
//            List<Member> memberList;
//            memberList=dbManager.browseMemberList();
//            req.setAttribute("List",memberList);
//        }
//        else if(authorityCheckResult==false)       //권한검사를 통과하지 못하면
//        {
//           req.setAttribute("String", "권한이 없습니다");
//        }
//
//        ArrayList<Member> memberList;
//        memberList=dbManager.browseMemberList();
//        req.setAttribute("memberList",memberList);
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        ArrayList<Member> memberList=new ArrayList<Member>();
        memberList=dbManager.browseMemberList();        //여기까지는 값이 잘 넘어옴(db쪽 연동 및 select는 잘 작동함)
        req.setAttribute("memberList",memberList);
        req.getRequestDispatcher("/view/MemberView/browseMemberView.jsp").forward(req,resp);
    }
}
