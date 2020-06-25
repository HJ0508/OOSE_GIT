package OOSE.Controller.LoginManagement;

import OOSE.Database.LoginDBManager;
import OOSE.Model.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class LoginController extends HttpServlet {
    LoginDBManager dbManager = new LoginDBManager();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            String id = req.getParameter("id");
            String passwd = req.getParameter("passwd");
            String userDivision = req.getParameter("userDivision"); //회원, 직원, 관리자 구분

            Member member = null;
            String url = null;
            if(userDivision.equals("비회원")){ // 비회원 페이지 계속
                HttpSession session = req.getSession();
                session.setAttribute("id","비회원"); // 비회원 id 설정해줘야하는지
                session.setAttribute("authority", 0); // 권한 0으로 계속
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/default/Main_member.jsp");
                dispatcher.forward(req, resp);
            }
            else {
                if (userDivision.equals("관리자")) {
                    member = dbManager.getManager(id);
                    url = "/view/default/Main.jsp";
                } else if (userDivision.equals("직원")) {
                    member = dbManager.getEmployee(id);
                    url = "/view/default/Main.jsp";
                } else if (userDivision.equals("회원")) {
                    member = dbManager.getMember(id);
                    url = "/view/default/Main_member.jsp";
                }


                if (member == null) { //조회가 안돼서 null일 경우
                    System.out.println("로그인실패");
                    req.setAttribute("loginMessage", "조회 실패. 일치하는 id가 없습니다.");

                    RequestDispatcher dispatcher = req.getRequestDispatcher("/view/default/Login.jsp");
                    dispatcher.forward(req, resp);
                } else if (member.getPassword().equals(passwd)) {
                    System.out.println("로그인성공");
                    HttpSession session = req.getSession();
                    session.setAttribute("id", member.getId());
                    session.setAttribute("authority", member.getAuthority());

                    RequestDispatcher dispatcher = req.getRequestDispatcher(url);
                    dispatcher.forward(req, resp);
                } else { //비밀번호가 틀릴 경우
                    System.out.println("로그인실패");
                    req.setAttribute("loginMessage", "로그인 실패. 다시 시도해 주십시오.");

                    RequestDispatcher dispatcher = req.getRequestDispatcher("/view/default/Login.jsp");
                    dispatcher.forward(req, resp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
