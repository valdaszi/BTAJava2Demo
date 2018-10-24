package lt.bta.java2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebFilter(filterName = "FineFilter", urlPatterns = {"/fine"},
        dispatcherTypes = {DispatcherType.REQUEST},
        initParams = {@WebInitParam(name = "flag", value = "on")})
public class FineFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FineFilter init");
        if (Objects.equals(filterConfig.getInitParameter("flag"), "on")) {
            filterConfig.getServletContext().setAttribute("action", "doit");
        } else {
            filterConfig.getServletContext().setAttribute("action", "end");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.println("This is FineFilter with context attribute action = " + servletRequest.getServletContext().getAttribute("action"));

        out.println("<br>Start Regular Content:<br><hr>");
        filterChain.doFilter(servletRequest, servletResponse);

        //HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //HttpServletRequest req = (HttpServletRequest) servletRequest;
        //resp.sendRedirect(req.getContextPath() + "/index.jsp");

        out.println("<br><hr>End Regular Content<br>");
    }

    @Override
    public void destroy() {

    }
}
