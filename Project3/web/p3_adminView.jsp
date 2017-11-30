<%-- 
    Document   : p3_adminView
    Created on : Nov 28, 2017, 1:11:43 AM
    Author     : hkwok1
    The Java code in this file should probably be somewhere else because this is the file for the view.
    Maybe there could be a separate file for each part (adminModel, adminController, adminView), and maybe do the same
    for user (and maybe guest) as well.
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="project3.DBConnection" %>
<%@page import="java.io.*"%>

<%@ include file="p3_header.jsp" %>  

<h2 align="center"><font><strong>Administrator Dashboard</strong></font></h2>
    <jsp:useBean id = "book1" class = "project3.Bookbean"/>
    <h3>Inventory</h3>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr bgcolor="#A52A2A">
            <th>ISBN</th> 
            <th>Title</th> 
            <th>Author</th> 
            <th>Edition</th> 
            <th>Price</th>
        </tr>
        <tr>
            <td><jsp:getProperty name = "book1" property = "isbn"/></td><td><jsp:getProperty name = "book1" property = "title"/></td><td><jsp:getProperty name = "book1" property = "author"/></td><td><jsp:getProperty name = "book1" property = "edition"/></td><td><jsp:getProperty name = "book1" property = "price"/></td>
        </tr>
    </table>

    <h3>Sales Records</h3>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr bgcolor="#A52A2A">
            <th>Title</th> 
            <th>Price</th> 
            <th>Username</th> 
        </tr>
        <tr>
            <jsp:useBean id = "user1" class = "project3.LoginBean"/>
            <td><jsp:getProperty name = "book1" property = "title"/></td><td><jsp:getProperty name = "book1" property = "price"/></td><td><jsp:getProperty name = "user1" property = "username"/></td>
        </tr>
    </table>
    
  <%@ include file="p3_footer.jsp" %> 
            
    