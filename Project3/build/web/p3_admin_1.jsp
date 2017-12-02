<%-- 
    Document   : p3_login
    Created on : Nov 21, 2017, 6:16:00 PM
    Author     : TuanPhan
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="project3.Bookbean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="project3.DBConnection" %>
    
    
    <h2>Admin Area</h2>
    <h4>Welcome <%out.println(request.getAttribute("admin")); %></h4>
    <h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
        
            <tr bgcolor="#A52A2A">
                <td><b>ISBN</b></td>
                <td><b>Title Style</b></td>
                <td><b>Author</b></td>
                <td><b>Edition</b></td>
                <td><b>Price</b></td>
            </tr>
            
            <% List<Bookbean> showbook = (List<Bookbean>)request.getAttribute("showBook"); %>
            <% Iterator it=showbook.iterator();
                while(it.hasNext())
            {
                Bookbean b=(Bookbean)it.next();
            %>    
            <tr>
                <td><%=b.getISBN()%></td>
                <td><%=b.getTitle() %></td>
                <td><%=b.getAuthor() %></td>
                <td><%=b.getEdition() %></td>
                <td><%=b.getPrice() %></td>
            </tr>
            <% } %>
        </table>
    <br/>
    <hr>
    
    <form  action="AdminServlet" name="form" method="post">  
        <table border="0"> ADD NEW BOOK TO SALE
            <tr> 
                <td> ISBN: </td> 
                <td><input type="text" name="isbn" /> </td>
            </tr>
            <tr> 
                <td> Title:  </td> 
                <td><input type="text" name="title" /> </td>
            </tr>
            <tr>
                <td> Author:  </td>
                <td><input type="text" name="author"/></td>
            </tr>
            <tr>
                <td> Edition: </td>
                <td><input type="text" name="edition"/></td>
            </tr>
            <tr> 
                <td> Price: </td> 
                <td><input type="text" name="price" /> </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="admin" value="<%=request.getAttribute("admin") %>">
                    <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
                    <input type="submit" class="" name="action" value="add"/>
                </td>          
            </tr>
        </table>
    </form> 
                    
    <form action="SeeOrderServlet" method="post">
        <input type="hidden" name="username" value="<%=request.getAttribute("admin") %>">
        <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
        <input type="submit" value="Check On Customer Order"/>
    </form>
   
 
        

