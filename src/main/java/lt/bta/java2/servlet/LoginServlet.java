package lt.bta.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    static Map<String, String> users;

    static {
        users = new HashMap<>();
        users.put("Jonas", "123");
        users.put("petras", "petras");
        users.put("admin", "qwerty");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        // kazkokia logika eiti i DB ir patikrinti ar teisingi user/password
        //boolean valid = Objects.equals("Jonas", user) && Objects.equals("123", password);
        boolean valid = user != null && Objects.equals(users.get(user), password);

        if (valid) {
            req.getRequestDispatcher("/labas-rytas").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login/form").forward(req, resp);
        }
    }
}
