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
 
public class RegisterDao {
    public String register(RegisterBean bean) {
        String fullname = bean.getFullname(); 
        String username = bean.getUsername();
        String password = bean.getPassword();
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DBConnection.createConnection();
            String query = "INSERT INTO user (id,fullname, username,password) VALUES (NULL,?,?,?)";
            statement = con.prepareStatement(query);
            statement.setString(1, fullname);
            statement.setString(2, username);
            statement.setString(3, password);
            int i = statement.executeUpdate();
            if (i!=0) { //Just to ensure data has been inserted into the database
                return "SUCCESS"; 
            }        
        } catch(SQLException e) {
            System.out.println("Error: " + e);
        }
        return "Invalid user credentials";
    }
}
