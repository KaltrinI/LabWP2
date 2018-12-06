package mk.finki.ukim.wp.organizeme;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/logout")
public class LogoutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        httpRequest.getSession().invalidate();

        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.sendRedirect("/login");
    }

    @Override
    public void destroy() {

    }
}
