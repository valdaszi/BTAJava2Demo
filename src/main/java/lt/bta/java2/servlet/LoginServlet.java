package lt.bta.java2.servlet;

import lt.bta.java2.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        // kazkokia logika eiti i DB ir patikrinti ar teisingi user/password
        boolean valid = user != null && Objects.equals(User.users.get(user), password);

        if (valid) {
            HttpSession session = req.getSession();
            User user2 = new User();
            user2.setName(user);
            user2.setTime(LocalDateTime.now());
            session.setAttribute("User", user2);

            req.getRequestDispatcher("/labas-rytas").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login/form").forward(req, resp);
        }
    }
}
