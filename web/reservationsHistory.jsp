<%-- 
    Document   : reservationsHistory
    Created on : 04-Jan-2021, 03:50:01
    Author     : Khloud
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver").newInstance(); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validateHistory(form){
                 for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if (form.elements[i].value === "")
                    {
                        alert("Fill out all Fields");
                        document.history.from.focus();
                        document.history.to.focus();
                        return false;
                    }
                     if (!/^(\d{4})-(\d{1,2})-(\d{1,2})$/.test(document.history.from.value) && /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.history.from.value)) {
                        alert("Enter the date in this format yy-mm-dd and don't type a text!");
                        return false;
                    }
                        if (!/^(\d{4})-(\d{1,2})-(\d{1,2})$/.test(document.history.to.value) && /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.history.to.value)) {
                        alert("Enter the date in this format yy-mm-dd and don't type a text!");
                        return false;
                    }

                return true;
                    
                }
            };
            
        </script>
    </head>
    <body>
        <form action="reservationsHistory" method="Get" name="history" onsubmit="return validateHistory(this)">
            <table border="1">
                <tr> 
                    <td> From:</td>
                    <td><input type="text" name="from"  /></td>
                
                </tr>
                <tr> 
                    <td> To:</td>
                    <td><input type="text" name="to"  /></td>
                
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="Enter" /></td>
                </tr>
            </table>
        </form>
        <%--
          String fday = request.getParameter("fday");
          String fmonth = request.getParameter("fmonth");
          String fyear = request.getParameter("fyear");
          String tday = request.getParameter("tday");
          String tmonth = request.getParameter("tmonth");
          String tyear = request.getParameter("tyear");
          
          String fromDate = fyear+"-"+fmonth+"-"+fday;
          String toDate = tyear+"-"+tmonth+"-"+tday;
          

          
          Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            con = DriverManager.getConnection(url, user, dbPassword);
            
            
            String select = "SELECT * FROM reservation WHERE 'fromDate' BETWEEN ? AND ?;";
            
            st = con.prepareStatement(select);
            st.setString(1, fromDate);
            st.setString(2, toDate);
            ResultSet rs = st.executeQuery();
            
           int reservationID;
           String fDate,tDate,userUserName,hotelHotelName;
           
           while(rs.next()){
           reservationID = rs.getInt(1);
           fDate = rs.getString(2);
           tDate = rs.getString(3);
           userUserName = rs.getString(4);
           hotelHotelName = rs.getString(5);
           
           out.println(reservationID+" "+fDate+" "+tDate+" "+userUserName+" "+hotelHotelName);
           
           }
           




            


        --%>
        
   
    </body>
</html>
