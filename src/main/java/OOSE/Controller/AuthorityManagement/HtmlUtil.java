package OOSE.Controller.AuthorityManagement;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlUtil {
    public void htmlPrint(HttpServletResponse res, String message)
            throws IOException {
        res.setContentType("text/html; charset=euc-kr");
        PrintWriter out = res.getWriter();
        out.println("<script>");
        out.println("alert('" + message + "');");
        out.println("history.back(-1);");
        out.println("</script>");
    }

    public void closeOnException(HttpServletResponse resp, String dialogue) throws IOException {
        htmlPrint(resp,dialogue);
        resp.getWriter().print("<script>window.close()</script>");
    }
}

