<%-- 
    Document   : hotelReview
    Created on : 07-Jan-2021, 01:08:12
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
            function validateReview(form){
                for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if (form.elements[i].value === "")
                    {
                        alert("Fill out all Fields");
                        document.review.hotelName.focus();
                        return false;
                    }
                    if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.review.hotelName.value)) {
                        alert("Enter alphabetic characters in hotel name!");
                        return false;
                    }
                                       
                   return true;
                    
                }
                
            };
            
            
        </script>
    </head>
    <body>
        <form action="validateReview.jsp" method="Get" name="review" onsubmit="return validateReview(this)">
            <table border="1">
                <tr> 
                    <td> Hotel Name:</td>
                    <td><input type="text" name="hotelName"  /></td>  
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="Enter" /></td>
                </tr>
            </table>
        </form>
        
        
        
        
    </body>
</html>
