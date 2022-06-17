
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class delete extends HttpServlet {

    public void doGet(HttpServletRequest Request, HttpServletResponse Response) throws IOException, ServletException {
        PrintWriter out = Response.getWriter();
        out.println("<html>");
        out.println("<head><link rel='stylesheet' href = 'style.css'/></head><body>"
                + "<div id='mymenu' ><ul><li><a href ='MenuDemo'>Home</li></a><li>"
                + "</li></a><li><a href = 'displayAll'>DisplayAll</li></a>"
                + "<li><a href = 'updateDemo'>Update</li></a><li><a href = 'LogoutDemo'>Logout</li></a>"
                + "</ul></div><center><form action='DeleteDemo'>"
                + "<table><tr><td>Enter first Name </td><td> <input type='text' placeholder='first name' name='u1'>"
                + "</td></tr><tr><th colspan='2'><input type='submit' class='B' value='search'></th></tr></div></table>"
                + "</form></center>");

        String s1 = Request.getParameter("email");
        String s2 = Request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db_ur1 = "jdbc:mysql://localhost:3306/assignment_db";
            String db_uname = "root";
            String db_upass = "root";
            Connection con = DriverManager.getConnection(db_ur1, db_uname, db_upass);
            Statement st = con.createStatement();
            st.executeUpdate("delete from usere where email='" + s1 + "' and password = '" + s2 + "'");
            Response.sendRedirect("User_home.jsp");
        } catch (Exception e1) {
            out.println(e1);
        }

        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
