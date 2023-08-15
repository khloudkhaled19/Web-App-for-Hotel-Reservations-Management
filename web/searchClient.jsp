<%-- 
    Document   : searchClient
    Created on : 05-Jan-2021, 02:33:19
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver").newInstance(); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validateSearch(form){
                for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if (form.elements[i].value === "")
                    {
                        alert("Fill out all Fields");
                        document.validateSearch.username.focus();
                        return false;
                    }
                    return true;
                }
            };
            
        </script>
    </head>
    <body>
        <form name="search" onsubmit="return validateSearch(this)">
            <table border="1">
                <tr> 
                    
                    <td> Username:</td>
                    <td><input type="text" name="username"  /></td>  
                   
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="Search" /></td>
                </tr>
            </table>
        </form>
        
        <%
          String username = request.getParameter("username");
          
          Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            con = DriverManager.getConnection(url, user, dbPassword);
          
           String select = "SELECT * FROM user WHERE UserName =?";
           st = con.prepareStatement(select);
           st.setString(1, username);
           
           ResultSet rs = st.executeQuery();
           String fname,sname,email,phone;
           
           while(rs.next()){
              fname = rs.getString(2);
              sname = rs.getString(3);
              email = rs.getString(4);
              phone = rs.getString(6);
              
              
              out.println(fname+" "+sname+" "+email+" "+phone);
           }
        
        
        %>
        
    </body>
</html>
