package lt.bta.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login/form")
public class LoginFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doIt(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doIt(req, resp);
    }

    private void doIt(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<form action=\"" +
                req.getContextPath() + "/login" +
                "\" method=\"POST\"");
        out.println("<br><input name=\"user\">");
        out.println("<br><input name=\"password\">");
        out.println("<br><button>Login</login>");
        out.println("</form>");
    }
}
