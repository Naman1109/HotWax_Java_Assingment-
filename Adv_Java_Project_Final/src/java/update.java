
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class update extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='style.css' />");
        out.println("</head>");
        out.println("<body>");

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
            String db_ur1 = "jdbc:mysql://localhost:3306/assignment_db";
            String db_uname = "root";
            String db_upass = "root";
            Connection con = DriverManager.getConnection(db_ur1, db_uname, db_upass);
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE usere SET fname='" + s1 + "', lname='" + s2 + "',address='" + s4 + "', city='" + s5 + "',state='" + s6 + "', country='" + s7 + "',zip='" + s8 + "', phone='" + s9 + "'  where email='" + s3 + "'and password='" + s10 + "' ");
            response.sendRedirect("User_home.jsp");
        } catch (Exception e1) {
            out.println(e1);
        }

        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
