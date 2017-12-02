<%-- 
    Document   : p3_login
    Created on : Nov 21, 2017, 6:16:00 PM
    Author     : TuanPhan
--%>


    <%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="project3.Bookbean"%>
<%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.Statement"%>
    <%@page import="java.sql.Connection"%>
    <%@page import="java.sql.*"%>
    <%@page import="project3.DBConnection" %>
    
    <%@ include file="p3_header.jsp" %> 
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
            <% }  %>
    </table>
<%@ include file="p3_footer.jsp" %> 

 
        

