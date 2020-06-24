package OOSE.controller.AuthorityManagement;


import OOSE.db.AuthorityDBManager;
import OOSE.model.Authority;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/authority")
public class AuthorityController extends HttpServlet
{

    private static final long serialVersionUID = 8559171819500212874L;
    int authority=3;
    private AuthorityDBManager dbManager = new AuthorityDBManager();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        if((int)req.getSession().getAttribute("authority")<dbManager.findAuthority())  //권한이 없는 경우 main화면으로 돌아감
        {
            printAlert("권한이 없습니다",resp);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/default/main.jsp");
//            dispatcher.forward(req, resp);
            return;
        }
        ArrayList<Authority> list= dbManager.browseAuthority();
        req.setAttribute("authorityList", list);
        req.getRequestDispatcher("/view/authority/browseAuthority.jsp").forward(req,resp);
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