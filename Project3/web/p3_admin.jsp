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
            <td><b>ISBN</b></td>
            <td><b>Title Style</b></td>
            <td><b>Author</b></td>
            <td><b>Edition</b></td>
            <td><b>Price</b></td>
        </tr>
        <%
            try{ 
                connection = DBConnection.createConnection();
                statement=connection.createStatement();
                String sql ="SELECT * FROM book";

                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
            %>
            <tr bgcolor="#DEB887">

                <td><%=resultSet.getInt("isbn")%></td>
                <td><%=resultSet.getString("title") %></td>
                <td><%=resultSet.getString("author") %></td>
                <td><%=resultSet.getInt("edition") %></td>
                <td><%=resultSet.getInt("price") %></td>

            </tr>

            <% 
            }

            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
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
                <td><input type="submit" class="" name="action" value="add"/></td>
            </tr>
        </table>
    </form> 
   
 
        

