<%-- 
    Document   : p3_login
    Created on : Nov 21, 2017, 6:16:00 PM
    Author     : TuanPhan
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="project3.OrderBean"%>
<%@page import="project3.Cart"%>
<%@page import="java.util.HashMap"%>
<%@ include file="p3_header.jsp" %> 
    <h1>Book successfully added to cart </h1>
    <hr>
    <h3>Shopping Cart,  <%out.println(request.getAttribute("userName")); %></h3>
    <h2>REVIEW BEFORE CHECKOUT</h2>
    <h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
        
            <tr bgcolor="#A52A2A">
                <td><b>ISBN</b></td>
                <td><b>Book</b></td>
                <td><b>Price</b></td>
            </tr>
            
            <% List<OrderBean> cart = (List<OrderBean>)request.getAttribute("cart"); %>
            <% Iterator it=cart.iterator();
                while(it.hasNext())
            {
                OrderBean o=(OrderBean)it.next();
            %>    
           
            <tr>
                <td><%=o.getISBN()%></td>
                <td><%=o.getBook() %></td>
                <td><%=o.getPrice() %></td>
                <input type="hidden" name="username" value="<%=request.getAttribute("userName") %>">
                <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
                
            </tr>
            
            <% }  %>
            </table>
    <hr/>
    <h4>Total: $<%=request.getAttribute("total") %> </h4>
    <form action="LoginServlet" method="post">
        <input type="hidden" name="username" value="<%=request.getAttribute("userName") %>">
        <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
        <input type="submit" value="Continue Shopping"/>
    </form>
    <form action="PlaceOrderServlet" method="post">
        <input type="hidden" name="username" value="<%=request.getAttribute("userName") %>">
        <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
        <input type="submit" value="Place Your Order"/>
    </form>

    
    
        
<%@ include file="p3_footer.jsp" %> 
