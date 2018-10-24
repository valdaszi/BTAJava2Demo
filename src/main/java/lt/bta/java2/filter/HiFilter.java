package lt.bta.java2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HiFilter", urlPatterns = {"/*"})
public class HiFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        //pvz.: jei neprisilogine tai nukreipiam i /login:
        //req.getRequestDispatcher("/login").forward(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
