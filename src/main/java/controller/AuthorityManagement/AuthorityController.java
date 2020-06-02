package controller.AuthorityManagement;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authority")
public class AuthorityController extends HttpServlet{

    private static final long serialVersionUID = 8559171819500212874L;


    @Override
    public void init(ServletConfig sc) throws ServletException{
//        test
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();

        String path = url.substring(contextPath.length());

    }
}