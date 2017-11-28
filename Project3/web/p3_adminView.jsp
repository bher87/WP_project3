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
    <%
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
    %>
    
<h2 align="center"><font><strong>Administrator Dashboard</strong></font></h2>
    <h3>Inventory</h3>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr bgcolor="#A52A2A">
            <th>ID</th> 
            <th>ISBN</th> 
            <th>Title</th> 
            <th>Author</th> 
            <th>Edition</th> 
            <th>Price</th> 
            <th>Quantity</th>
        </tr>
        <%
        try{ 
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM inventory";
            resultSet = statement.executeQuery(sql);
            PrintWriter display1 = response.getWriter();
            while(resultSet.next()){
                display1.println("<tr><td>" + resultSet.getInt("id") + "</td><td>" + resultSet.getString("ISBN") + "</td><td>" + resultSet.getString("title") + "</td><td>" + resultSet.getString("author") + "</td><td>" + resultSet.getString("edition") + "</td><td>$ " + resultSet.getString("price") + "</td><td>" + resultSet.getInt("quantity") + "</td></tr>");
            }
            resultSet.close();
            display1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </table>
    
    <h3>Users</h3>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr bgcolor="#A52A2A">
            <th>ID</th> 
            <th>Role</th> 
            <th>Username</th> 
            <th>Password</th> 
            <th>First Name</th> 
            <th>Last Name</th> 
            <th>Billing Info</th>
        </tr>
        <%
        try{ 
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            resultSet = statement.executeQuery(sql);
            PrintWriter display2 = response.getWriter();
            while(resultSet.next()){
                display2.println("<tr><td>" + resultSet.getInt("id") + "</td><td>" + resultSet.getString("role") + "</td><td>" + resultSet.getString("username") + "</td><td>" + resultSet.getString("pword") + "</td><td>" + resultSet.getString("firstname") + "</td><td>" + resultSet.getString("lastname") + "</td><td>" + resultSet.getString("billinginfo") + "</td></tr>");
            }
            resultSet.close();
            display2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </table>
    
    <h3>Product Shipping Tracker</h3>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr bgcolor="#A52A2A">
            <th>ID</th> 
            <th>ISBN</th> 
            <th>Username</th> 
        </tr>
        <%
        try{ 
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM tracking";
            resultSet = statement.executeQuery(sql);
            PrintWriter display3 = response.getWriter();
            while(resultSet.next()){
                display3.println("<tr><td>" + resultSet.getInt("id") + "</td><td>" + resultSet.getString("ISBN") + "</td><td>" + resultSet.getString("userID") +"</td></tr>");
            }
            resultSet.close();
            display3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </table>
  <%@ include file="p3_footer.jsp" %> 
            
    