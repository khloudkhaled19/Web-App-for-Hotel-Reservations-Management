<%-- 
    Document   : checkPayment
    Created on : 07-Jan-2021, 03:16:28
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
    </head>
    <body>
        <%
          String username = request.getParameter("username");
          int reservationID = Integer.parseInt(request.getParameter("reservation"));
          
          try{
              Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            con = DriverManager.getConnection(url, user, dbPassword);
            
            String check = "select * from payment where username=? and reservationID=?";
            boolean found = false;
            
            st = con.prepareStatement(check);
            st.setString(1,username);
            st.setInt(2,reservationID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
              if(username.equals(rs.getString(2)) && reservationID==rs.getInt(3)){
                  found = true;
                  out.println("Payment is successfully processed");
              }
            
            }
            
            if(!found){
               out.println("No payment or no reservation");
            }
            
            
          }catch(Exception e){out.println("something went wrong");}
        
        
        %>
    </body>
</html>
