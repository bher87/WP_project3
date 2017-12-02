/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TuanPhan
 */
public class LoginAdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
          /* For login purpose */
        String admin=null;  
        String password=null;
        
        String admin1=(String)request.getAttribute("admin1");  
        String password1=(String)request.getAttribute("password1");
        
        if(admin1 != null && password1 != null){
            admin = admin1;
            password = password1;
        }
        else {
            admin=request.getParameter("username");
            password=request.getParameter("password");
        }

        LoginBean bean=new LoginBean();  
        bean.setName(admin);  
        bean.setPassword(password);  
        request.setAttribute("bean",bean);  

        LoginAdminDao loginDao = new LoginAdminDao();
        try {
            String userValidate = loginDao.authenticateAdmin(bean);
            if(userValidate.equals("admin"))
            {   
                HttpSession session = request.getSession();                                          
                session.setMaxInactiveInterval(10*60);
                request.setAttribute("admin", admin);
                request.setAttribute("password", password);

                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;
                List<Bookbean> showBook = new ArrayList<Bookbean>();
                try{ 
                    connection = DBConnection.createConnection();
                    statement=connection.createStatement();
                    String sql ="SELECT * FROM book";

                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next()){
                        Bookbean book = new Bookbean();
                        book.setISBN(resultSet.getInt("isbn"));
                        book.setTitle(resultSet.getString("title")); 
                        book.setAuthor(resultSet.getString("author")); 
                        book.setEdition(resultSet.getInt("edition"));
                        book.setPrice(resultSet.getInt("price"));
                        showBook.add(book);
                }

//                        showBook.forEach((b) -> {
//                            System.out.println(b);
//                        });
                request.setAttribute("showBook",showBook);
                request.getRequestDispatcher("p3_admin_1.jsp").forward(request, response); 

            } 
            catch (Exception e) {
                   e.printStackTrace();
            }
        }
        else
        {
            request.setAttribute("err", userValidate);
            request.getRequestDispatcher("p3_login_errors.jsp").forward(request, response);
        }

        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
