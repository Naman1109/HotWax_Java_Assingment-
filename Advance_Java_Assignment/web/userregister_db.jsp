<%@page import="DAO.userdao" %>
<jsp:useBean id="obj" class="DTO.userdto"></jsp:useBean>
<jsp:setProperty name="obj" property="*"></jsp:setProperty>

<%
    userdao cd = new userdao();
    int i = cd.adduser(obj);
    if (i == 2) {
%>
<script>alert("Email Id already exists.. please try with another email id");</script>
<jsp:include page="index.jsp"></jsp:include>
<%} else if (i > 0) {%>
<script>alert("User Added successfully..!!!");</script>
<jsp:include page="login.jsp"></jsp:include>
<%} else {%>
<script>alert("Error occured while adding User");</script>
<jsp:include page="index.jsp"></jsp:include>
<%}%>