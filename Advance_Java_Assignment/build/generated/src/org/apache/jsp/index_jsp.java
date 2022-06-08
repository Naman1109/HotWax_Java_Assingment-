package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("     <head>\n");
      out.write(" \n");
      out.write("   \n");
      out.write("        <title>INDEX</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            body\n");
      out.write("            {\n");
      out.write("                background-color: antiquewhite;\n");
      out.write("                    \n");
      out.write("            }\n");
      out.write("   #nav\n");
      out.write("   {\n");
      out.write("       color: whitesmoke;\n");
      out.write("       justify-content: center;\n");
      out.write("       align-self: center;\n");
      out.write("       margin: auto;\n");
      out.write("\n");
      out.write("   }\n");
      out.write("   .hadding\n");
      out.write("   {\n");
      out.write("       color: black;\n");
      out.write("       text-decoration: underline;\n");
      out.write("       \n");
      out.write("   }\n");
      out.write("   nav{\n");
      out.write("       \n");
      out.write("       align-self: center;\n");
      out.write("       display: flex;\n");
      out.write("       \n");
      out.write("   }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center><h1 class=\"hadding\">Assignment_5</h1></center>\n");
      out.write("    <div id=\"nav\">\n");
      out.write("        <nav>\n");
      out.write("        <hr>\n");
      out.write("        <hr>\n");
      out.write("        <a href=\"index.jsp\"> Index</a> | \n");
      out.write("        <a href=\"login.jsp\">  Login</a> |\n");
      out.write("        <a href=\"register.jsp\">   Register</a> |\n");
      out.write("        \n");
      out.write("        <!--<a  href=\"showdata.jsp\">Show Data</a>-->\n");
      out.write("<!--        <a  href=\"search_info.jsp\">Search User</a>\n");
      out.write("        <a  href=\"delete_info.jsp\">Delete User</a>-->\n");
      out.write("        <hr>\n");
      out.write("        <hr>\n");
      out.write("    </nav>\n");
      out.write("        <div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        </div>\n");
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
