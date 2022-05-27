package Connection;

import java.sql.*;

public class GetConnection {

    private final static String Driver = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/assignment_db";
    private final static String USER = "root";
    private final static String PASS = "root";

    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception : " + e);
        }
        return con;
    }
}
