/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;  


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TuanPhan
 */
public class LoginServlet extends HttpServlet {

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
            String name=null;
            String password=null;
            
            String username2 = (String)request.getAttribute("userName");
            String password2 = (String)request.getAttribute("password");
            
            if (username2 != null && password2 != null){
                name = username2;
                password=password2;
            }
            else {
                name=request.getParameter("username");  
                password=request.getParameter("password"); 
            }
            LoginBean bean=new LoginBean();  
            bean.setName(name);  
            bean.setPassword(password);  
            request.setAttribute("bean",bean);  

            LoginDao loginDao = new LoginDao();
            try {
                String userValidate = loginDao.authenticateUser(bean);
                if(userValidate.equals("true"))
                {   
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(10*60);
                    session.setAttribute("user", name);
                    request.setAttribute("userName", name);
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
                        request.getRequestDispatcher("/p3_userView.jsp").forward(request, response);
                     } 
                    catch (Exception e) {
                           e.printStackTrace();
                    }                    
                }
                else
                {
                    request.setAttribute("errMessage", userValidate);
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
