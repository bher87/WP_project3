<%-- 
    Document   : p3_login_sucess
    Created on : Nov 21, 2017, 7:19:43 PM
    Author     : TuanPhan
--%>
<%@page import="project3.LoginBean" %>  
<%@ include file="p3_header.jsp" %> 

    
    <h2>Your order has been placed</h2>
    <br/><br/>
    <form action="LoginServlet" method="post">
        <input type="hidden" name="username" value="<%=request.getAttribute("userName") %>">
        <input type="hidden" name="password" value="<%=request.getAttribute("password") %>">
        <input type="submit" value="Continue Shopping"/>
    </form>
 
        
<%@ include file="p3_footer.jsp" %> 

