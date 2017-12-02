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
<%@page import="project3.*" %>


<%@ include file="p3_header.jsp" %>  
 
    <h3>Welcome <%out.println(request.getAttribute("userName")); %></h3>
    <h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
        
            <tr bgcolor="#A52A2A">
                <td><b>ISBN</b></td>
                <td><b>Title Style</b></td>
                <td><b>Author</b></td>
                <td><b>Edition</b></td>
                <td><b>Price</b></td>
                <td><b>Add To Card</b></td>
            </tr>
            
            <% List<Bookbean> showbook = (List<Bookbean>)request.getAttribute("showBook"); %>
            <% Iterator it=showbook.iterator();
                while(it.hasNext())
            {
                Bookbean b=(Bookbean)it.next();
            %>    
            <form action="OrderServlet" method="post">
            <tr>
                <td><%=b.getISBN()%></td>
                <td><%=b.getTitle() %></td>
                <td><%=b.getAuthor() %></td>
                <td><%=b.getEdition() %></td>
                <td><%=b.getPrice() %></td>
                <input type="hidden" name="isbn" value="<%=b.getISBN()%>">
                <input type="hidden" name="title" value="<%=b.getTitle() %>">
                <input type="hidden" name="author" value="<%=b.getAuthor() %>">
                <input type="hidden" name="edition" value="<%=b.getEdition() %>">
                <input type="hidden" name="price" value="<%=b.getPrice() %>">
                <input type="hidden" name="username" value="<%=request.getAttribute("userName") %>">
                <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
                <td><input type="submit" value="Add To Card"/></td>
            </tr>
            </form>
            <% }  %>
            

            </table>
    <div style="text-align:center"> 
        <form action="CheckoutServlet" method="post">
            <input type="hidden" name="username" value="<%=request.getAttribute("userName") %>">
            <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
            <input alignment="center" type="submit" name="submit" value="Proceed to Check-out"/> 
        </form>
    </div> 

  <%@ include file="p3_footer.jsp" %> 
        

