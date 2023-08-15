<%-- 
    Document   : getRoomID
    Created on : 06-Jan-2021, 03:17:04
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validateRoomID(form){
                for (var i = 0; i < (form.elements.length - 1); i++)
                {
                       if (form.elements[i].value === "")
                    {
                        alert("Fill out all Fields");
                        document.roomID.originalID.focus();
                        return false;
                    }
                    if (!/^[0-9]*$/g.test(roomID.originalID.value)) {
                        alert("Enter numeric values in Room ID!");
                        return false;
                    }
                    return true;
                }
            };
            
            
        </script>
    </head>
    <body>
        <form action="getRoomID" method="Get" name="roomID" onsubmit="return validateRoomID(this)">
            <table border="1">
                <tr> 
                    <td> RoomID:</td>
                    <td><input type="number" name="originalID"  /></td>  
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="Enter" /></td>
                </tr>
            </table>
        </form>
        </body>
</html>
