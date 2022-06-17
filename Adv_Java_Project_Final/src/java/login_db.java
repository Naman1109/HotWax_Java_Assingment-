
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class login_db extends HttpServlet {

    public void doGet(HttpServletRequest Request, HttpServletResponse Response) throws IOException, ServletException {
        PrintWriter out = Response.getWriter();
        out.println("<html>");
        out.println("<body>");
        String s1 = Request.getParameter("email");
        String s2 = Request.getParameter("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String db_ur1 = "jdbc:mysql://localhost:3306/assignment_db";
            String db_uname = "root";
            String db_upass = "root";
            Connection con = DriverManager.getConnection(db_ur1, db_uname, db_upass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from usere where email='" + s1 + "' AND password='" + s2 + "'");
            if (rs.next()) {
                String fname = rs.getString(1);
                HttpSession session = Request.getSession();
                session.setAttribute("fname", fname);

           out.write("<script>alert(\"User Loged In...!\");</script>\n");

                Response.sendRedirect("User_home.jsp");
//	out.write("<script>alert(\"User Loged In...!\");</script>\n");
            } else {
                RequestDispatcher dis = Request.getRequestDispatcher("login.jsp");
                dis.include(Request, Response);
            }
            con.close();
        } catch (Exception e1) {
            out.println(e1);
        }

        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
