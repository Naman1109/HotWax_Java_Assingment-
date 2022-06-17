package Filters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
@WebFilter("/admin/*")
public class filter1 implements Filter {
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest httpRequest = (HttpServletRequest) request;
         HttpSession s = httpRequest.getSession(); 
 
       String  user = (String)s.getAttribute("fname");
       
       if (user!=null)
       {
       chain.doFilter(request, response);
       } 
       else
       {
       response.setContentType("text/html");
       response.getWriter().println("<h1>Please Login First....</h1>");
       }
    }
 
    public void destroy() {
    }
 
    public void init(FilterConfig fConfig) throws ServletException {
    }
 
}