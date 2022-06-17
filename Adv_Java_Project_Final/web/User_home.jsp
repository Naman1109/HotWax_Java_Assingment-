<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Styles/style3.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>
         <%
                        String fname = (String) session.getAttribute("fname");
                    %>
        <div id="divH">
            <h1 id="hading">Advance Java Assignment</h1>
        </div>
        <div id="index">	
            <center>
                <hr>
                <hr>
                <nav>
                    <button id="buttonup" onclick="window.location.href = 'showdata.jsp';">Show Data</button> 
                    <button id="buttonup" onclick="window.location.href = 'search_user.html';">Search User</button> 
                    <button id="buttonup" onclick="window.location.href = 'logout.jsp';">Logout</button> 

                </nav>


                <hr>
                <hr>
            </center>
            <div>	

                <div class="para">	
                    <h2 class="title">Welcome,<%=fname %></h2>
                    <div class="content">
                        <div id="para">
                            Welcome to the Java Web Application, This application performed all <strong>crud</strong> operation and have also have functionality of <strong> session management </strong> with customized web View.

                        </div>


                    </div>
                </div>
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>





    </body>
</html>
