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
            <td><b>id</b></td>
            <td><b>Body Style</b></td>
            <td><b>Mile</b></td>
            <td><b>Year</b></td>
            <td><b>State</b></td>
        </tr>
        <%
            try{ 
                connection = DBConnection.createConnection();
                statement=connection.createStatement();
                String sql ="SELECT * FROM corvettes";

                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
            %>
            <tr bgcolor="#DEB887">

                <td><%=resultSet.getInt("Vette_id") %></td>
                <td><%=resultSet.getString("Body_Style") %></td>
                <td><%=resultSet.getFloat("Miles") %></td>
                <td><%=resultSet.getInt("Year") %></td>
                <td><%=resultSet.getInt("State") %></td>

            </tr>

            <% 
            }

            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
            </table>
   
 
        

