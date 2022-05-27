<%@page import="java.util.*"%>
<%@page import="DAO.userdao"%>
<%@page import="DTO.userdto"%>	
<div id="page">

    <div class="#">
        <div class="#">
            <h2 class="#">List</h2>
            <div class="#">
                <table border="1" cellpadding="5" cellspacing="1">
                    <thead>
                        <tr>

                            <!--fname,lname,email,address,city,state,country,zip,phone,password-->


                            <th>First Name<br>Id</th>
                            <th>last Name</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Country</th>
                            <th>Zip</th>
                            <th>Phone</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            userdao ad = new userdao();
                            List<userdto> list = ad.getList();
                            for (userdto rt : list) {
                        %>
                        <tr>
                            <td><%=rt.getFname()%></td>
                            <td><%=rt.getLname()%></td>
                            <td><%=rt.getEmail()%></td>
                            <td><%=rt.getAddress()%></td>
                            <td><%=rt.getCity()%></td>
                            <td><%=rt.getState()%></td>
                            <td><%=rt.getCountry()%></td>
                            <td><%=rt.getZip()%></td>
                            <td><%=rt.getPhone()%></td>
                        </tr>
                        <%}%>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
