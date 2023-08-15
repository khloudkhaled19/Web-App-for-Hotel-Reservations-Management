<%-- 
    Document   : addRoom
    Created on : 05-Jan-2021, 04:09:14
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver").newInstance();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> <% ///^[-+]?[0-9]+\.[0-9]+$/ for decimal %>
        <script>
            function validateAddRoom(form) {
                for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if (form.elements[i].value === "")
                    {
                        alert("Fill out all Fields");
                        document.addRoom.roomID.focus();
                        document.addRoom.type.focus();
                        document.addRoom.fac.focus();
                        document.addRoom.price.focus();
                        document.addRoom.date.focus();
                        document.addRoom.hotel.focus();
                        return false;
                    }

                    if (!/^[0-9]*$/g.test(addRoom.roomID.value)) {
                        alert("Enter numeric values in Room ID!");
                        return false;
                    }
                    if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.addRoom.type.value)) {
                        alert("Enter alphabetic characters in room type!");
                        return false;
                    }
                    if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.addRoom.fac.value)) {
                        alert("Enter alphabetic characters in room facilities!");
                        return false;
                    }
                    if (!/^[0-9]*$/g.test(addRoom.price.value)) {
                        alert("Enter numeric values in Price!");
                        return false;
                    }

                    if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.addRoom.hotel.value)) {
                        alert("Enter alphabetic characters in room hotel name!");
                        return false;
                    }
                    if (!/^(\d{4})-(\d{1,2})-(\d{1,2})$/.test(document.addRoom.date.value) && /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.addRoom.date.value)) {
                        alert("Enter the date in this format yy-mm-dd and don't type a text!");
                        return false;
                    }



                    return true;
                }
            }
            ;

        </script>
    </head>
    <body>
        <form action="addRoom" method="Get" name="addRoom" onsubmit="return validateAddRoom(this)">
            <table border="1">
                <tr> 
                    <td> RoomID:</td>
                    <td><input type="number" name="roomID"  /></td>  
                </tr>
                <tr> 
                    <td> Room type:</td>
                    <td><input type="text" name="type"  /></td>  
                </tr>
                <tr> 
                    <td> Facilities:</td>
                    <td><input type="text" name="fac"  /></td>  
                </tr>
                <tr> 
                    <td> Price:</td>
                    <td><input type="text" name="price"  /></td>  
                </tr>
                <tr> 
                    <td> Availability date:</td>
                    <td><input type="text" name="date"  /></td>  
                </tr>
                <tr> 
                    <td> Hotel name:</td>
                    <td><input type="text" name="hotel"  /></td>  
                </tr>

                <tr>
                    <td colspan="2"> <input type="submit" value="Add" /></td>
                </tr>
            </table>

            <%--
          <%
          int roomID = Integer.parseInt(request.getParameter("roomID"));
          String type = request.getParameter("type");
          String facilities = request.getParameter("fac");
          String price = request.getParameter("price");
          String availabilityDate = request.getParameter("date");
          String hotel = request.getParameter("hotel");
          
          //int counter = Integer.parseInt(request.getParameter("counter"));
          
          Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            con = DriverManager.getConnection(url, user, dbPassword);
            
            String add = "INSERT INTO `rooms`(`RoomsID`, `RoomType`, `RoomFacilities`, `RoomPrice`, `availabilityDate`, `Hotel_HotelName`) VALUES ("
                         + "'" + roomID + "',"
                         + "'" + type + "',"
                         + "'" + facilities + "',"
                         + "'" + price + "',"
                         + "'" + availabilityDate + "',"
                         + "'" + hotel + "')";
            
          st = con.prepareStatement(add);
          int row = st.executeUpdate();
          //ResultSet rs = st.executeQuery();
          
         
        %>
            --%>

        </form>



    </body>
</html>
