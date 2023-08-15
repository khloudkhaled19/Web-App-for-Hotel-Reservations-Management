<%-- 
    Document   : getHotelName
    Created on : 06-Jan-2021, 04:59:19
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validateHotelName(form){
                for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if(form.elements[i].value == "")
                    {
                        alert("Fill out all Fields");
                        document.hotelName.hotelName.focus();
                        return false;
                        
                    }
                    if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.hotelName.hotelName.value)) {
                        alert("Enter alphabetic characters in room type!");
                        return false;
                    }
                return true;    
                }
                
                
            };
            
        </script>
    </head>
    <body>
        <form action="getHotelName" method="Get" name="hotelName" onsubmit="return validateHotelName(this)">
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
