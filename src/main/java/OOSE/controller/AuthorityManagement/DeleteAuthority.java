package OOSE.controller.AuthorityManagement;

import OOSE.db.AuthorityDBManager;
import OOSE.model.Authority;
import com.sun.deploy.security.SelectableSecurityManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/reqDeleteAuthority")
public class DeleteAuthority extends HttpServlet
{
    AuthorityDBManager dbManager = new AuthorityDBManager();
    int authority=3;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        dbManager.deleteAuthority(Integer.parseInt(req.getParameter("id")));
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
