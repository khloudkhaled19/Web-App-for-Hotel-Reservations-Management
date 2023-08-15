<%-- 
    Document   : adminView
    Created on : 03-Jan-2021, 19:33:50
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver").newInstance();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        input
        {padding: 14px 40px; width: 250px;}

    </style>
    <%@ include file = "navbar.jsp" %>
    <body>
        <div style="margin: 100px 75px 75px 100px">
            <center>
                <form action="reservationsList" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="View Reservations List"/></td>
                        </tr>

                    </table>
                </form>

                <form action="reservationsHistory.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="View Reservations History" /></td>
                        </tr>

                    </table>
                </form> 

                <form action="searchClient.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Search"/></td>
                        </tr>

                    </table>
                </form> 

                <form action="addRoom.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Add Room Info"/></td>
                        </tr>
                    </table>
                </form> 

                <form action="getRoomID.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Update Room Info" /></td>
                        </tr>
                    </table>
                </form> 
                <form action="getHotelName.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Update Hotel Info" /></td>
                        </tr>
                    </table>
                </form> 
                <form action="hotelReview.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="View Hotel Review" /></td>
                        </tr>
                    </table>
                </form> 

                <form action="payment.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Check Payment"  /></td>
                        </tr>
                    </table>
                </form> 
                <form action="checkout" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Check-Out" /></td>
                        </tr>
                    </table>
                </form> 

                <form action="cancel.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Cancel Reservation"/></td>
                        </tr>
                    </table>
                </form> 

                <form action="upload.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Upload New Photos" /></td>
                        </tr>
                    </table>
                </form> 

                <form action="notifyUser.jsp" method="Get">
                    <table border="1">
                        <tr>
                            <td colspan="2"> <input type="submit" value="Send Notification"/></td>
                        </tr>
                    </table>
                </form> 
            </center>
        </div>
    </body>
    <%@ include file = "footer.jsp" %>
</html>
