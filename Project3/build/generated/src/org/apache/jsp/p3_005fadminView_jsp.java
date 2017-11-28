package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import project3.DBConnection;
import java.io.*;

public final class p3_005fadminView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/p3_header.jsp");
    _jspx_dependants.add("/p3_footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link href=\"p3_style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <script> \r\n");
      out.write("            function validate()\r\n");
      out.write("            { \r\n");
      out.write("                var fullname = document.form.fullname.value;\r\n");
      out.write("                var username = document.form.username.value; \r\n");
      out.write("                var password = document.form.password.value;\r\n");
      out.write("                var conpassword= document.form.conpassword.value;\r\n");
      out.write("\r\n");
      out.write("                if (fullname==null || fullname==\"\")\r\n");
      out.write("                { \r\n");
      out.write("                    alert(\"Full Name can't be blank\"); \r\n");
      out.write("                    return false; \r\n");
      out.write("                }\r\n");
      out.write("                else if (username==null || username==\"\")\r\n");
      out.write("                { \r\n");
      out.write("                    alert(\"Username can't be blank\"); \r\n");
      out.write("                    return false; \r\n");
      out.write("                }\r\n");
      out.write("                else if(password.length<6)\r\n");
      out.write("                { \r\n");
      out.write("                    alert(\"Password must be at least 6 characters long.\"); \r\n");
      out.write("                    return false; \r\n");
      out.write("                } \r\n");
      out.write("                else if (password!=conpassword)\r\n");
      out.write("                { \r\n");
      out.write("                    alert(\"Confirm Password should match with the Password\"); \r\n");
      out.write("                    return false; \r\n");
      out.write("                } \r\n");
      out.write("             } \r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"wrap\">\r\n");
      out.write("            <h1>Welcome to CSC 4370 Book Store </h1>\r\n");
      out.write("            <div class=\"navbarWrap navbar\" id=\"nav\"> \r\n");
      out.write("                <a href=\"p3_guestView.jsp\">Home</a>\r\n");
      out.write("                <a href=\"p3_login.jsp\">Login</a>\r\n");
      out.write("                <a href=\"p3_register.jsp\">Registration</a>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"main\">\r\n");
      out.write("            <div class=\"wrap\">\r\n");
      out.write("   ");
      out.write("  \n");
      out.write("    ");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
    
      out.write("\n");
      out.write("    \n");
      out.write("<h2 align=\"center\"><font><strong>Administrator Dashboard</strong></font></h2>\n");
      out.write("    <h3>Inventory</h3>\n");
      out.write("    <table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\n");
      out.write("        <tr bgcolor=\"#A52A2A\">\n");
      out.write("            <th>ID</th> \n");
      out.write("            <th>ISBN</th> \n");
      out.write("            <th>Title</th> \n");
      out.write("            <th>Author</th> \n");
      out.write("            <th>Edition</th> \n");
      out.write("            <th>Price</th> \n");
      out.write("            <th>Quantity</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("    <h3>Users</h3>\n");
      out.write("    <table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\n");
      out.write("        <tr bgcolor=\"#A52A2A\">\n");
      out.write("            <th>ID</th> \n");
      out.write("            <th>Role</th> \n");
      out.write("            <th>Username</th> \n");
      out.write("            <th>Password</th> \n");
      out.write("            <th>First Name</th> \n");
      out.write("            <th>Last Name</th> \n");
      out.write("            <th>Billing Info</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("    <h3>Product Shipping Tracker</h3>\n");
      out.write("    <table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\n");
      out.write("        <tr bgcolor=\"#A52A2A\">\n");
      out.write("            <th>ID</th> \n");
      out.write("            <th>ISBN</th> \n");
      out.write("            <th>Username</th> \n");
      out.write("        </tr>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("  ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        <div class=\"wrapFooter\">\r\n");
      out.write("            <h2>Let's Keep in Touch!</h2>\r\n");
      out.write("                <p> Phone Number: (678) 818-8933 <br/>\r\n");
      out.write("                Email: tphan36@student.gsu.edu <br/>\r\n");
      out.write("                </p>\r\n");
      out.write("            </p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
      out.write(" \n");
      out.write("            \n");
      out.write("    ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
