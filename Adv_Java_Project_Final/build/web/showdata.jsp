<%@page import="java.sql.*"%>

<%@include file="User_home.jsp" %>
<head>
    <link href="Styles/style1.css" rel="stylesheet">
    <script type='text/javascript' src='JS/Script1.js'></script>
</head>
<body>

    <div id="page">

        <div class="main">
            <div class="#">
                <h2 class="had">List</h2>
                <div class="tablebox">


                    <%

                        try {
                            Class.forName("com.mysql.jdbc.Driver");

                            String db_ur1 = "jdbc:mysql://localhost:3306/assignment_db";
                            String db_uname = "root";
                            String db_upass = "root";
                            Connection con = DriverManager.getConnection(db_ur1, db_uname, db_upass);
                            Statement st = con.createStatement();

                            ResultSet rs = st.executeQuery("select * from usere");
                    %>

                    <table border="1" cellpadding="5" cellspacing="1">

                        <tr>
                        
                            <td> First Name</td>
                            <td> Last Name</td>
                            <td> Email</td>
                            <td> City</td>
                            <td> Zip</td>
                            <td> State</td>
                            <td> Country</td>
                            <td> Zip </td>
                            <td> Phone</td>
                            <td> Update</td>
                            <td> Delete</td>


                        </tr>

                        <%   while (rs.next()) { %>
                        <tr>
                            <% out.println("<td> " + rs.getString(1) + " </td>"); %> 
                            <% out.println("<td> " + rs.getString(2) + " </td>"); %>
                            <% out.println("<td> " + rs.getString(3) + " </td>"); %>
                            <% out.println("<td> " + rs.getString(4) + " </td>"); %>
                            <% out.println("<td> " + rs.getString(5) + " </td>"); %>
                            <% out.println("<td> " + rs.getString(6) + " </td>"); %>
                            <% out.println("<td> " + rs.getString(7) + " </td>"); %>
                            <% out.println("<td> " + rs.getString(8) + " </td>"); %>
                            <% out.println("<td> " + rs.getString(9) + " </td>"); %>

                            <td> <button id="buttonup" onclick="window.location.href = 'update.html';">Update</button> </td>
                            <td> <button id="buttonup" onclick="window.location.href = 'delete.html';">Delete</button> </td>


                        </tr>


                        <%

                            }
                            con.close();
                        %>
                    </table>

                    <%
                        } catch (Exception e1) {
                            System.out.println(e1);

                        }
                    %>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
