<%-- 
    Document   : p3_login
    Created on : Nov 21, 2017, 6:16:00 PM
    Author     : TuanPhan
--%>

<%@ include file="p3_header.jsp" %>
    <form  action="RegisterServlet" name="form" method="post" onsubmit="return validate()">  
        <table border="0">
            <tr> 
                <td> Full Name: </td> 
                <td><input type="text" name="fullname" /> </td>
            </tr>
            <tr> 
                <td> Username: </td> 
                <td><input type="text" name="username" /> </td>
            </tr>
            <tr>
                <td> Password: </td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td> Confirm Password: </td>
                <td><input type="password" name="conpassword"/></td>
            </tr>
            <tr>
                <td><input type="submit" class="" name="action" value="Login"/></td>
            </tr>
        </table>
    </form> 
        
<%@ include file="p3_footer.jsp" %> 
