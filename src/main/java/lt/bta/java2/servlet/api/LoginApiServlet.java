package lt.bta.java2.servlet.api;

import com.google.gson.Gson;
import lt.bta.java2.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/api/login")
public class LoginApiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        // kazkokia logika eiti i DB ir patikrinti ar teisingi user/password
        boolean valid = user != null && Objects.equals(User.users.get(user), password);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        Gson gson = new Gson();
        if (valid) {
            gson.toJson(Response.onSuccess("OK"), resp.getWriter());
        } else {
            gson.toJson(Response.onError("Blogas loginas"), resp.getWriter());
        }
    }
}
