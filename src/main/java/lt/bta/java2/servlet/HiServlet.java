package lt.bta.java2.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/abc")
public class HiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("HiServlet: Yes!!!!");

        RequestDispatcher rd = request.getRequestDispatcher("/fine");

        if (request.getParameter("f") != null) {
            rd.forward(request, response);
        } else {
            rd.include(request, response);
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("HiServlet init");
    }

    @Override
    public void destroy() {
        System.out.println("HiServlet destroy");
    }
}
