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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class LoginDao {
 
public String authenticateUser(LoginBean bean)
{
    String userName = bean.getName();
    String password = bean.getPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;

    String userNameDB = "";
    String passwordDB = "";

    try
    {
        con = DBConnection.createConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT username,password FROM user");

        while(resultSet.next())
        {
            userNameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");

            if(userName.equals(userNameDB) && password.equals(passwordDB))
            { 
                return "true";
            }
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return "Invalid";
    }
}
