<%-- 
    Document   : notifyUser
    Created on : 09-Jan-2021, 03:03:10
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
           function validateNotify(form){
               for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if (form.elements[i].value === "")
                    {
                        
                        alert("Fill out all Fields");
                        document.notify.username.focus();
                        return false;
                    }
                        
                     if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.notify.username.value)) {
                        alert("Enter alphabetic characters in username!");
                        return false;
                    }
                           return true;
                }
               
           };  
            
        </script>
    </head>
    <body>
        <form action="Notify" method="Get" name="notify" onsubmit="return validateNotify(this)">
            <table border="1">
                <tr> 
                    <td> Username:</td>
                    <td><input type="text" name="username"  /></td>  
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="Send" /></td>
                </tr>
            </table>
        </form>
                </body>
                </html>
