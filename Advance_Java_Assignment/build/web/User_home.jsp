<html>
    <body>
        <div id="index">	
 <center>
        <hr>
        <hr>
        <a  href="showdata.jsp">Show Data</a>
        <a  href="search_info.jsp">Search User</a>
        <a  href="delete_info.jsp">Delete User</a>
        <a  href="update_info.jsp">Update</a>
        <a  href="logout.jsp">Logout</a>
        
        <hr>
        <hr>
    </center>
            <div>	

                <div>	
                    <%
                        String email = (String) session.getAttribute("email");
                    %>
                    <h2 class="title">Welcome , <%=email%></h2>
                    <div class="content">
                        <p>
                            Welcome to the Java Web Application, This application performed all <strong>crud</strong> operation and have also have functionality of <strong> session management </strong> with customized web View.
                   
                        </p>
                        
                       
                    </div>
                </div>
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
    </body>
</html>