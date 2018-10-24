package lt.bta.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/c")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Cookie[] cookies = req.getCookies();
        // ar yra mano cookie?
        boolean yra = false;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("sausainiukas")) {
                    yra = true;
                    break;
                }
            }
        }

        Cookie cookie = new Cookie("sausainiukas", yra ? "1" : "0");
        cookie.setMaxAge(5); //5s
        resp.addCookie(cookie);

        PrintWriter out = resp.getWriter();
        out.println("CookiesServlet:");
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("sausainiukas")) {
                    out.println("<br>" + c.getName() + ": " + c.getValue());
                }
            }
        } else {
            out.println("No cookies");
        }
    }
}
