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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import project3.LoginServlet;

/**
 *
 * @author TuanPhan
 */
public class AddToCart extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        Cart shoppingCart;
        shoppingCart = (Cart) session.getAttribute("Cart");
        if(shoppingCart == null){
          shoppingCart = new Cart();
          session.setAttribute("shop", shoppingCart);
        }
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        shoppingCart.addToCart(title, price);
        session.setAttribute("shop", shoppingCart);
        
        String username=request.getParameter("username");

        

     //   request.getAtribute("userName");  

 
        Connection con = null;
      //  Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preStatement = null;

        try
        {
            con = DBConnection.createConnection();
            String query = "INSERT INTO sale (buyBook, price, customer) VALUES (?,?,?)";
            preStatement = con.prepareStatement(query);           
            preStatement.setString(1, title);
            preStatement.setInt(2, price);
            preStatement.setString(3, username);
        
            preStatement.executeUpdate();
           
            

//            while(resultSet.next())
//            {
//
//
//            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        int total=0;
        request.setAttribute("item",shoppingCart);
//        HashMap<String, Integer> items = shoppingCart.getItems();       
        request.getRequestDispatcher("/p3_checkout.jsp").forward(request, response);
//        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>result</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Book successfully added to cart </h1>");
//            out.println("<hr>");
//            out.println("<h2>REVIEW BEFORE CHECKOUT</h2>");
//            out.println("<tr><td>Book Title </td><td>Price</td></tr>");
//            
//
//            out.println("<table border='1px'>");
//             
//            for(String key: items.keySet()){
//                out.println("<tr><td>"+key+" </td><td>"+"$"+items.get(key)+"</td></tr>");
//                total += items.get(key);
//            }
//            
//            out.println("</table>");
//            out.println("<hr>");
//            out.println("Total: "+"$"+ total);
//            out.println("<br/>");
//            out.println("<br/>");
//            out.println("<form action='p3_userView.jsp'>"
//                    + "<input type='submit' value='Continue Shopping'>"
//                    + "</form>");
//            out.println("<form action='p3_pay.jsp'>"
//                    + "<input type='submit' value='Pay'>"
//                    + "</form>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
