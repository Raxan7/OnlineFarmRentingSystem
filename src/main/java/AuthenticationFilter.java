
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/templates/*") // Define the URLs that require authentication
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        if(httpRequest.getRequestURI().endsWith("/login.jsp")|| httpRequest.getRequestURI().endsWith("/SignUp")||httpRequest.getRequestURI().endsWith("/Login")||httpRequest.getRequestURI().endsWith("/signup.jsp")){
            chain.doFilter(request, response);
        }else{
        if (session != null && session.getAttribute("email") != null) {
            // User is authenticated, proceed with the request
        chain.doFilter(request, response);
        } else {
            // User is not authenticated, redirect to the login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
        }
        }
    }

    @Override
    public void destroy() {
    }
}
