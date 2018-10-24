package lt.bta.java2.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ExceptionHandlerServlet", urlPatterns = {"/AppExceptionHandler"})
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //processError(req, resp);
        manoGrazusPranesimas(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //processError(req, resp);
        manoGrazusPranesimas(req, resp);
    }

    private void manoGrazusPranesimas(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //resp.setContentType("text/html");
        //resp.setCharacterEncoding("utf-8");
        //resp.getWriter().println("<h3>Nieko baisaus neatsitiko - pabandykite vėliau :)</h3>");
        //resp.sendRedirect("/kokinori");
        req.getRequestDispatcher("/").forward(req, resp);
    }

    private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Analyze the servlet exception
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) servletName = "Unknown";

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) requestUri = "Unknown";

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Exception/Error Details</title></head><body>");
        if (statusCode != 500) {
            out.write("<h3>Error Details</h3>");
            out.write("<strong>Status Code</strong>:" + statusCode + "<br>");
            out.write("<strong>Requested URI</strong>:" + requestUri);
        } else {
            out.write("<h3>Exception Details</h3>");
            out.write("<ul><li>Servlet Name:" + servletName+"</li>");
            out.write("<li>Exception Name:" + throwable.getClass().getName() + "</li>");
            out.write("<li>Requested URI:" + requestUri + "</li>");
            out.write("<li>Exception Message:" + throwable.getMessage() + "</li>");
            out.write("</ul>");
        }

        out.write("<br><br>");
        out.write("<a href=\"index.html\">Home Page</a>");
        out.write("</body></html>");
    }
}
