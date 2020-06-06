package OOSE.controller.LogineManagement;

import OOSE.db.LoginDBManager;
import OOSE.db.WorkplaceDBManager;
import OOSE.model.Member;
import OOSE.model.Workplace;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    LoginDBManager dbManager = new LoginDBManager();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            String id = req.getParameter("id");
            String passwd = req.getParameter("passwd");

            Member member = dbManager.getManager(id);
            if(member == null){
                System.out.println("조회실패");
            }
            else if(member.getPassword().equals(passwd)){
                System.out.println("로그인성공");
                HttpSession session = req.getSession();
                session.setAttribute("userId",member.getId());
                session.setAttribute("userAuthority", member.getAuthority());

                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/default/main.jsp");
                dispatcher.forward(req, resp);
            }
            else{
                System.out.println("로그인실패");
            }
            




        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
