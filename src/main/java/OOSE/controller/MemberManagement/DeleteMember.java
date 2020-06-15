package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;
import OOSE.model.Member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view/MemberView/reqDeleteMember")      //이렇게 연결하니까 되네..후
public class DeleteMember extends HttpServlet
{
    private MemberDBManager dbManager = new MemberDBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        Member member = new Member();
        member.setId(req.getParameter("id"));
        System.out.println("왜 삭제 안시켜줘 엉엉" + req.getParameter("id"));
        dbManager.deleteMemberInfo(member);
//        if()       //저장에 실패한 경우
//        {
//            //alert 해줄것
//        }
//        else
//        {
//            //alert 해줄것
//            System.out.println("delete Success");
//        }
        resp.sendRedirect("/view/MemberView/browseMemberView.jsp");
    }
}
