<%-- 
    Document   : p3_login
    Created on : Nov 21, 2017, 6:16:00 PM
    Author     : TuanPhan
--%>

<%@ include file="p3_header.jsp" %> 
    <form action="LoginAdminServlet" name="admin" method="post">  
        <table border="0"> 
            <caption><h2>Admin Login</h2></caption>
            <tr> 
                <td> Username: </td> 
                <td><input type="text" name="username" /> </td>
            </tr>
            <tr>
                <td> Password: </td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" class="" name="action" value="Login"/></td>
            </tr>
        </table>
    </form> 
 
        
<%@ include file="p3_footer.jsp" %> 
