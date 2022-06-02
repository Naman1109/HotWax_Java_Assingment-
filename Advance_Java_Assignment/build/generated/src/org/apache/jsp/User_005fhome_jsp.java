package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class User_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"index\">\t\n");
      out.write(" <center>\n");
      out.write("        <hr>\n");
      out.write("        <hr>\n");
      out.write("        <a  href=\"showdata.jsp\">Show Data</a>\n");
      out.write("        <a  href=\"search_info.jsp\">Search User</a>\n");
      out.write("        <a  href=\"delete_info.jsp\">Delete User</a>\n");
      out.write("        <a  href=\"update_info.jsp\">Update</a>\n");
      out.write("        <a  href=\"logout.jsp\">Logout</a>\n");
      out.write("        \n");
      out.write("        <hr>\n");
      out.write("        <hr>\n");
      out.write("    </center>\n");
      out.write("            <div>\t\n");
      out.write("\n");
      out.write("                <div>\t\n");
      out.write("                    ");

                        String email = (String) session.getAttribute("email");
                    
      out.write("\n");
      out.write("                    <h2 class=\"title\">Welcome , ");
      out.print(email);
      out.write("</h2>\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <p>\n");
      out.write("                            Welcome to the Java Web Application, This application performed all <strong>crud</strong> operation and have also have functionality of <strong> session management </strong> with customized web View.\n");
      out.write("                   \n");
      out.write("                        </p>\n");
      out.write("                        \n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
