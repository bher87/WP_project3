package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import project3.DBConnection;

public final class p3_005fadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("     \n");
      out.write("    ");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
    
      out.write("\n");
      out.write("    <h2 align=\"center\"><font><strong>Retrieve data from database in jsp</strong></font></h2>\n");
      out.write("    <table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("\n");
      out.write("        </tr>\n");
      out.write("        <tr bgcolor=\"#A52A2A\">\n");
      out.write("            <td><b>id</b></td>\n");
      out.write("            <td><b>Body Style</b></td>\n");
      out.write("            <td><b>Mile</b></td>\n");
      out.write("            <td><b>Year</b></td>\n");
      out.write("            <td><b>State</b></td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            try{ 
                connection = DBConnection.createConnection();
                statement=connection.createStatement();
                String sql ="SELECT * FROM book";

                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
            
      out.write("\n");
      out.write("            <tr bgcolor=\"#DEB887\">\n");
      out.write("\n");
      out.write("                <td>");
      out.print(resultSet.getInt("isbn"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(resultSet.getString("title") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(resultSet.getString("author") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(resultSet.getInt("edition") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(resultSet.getInt("price") );
      out.write("</td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");
 
            }

            } catch (Exception e) {
                e.printStackTrace();
            }
            
      out.write("\n");
      out.write("            </table>\n");
      out.write("    <br/>\n");
      out.write("    <hr>\n");
      out.write("    \n");
      out.write("    <form  action=\"AdminServlet\" name=\"form\" method=\"post\">  \n");
      out.write("        <table border=\"0\"> ADD NEW BOOK TO SALE\n");
      out.write("            <tr> \n");
      out.write("                <td> ISBN: </td> \n");
      out.write("                <td><input type=\"text\" name=\"isbn\" /> </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr> \n");
      out.write("                <td> Title:  </td> \n");
      out.write("                <td><input type=\"text\" name=\"title\" /> </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> Author:  </td>\n");
      out.write("                <td><input type=\"text\" name=\"author\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> Edition: </td>\n");
      out.write("                <td><input type=\"text\" name=\"edition\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr> \n");
      out.write("                <td> Price: </td> \n");
      out.write("                <td><input type=\"text\" name=\"price\" /> </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><input type=\"submit\" class=\"\" name=\"action\" value=\"add\"/></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </form> \n");
      out.write("   \n");
      out.write(" \n");
      out.write("        \n");
      out.write("\n");
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
