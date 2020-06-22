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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        ArrayList<Member> memberList=new ArrayList<Member>();
        memberList=dbManager.browseMemberList();
        req.setAttribute("memberList",memberList);
        req.getRequestDispatcher("/view/MemberView/browseMemberView.jsp").forward(req,resp);
    }
}
