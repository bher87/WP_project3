/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author TuanPhan
 */
 
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
 
public class DBConnection {
 
public static Connection createConnection()
{
    Connection con = null;
    String url = "jdbc:mysql://localhost:8889/tphan36";
    String username = "root";
    String password = "root";

    try
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        con = DriverManager.getConnection(url, username, password);
        }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    return con;
    }
}