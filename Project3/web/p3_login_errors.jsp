<%-- 
    Document   : p3_login_errors
    Created on : Nov 21, 2017, 7:20:01 PM
    Author     : TuanPhan
--%>


<%@ include file="p3_header.jsp" %> 

 <p>Sorry! username or password error</p> 
    <form action="LoginServlet" method="post">  
        <table border="0">
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
    <a href="p3_adminLogin.jsp">Login as Admin</a> 
        
<%@ include file="p3_footer.jsp" %> 

 
    


