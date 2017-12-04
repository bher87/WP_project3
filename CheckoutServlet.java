/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class CheckoutServlet extends HttpServlet {

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
            String name=request.getParameter("username");
            String password=request.getParameter("password"); 
            
            try {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("user", name);
                request.setAttribute("userName", name);
                request.setAttribute("password", password);

                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;
                List<OrderBean> cart = new ArrayList<OrderBean>();
                try{ 
                    connection = DBConnection.createConnection();
                    
                    PreparedStatement st;
                    st = connection.prepareStatement("SELECT * FROM cart WHERE customer=?");
                    st.setString(1, name);
                    
                    int price =0;
                    int total =0;
                    ResultSet rs=st.executeQuery();
                    while(rs.next()){
                        OrderBean book = new OrderBean();
                        book.setISBN(rs.getInt("isbn"));
                        book.setBook(rs.getString("buyBook"));
                        price = rs.getInt("price");
                        book.setPrice(price); 
                        book.setCustomer(rs.getString("customer"));
                        cart.add(book);
                        total += price;
                    }

//                        showBook.forEach((b) -> {
//                            System.out.println(b);
//                        });
                    request.setAttribute("cart",cart);
                    request.setAttribute("total",total);
                    request.getRequestDispatcher("p3_checkout.jsp").forward(request, response);
                 } 
                catch (Exception e) {
                       e.printStackTrace();
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
