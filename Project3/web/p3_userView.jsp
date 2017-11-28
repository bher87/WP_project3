<%-- 
    Document   : p3_login
    Created on : Nov 21, 2017, 6:16:00 PM
    Author     : TuanPhan
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="project3.DBConnection" %>

<%@ include file="p3_header.jsp" %>  
    <%
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
    %>
    <h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="#A52A2A">
                <td><b>id</b></td>
                <td><b>Body Style</b></td>
                <td><b>Miles(K)</b></td>
                <td><b>Year</b></td>
                <td><b>Price(K)</b></td>
                <td><b>Add To Card</b></td>
            </tr>
            <%
            try{ 
                connection = DBConnection.createConnection();
                statement=connection.createStatement();
                String sql ="SELECT * FROM book";

                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
            %>
            <form action="AddToCart" method="post">
            <tr>
                <td><%=resultSet.getInt("isbn")%></td>
                <td><%=resultSet.getString("title") %></td>
                <td><%=resultSet.getString("author") %></td>
                <td><%=resultSet.getInt("edition") %></td>
                <td><%=resultSet.getInt("price") %></td>
                <input type="hidden" name="isbn" value="+<%=resultSet.getInt("isbn") %>">
                <input type="hidden" name="title" value="<%=resultSet.getString("title") %>">
                <input type="hidden" name="author" value="<%=resultSet.getString("author") %>">
                <input type="hidden" name="edition" value="<%=resultSet.getInt("edition") %>">
                <input type="hidden" name="price" value="<%=resultSet.getInt("price") %>">
                <td><input type="submit" value="Add To Card"/></td>
            </tr>
            </form>
            <% }

            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
    

    </table>
    <div style="text-align:center">  
        <input alignment="center" type="submit" name="submit" value="Proceed to Check-out" 
    </div> 

  <%@ include file="p3_footer.jsp" %> 
        

