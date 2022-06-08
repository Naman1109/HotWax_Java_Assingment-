<%
    session.invalidate();
response.setHeader("Cache-Control","no-cache,no-store");
response.sendRedirect("index.jsp");


%>s
