package lt.bta.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/s")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer counter = (Integer) session.getAttribute("Counter");
        if (counter == null) counter = 0;

        counter++;
        session.setAttribute("Counter", counter);

        resp.setContentType("text/html");
        resp.getWriter().println("Session: Counter = " + counter);
    }
}
