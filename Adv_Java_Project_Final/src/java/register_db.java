
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class register_db extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

//                    <!--fname,lname,email,address,city,state,country,zip,phone,password-->
        String s1 = request.getParameter("fname");
        String s2 = request.getParameter("lname");
        String s3 = request.getParameter("email");
        String s4 = request.getParameter("address");
        String s5 = request.getParameter("city");
        String s6 = request.getParameter("state");
        String s7 = request.getParameter("country");
        String s8 = request.getParameter("zip");
        String s9 = request.getParameter("phone");
        String s10 = request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db", "root", "root");
            Statement st = con.createStatement();
            st.executeUpdate("insert into usere values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "','" + s9 + "','" + s10 + "')");
            con.close();
            out.write("<script>alert(\"User Added...!\");</script>\n");
            response.sendRedirect("login.html");
            out.println("data insert");
        } catch (Exception e1) {
            out.println(e1);
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
