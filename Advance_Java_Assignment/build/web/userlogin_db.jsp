<%@page import="DAO.userdao" %>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    userdao rd = new userdao();
    int i = rd.userLogin(email, password);
    if (i > 0) {
        session.setAttribute("email", email);
%>
<script> alert("Login Successfully..!"+ <%=email%> )</script>
<jsp:include page="User_home.jsp"></jsp:include>
<%} else {%>
<script>alert("Error while Login ..!")</script>
<jsp:include page="login.jsp"></jsp:include>
<%}%>