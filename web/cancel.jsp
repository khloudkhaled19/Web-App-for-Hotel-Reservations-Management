<%-- 
    Document   : cancel
    Created on : 09-Jan-2021, 02:08:29
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="cancelReservation" method="Get">
            <table border="1">
                <tr> 
                    <td> Room ID:</td>
                    <td><input type="number" name="RoomsID"  /></td>  
                </tr>
                <tr> 
                    <td> Reservation ID:</td>
                    <td><input type="number" name="reservationID"  /></td>  
                </tr>
                <tr> 
                    <td> From Date:</td>
                    <td><input type="text" name="FromDate"  /></td>  
                </tr>
                
                
                <tr>
                    <td colspan="2"> <input type="submit" value="Check" /></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
