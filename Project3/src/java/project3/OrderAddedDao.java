/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TuanPhan
 */
package project3;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class OrderAddedDao {
 
public String addCustomer(OrderBean bean)
{
    String book = bean.getBook();
    String customer = bean.getCustomer();
    int price = bean.getPrice();
    int isbn = bean.getISBN();
 
    Connection con = null;
    PreparedStatement statement = null;

    try
    {
        con = DBConnection.createConnection();
        String query = "INSERT INTO sale (isbn, buyBook, price, customer) VALUES (?,?,?,?)";
        statement = con.prepareStatement(query);
        statement.setInt(1, isbn);
        statement.setString(2, book);
        statement.setInt(3, price);
        statement.setString(4, customer);
        
        int i = statement.executeUpdate();
        if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 

    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return "Invalid";
    }

}
