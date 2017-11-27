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
    <form action="" method="post">
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
                String sql ="SELECT * FROM corvettes";

                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
            %>
            <tr bgcolor="" id="+ <%=resultSet.getInt("Vette_id") %> +">
                <td><%=resultSet.getInt("Vette_id") %></td>
                <td><%=resultSet.getString("Body_Style") %></td>
                <td><%=resultSet.getFloat("Miles") %></td>
                <td><%=resultSet.getInt("Year") %></td>
                <td><%=resultSet.getInt("State") %></td>
                <td><input type="submit" name="addtocart+<%= resultSet.getInt("Vette_id") %> +" value="Add To Card"/></td>
            </tr>
            <% 
            }

            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
    </form>

    </table>
    <div style="text-align:center">  
        <input alignment="center" type="submit" name="submit" value="Proceed to Check-out" 
    </div> 

  <%@ include file="p3_footer.jsp" %> 
        

