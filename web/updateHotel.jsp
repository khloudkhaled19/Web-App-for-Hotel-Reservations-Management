<%-- 
    Document   : updateHotel
    Created on : 06-Jan-2021, 05:05:52
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validateUpdateHotel(form){
                for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if (form.elements[i].value === "")
                    {
                        alert("Fill out all Fields");
                        document.updateHotel.country.focus();
                        document.updateHotel.city.focus();
                        document.updateHotel.distance.focus();
                        document.updateHotel.meals.focus();
                        document.updateHotel.rate.focus();
                        document.updateHotel.stars.focus();
                        return false;
                        
                    }
                    
                    if(!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.updateHotel.country.value)){
                        alert("Enter alphabetic characters in country!");
                        return false;
                    }
                    if(!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.updateHotel.city.value)){
                        alert("Enter alphabetic characters in city!");
                        return false;
                    }
                    if(!/^[-+]?[0-9]+\.[0-9]+$/.test(updateHotel.dist.value) || !/^[0-9]*$/g.test(updateHotel.dist.value)){
                        alert("Enter numeric values in distance!");
                        return false;
                    } 
                    if(!/^[-+]?[0-9]+\.[0-9]+$/.test(updateHotel.rate.value) || !/^[0-9]*$/g.test(updateHotel.rate.value)){
                        alert("Enter numeric values in rate!");
                        return false;
                    } 
                    if(!/^[-+]?[0-9]+\.[0-9]+$/.test(updateHotel.stars.value) || !/^[0-9]*$/g.test(updateHotel.stars.value)){
                        alert("Enter numeric values in stars!");
                        return false;
                    }
                    if(!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.updateHotel.meals.value)){
                        alert("Enter alphabetic characters in meals!");
                        return false;
                    }
                    return true;
                    
                }
                
            };
            
        </script>
        
        <form action="updateHotel" method="Get" name="updateHotel" onsubmit="return validateUpdateHotel(this)">
            <table border="1">
                <tr> 
                    <td> Country:</td>
                    <td><input type="text" name="country"  /></td>  
                </tr>
                <tr> 
                    <td> City:</td>
                    <td><input type="text" name="city"  /></td>  
                </tr>
                <tr> 
                    <td> Distance:</td>
                    <td><input type="number" name="dist"  /></td>  
                </tr>
                <tr> 
                    <td> Meals:</td>
                    <td><input type="text" name="meals"  /></td>  
                </tr>
                <tr> 
                    <td> Stars:</td>
                    <td><input type="number" name="stars"  /></td>  
                </tr>
                <tr> 
                    <td> Rate:</td>
                    <td><input type="number" name="rate"  /></td>  
                </tr>
                
                <tr>
                    <td colspan="2"> <input type="submit" value="Enter" /></td>
                </tr>
            </table>
        </form>
    
    </body>
</html>
