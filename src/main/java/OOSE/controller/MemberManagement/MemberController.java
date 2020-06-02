package OOSE.controller.MemberManagement;

import OOSE.db.MemberDBManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reqRegisterMember")
public class MemberController extends HttpServlet
{
    MemberDBManager dbManager =new MemberDBManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        StringBuffer type=req.getRequestURL();      //     memberControl/ 뒤의 내용을 가져옴
        System.out.println(type);
        System.out.println("asdf");
        resp.sendRedirect("/registerMemberView.jsp");
        /*switch(type)
        {
            case "reqRegisterView":     //요청이 등록화면 요청인 경우 권한검사 실시
                if(true)//(dbManager.checkAuthority(id)==true)        //id값은 어떻게 받아올것인가
                {
                    req.getRequestDispatcher("/registerMemberView.jsp");// 권한검사를 통과하면 등록화면으로 넘어갈것
                }
                break;
            case "reqRegisterMember":
               this.registerMember(req, resp);
               break;


        }*/
    }

    public void registerMember(HttpServletRequest req, HttpServletResponse resp)
    {

    }
}
