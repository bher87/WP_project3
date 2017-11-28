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
 
public class AddBookDao {
 
public String addBook(Bookbean bean)
{
    int isbn = bean.getISBN(); 
    String title = bean.getTitle();
    String author = bean.getAuthor();
    int edition = bean.getEdition(); 
    int price = bean.getPrice(); 
 
    Connection con = null;
    PreparedStatement statement = null;

    try
    {
        con = DBConnection.createConnection();
        String query = "INSERT INTO book (isbn,title, author, edition, price) VALUES (?,?,?,?,?)";
        statement = con.prepareStatement(query);
        statement.setInt(1, isbn);
        statement.setString(2, title);
        statement.setString(3, author);
        statement.setInt(4, edition);
        statement.setInt(5, price);
        
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
