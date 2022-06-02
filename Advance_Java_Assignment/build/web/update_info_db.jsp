<%@page import="DAO.userdao" %>
<jsp:useBean id="obj" class="DTO.userdto"></jsp:useBean>
<jsp:setProperty name="obj" property="*"></jsp:setProperty>

<%
    String email = (String) session.getAttribute("email");
    userdao cd = new userdao();
    int i = cd.updateinfo(obj,email);
    if (i == 2) {
%>
<script>alert("Invalid Request....! Please Check credentials");</script>
<jsp:include page="index.jsp"></jsp:include>
<%} else if (i > 0) {%>
<script>alert("Data Updated successfully..!!!");</script>
<jsp:include page="showdata.jsp"></jsp:include>
<%} else {%>
<script>alert("Error occured while updating User Data");</script>
<jsp:include page="index.jsp"></jsp:include>
<%}%>