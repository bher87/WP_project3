package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import project3.Bookbean;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import project3.DBConnection;
import project3.*;

public final class p3_005fuserView_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"p3_style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script> \n");
      out.write("            function validate()\n");
      out.write("            { \n");
      out.write("                var fullname = document.form.fullname.value;\n");
      out.write("                var username = document.form.username.value; \n");
      out.write("                var password = document.form.password.value;\n");
      out.write("                var confirmPassword= document.form.conpassword.value;\n");
      out.write("\n");
      out.write("                if (fullname==null || fullname==\"\")\n");
      out.write("                { \n");
      out.write("                    alert(\"Full Name cannot be blank\"); \n");
      out.write("                    return false; \n");
      out.write("                }\n");
      out.write("                else if (username==null || username==\"\")\n");
      out.write("                { \n");
      out.write("                    alert(\"Username cannot be blank\"); \n");
      out.write("                    return false; \n");
      out.write("                }\n");
      out.write("                else if(password.length<7)\n");
      out.write("                { \n");
      out.write("                    alert(\"Password must be at least 7 characters long.\"); \n");
      out.write("                    return false; \n");
      out.write("                } \n");
      out.write("                else if (password!=confirmPassword)\n");
      out.write("                { \n");
      out.write("                    alert(\"Confirm Password not match with the Password\"); \n");
      out.write("                    return false; \n");
      out.write("                } \n");
      out.write("             } \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrap\">\n");
      out.write("            <h1>Welcome to CSC 4370 Book Store </h1>\n");
      out.write("            <div class=\"navbarWrap navbar\" id=\"nav\"> \n");
      out.write("                <a href=\"p3_guestView.jsp\">Home</a>\n");
      out.write("                <a href=\"p3_login.jsp\">Login</a>\n");
      out.write("                <a href=\"p3_register.jsp\">Registration</a>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main\">\n");
      out.write("            <div class=\"wrap\">\n");
      out.write("   ");
      out.write("  \n");
      out.write(" \n");
      out.write("    <h3>Welcome ");
out.println(request.getAttribute("userName")); 
      out.write("</h3>\n");
      out.write("    <h2 align=\"center\"><font><strong>Retrieve data from database in jsp</strong></font></h2>\n");
      out.write("        <table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\n");
      out.write("        \n");
      out.write("            <tr bgcolor=\"#A52A2A\">\n");
      out.write("                <td><b>ISBN</b></td>\n");
      out.write("                <td><b>Title Style</b></td>\n");
      out.write("                <td><b>Author</b></td>\n");
      out.write("                <td><b>Edition</b></td>\n");
      out.write("                <td><b>Price</b></td>\n");
      out.write("                <td><b>Add To Card</b></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");
 List<Bookbean> showbook = (List<Bookbean>)request.getAttribute("showBook"); 
      out.write("\n");
      out.write("            ");
 Iterator it=showbook.iterator();
                while(it.hasNext())
            {
                Bookbean b=(Bookbean)it.next();
            
      out.write("    \n");
      out.write("                <form action=\"AddToCart\" method=\"post\">\n");
      out.write("     \n");
      out.write("                <td>");
      out.print(b.getISBN());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(b.getTitle() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(b.getAuthor() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(b.getEdition() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(b.getPrice() );
      out.write("</td>\n");
      out.write("                <input type=\"hidden\" name=\"isbn\" value=\"");
      out.print(b.getISBN());
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"title\" value=\"");
      out.print(b.getTitle() );
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"author\" value=\"");
      out.print(b.getAuthor() );
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"edition\" value=\"");
      out.print(b.getEdition() );
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"price\" value=\"");
      out.print(b.getPrice() );
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"username\" value=\"");
      out.print(request.getAttribute("userName") );
      out.write("\">\n");
      out.write("                <td><input type=\"submit\" value=\"Add To Card\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            </form>\n");
      out.write("            ");
 }  
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("    <div style=\"text-align:center\"> \n");
      out.write("        <form action=\"/p3_checkout.jsp\">\n");
      out.write("            <input alignment=\"center\" type=\"submit\" name=\"submit\" value=\"Proceed to Check-out\"/> \n");
      out.write("               </form>\n");
      out.write("    </div> \n");
      out.write("\n");
      out.write("  ");
      out.write("\n");
      out.write("\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("        <div class=\"wrapFooter\">\n");
      out.write("            <h2>Let's Keep in Touch!</h2>\n");
      out.write("                <p> Phone Number: (678) 818-8933 <br/>\n");
      out.write("                Email: tphan36@student.gsu.edu <br/>\n");
      out.write("                </p>\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
