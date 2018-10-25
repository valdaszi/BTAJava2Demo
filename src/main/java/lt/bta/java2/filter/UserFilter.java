package lt.bta.java2.filter;

import lt.bta.java2.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/labas-rytas")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("/login/form").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
