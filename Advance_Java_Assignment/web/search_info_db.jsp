<%@page import="DAO.userdao" %>
<%@page import="java.util.*"%>
<%@page import="DTO.userdto" %>
<%
    String email = request.getParameter("email");
    String fname = request.getParameter("fname");
     userdao rd = new userdao();
     List<userdto> list = rd.searchinfo(email, fname);
    if (list!=null) {
//        session.setAttribute("email", email);
%>
<script>alert("Search Successfully..!" + email)</script>
<%--<jsp:include page="index.jsp"></jsp:include>--%>
<table border="1" cellpadding="5" cellspacing="1">
    <thead>
        <tr>

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
//            userdao ad = new userdao();
//            List<userdto> list = ad.getList();
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
<%} else {%>
<script>alert("Error while Finding ..!")</script>
<%--<jsp:include page="index.jsp"></jsp:include>--%>
<%}%>