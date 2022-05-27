package DAO;

import DTO.userdto;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Connection.GetConnection;

public class userdao {

    public List<userdto> getList() throws SQLException {
        List<userdto> list = new ArrayList<>();
        Connection con = GetConnection.getConnect();
        String query = "select * from usere";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

// <!--fname,lname,email,address,city,state,country,zip,phone,password-->
            userdto v = new userdto();

            v.setFname(rs.getString(1));
            v.setLname(rs.getString(2));
            v.setEmail(rs.getString(3));
            v.setAddress(rs.getString(4));
            v.setCity(rs.getString(5));
            v.setState(rs.getString(6));
            v.setCountry(rs.getString(7));
            v.setZip(rs.getString(8));
            v.setPhone(rs.getString(9));
//        v.setPassword(rs.getString(9));

            list.add(v);
        }
        return list;
    }
    ////////////////////////////////////////////////////////////////////////////////////////

    public List<userdto> searchinfo(String email, String fname) throws SQLException {
        List<userdto> list = new ArrayList<>();
//        int i =0;
        Connection con = GetConnection.getConnect();
        String query = "select * from usere where email=? and fname=? ";
//                String query = "select * from usere where email=email and fname";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, fname);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

// <!--fname,lname,email,address,city,state,country,zip,phone,password-->
            userdto v = new userdto();

            v.setFname(rs.getString(1));
            v.setLname(rs.getString(2));
            v.setEmail(rs.getString(3));
            v.setAddress(rs.getString(4));
            v.setCity(rs.getString(5));
            v.setState(rs.getString(6));
            v.setCountry(rs.getString(7));
            v.setZip(rs.getString(8));
            v.setPhone(rs.getString(9));
//        v.setPassword(rs.getString(9));

            list.add(v);
        }
        return list;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public int adduser(userdto obj) throws SQLException {
        Connection con = GetConnection.getConnect();
        String query = "insert into usere(fname,lname,email,address,city,state,country,zip,phone,password) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, obj.getFname());
        ps.setString(2, obj.getLname());
        ps.setString(3, obj.getEmail());
        ps.setString(4, obj.getAddress());
        ps.setString(5, obj.getCity());
        ps.setString(6, obj.getState());
        ps.setString(7, obj.getCountry());
        ps.setString(8, obj.getZip());
        ps.setString(9, obj.getPhone());
        ps.setString(10, obj.getPassword());
        int i = ps.executeUpdate();
        return i;
    }

    public int userLogin(String email, String password) throws SQLException {
        int i = 0;
        Connection con = GetConnection.getConnect();
        String query = "select * from usere where email=? and password=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            i = 1;
        }
        con.close();
        return i;
    }

    /////////////////////////////////////////////////////////////////////////////
    public int delete(String email, String fname) throws SQLException {
        int i = 0;
        Connection con = GetConnection.getConnect();
        String query = "delete from usere where email=? and fname=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, fname);

//        ResultSet rs = 
        if (ps.executeUpdate() > 0) {
            i = 1;
        }
        con.close();
        return i;
    }

}
