<%-- 
    Document   : p3_login_sucess
    Created on : Nov 21, 2017, 7:19:43 PM
    Author     : TuanPhan
--%>
<%@page import="project3.LoginBean" %>  
<%@ include file="p3_header.jsp" %> 

    <%  
        LoginBean bean=(LoginBean)request.getAttribute("bean");  
        out.print("Welcome, "+bean.getName());  
    %> 
    <%@ include file="p3_userView.jsp" %>
        
<%@ include file="p3_footer.jsp" %> 

