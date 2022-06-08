package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import DAO.userdao;
import DTO.userdto;

public final class showdata_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\t\n");
      out.write("<div id=\"page\">\n");
      out.write("\n");
      out.write("    <div class=\"#\">\n");
      out.write("        <div class=\"#\">\n");
      out.write("            <h2 class=\"#\">List</h2>\n");
      out.write("            <div class=\"#\">\n");
      out.write("                <table border=\"1\" cellpadding=\"5\" cellspacing=\"1\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            \n");
      out.write("                            <!--fname,lname,email,address,city,state,country,zip,phone,password-->\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <th>First Name<br>Id</th>\n");
      out.write("                            <th>last Name</th>\n");
      out.write("                            <th>Email</th>\n");
      out.write("                            <th>Address</th>\n");
      out.write("                            <th>City</th>\n");
      out.write("                            <th>State</th>\n");
      out.write("                            <th>Country</th>\n");
      out.write("                            <th>Zip</th>\n");
      out.write("                            <th>Phone</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            userdao ad = new userdao();
                            List<userdto> list = ad.getList();
                            for (userdto rt : list) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(rt.getFname());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getLname());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getEmail());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getAddress());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getCity());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getState());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getCountry());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getZip());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(rt.getPhone());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
