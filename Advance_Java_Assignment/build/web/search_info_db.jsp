
<%@page import="DAO.userdao" %>
<%@page import="java.util.*"%>
<%@page import="DTO.userdto" %>


<%
    String email = request.getParameter("email");
    String fname = request.getParameter("fname");
    userdao rd = new userdao();
    List<userdto> list = rd.searchinfo(email, fname);
    if (list != null) {
//        session.setAttribute("email", email);
%>
<script>alert("Search Successfully..!" + email)</script>
<%--<jsp:include page="index.jsp"></jsp:include>--%>

<style>
    body
    {
        display: flex;
        justify-content: center;  
        background-image: url('BG1.jpg');
    }

    #page
    {
        display: flex;
        justify-content: center;
        /*margin-top: 50px;*/

    }
    .main
    {
        text-align: center;
        align-self: center;
        border: 2px solid black;
        padding-bottom: 20px;
        background-color: antiquewhite;
        /*           padding-left: -100px;
                   padding-right:  -100px;*/
        border-radius: 10px;   
        box-shadow:  5px 5px 5px black;
    }

    table
    {
        align-self: center;    
        margin: auto;


    }
    .had
    {

        text-decoration: underline;
        font-size: 25;
    }
    .tablebox
    {
        padding-left: 40px;
        padding-right: 40px;

    }
    
     .button-17 {
          margin-top: 20px;
  align-items: center;
  appearance: none;
  background-color: burlywood ;
  border-radius: 24px;
  border-style: none;
  box-shadow: rgba(0, 0, 0, .2) 0 3px 5px -1px,rgba(0, 0, 0, .14) 0 6px 10px 0,rgba(0, 0, 0, .12) 0 1px 18px 0;
  box-sizing: border-box;
  color: #3c4043;
  cursor: pointer;
  display: inline-flex;
  fill: currentcolor;
  font-family: "Google Sans",Roboto,Arial,sans-serif;
  font-size: 14px;
  font-weight: 500;
  height: 48px;
  justify-content: center;
  letter-spacing: .25px;
  line-height: normal;
  max-width: 100%;
  overflow: visible;
  padding: 2px 24px;
  position: relative;
  text-align: center;
  text-transform: none;
  transition: box-shadow 280ms cubic-bezier(.4, 0, .2, 1),opacity 15ms linear 30ms,transform 270ms cubic-bezier(0, 0, .2, 1) 0ms;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: auto;
  will-change: transform,opacity;
  z-index: 0;
}

.button-17:hover {
  background: #F6F9FE;
  color: #174ea6;
}

.button-17:active {
  box-shadow: 0 4px 4px 0 rgb(60 64 67 / 30%), 0 8px 12px 6px rgb(60 64 67 / 15%);
  outline: none;
}

.button-17:focus {
  outline: none;
  border: 2px solid #4285f4;
}

.button-17:not(:disabled) {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-17:not(:disabled):hover {
  box-shadow: rgba(60, 64, 67, .3) 0 2px 3px 0, rgba(60, 64, 67, .15) 0 6px 10px 4px;
}

.button-17:not(:disabled):focus {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-17:not(:disabled):active {
  box-shadow: rgba(60, 64, 67, .3) 0 4px 4px 0, rgba(60, 64, 67, .15) 0 8px 12px 6px;
}

.button-17:disabled {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

</style> 
<body>

    <div id="page">


        <div class="main">
            <div class="#">
                <h2 class="had">List</h2>
                <div class="tablebox">

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
                        <form action="User_home.jsp">
                        <button class="button-17" role="button" value="submit" >OK</button>
                    </form>
                </div>

            </div>

        </div>


        <%} else {%>
        <script>alert("Error while Finding ..!")</script>
        <%--<jsp:include page="index.jsp"></jsp:include>--%>
        <%}%>
