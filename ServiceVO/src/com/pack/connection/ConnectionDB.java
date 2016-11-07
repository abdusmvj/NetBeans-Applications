/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pack.connection;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class ConnectionDB 
{
     public Connection connDatabase() throws SQLException
    {
                    Connection conn=null;
                    
      try
      {
           //this registers the java program to connect with SQL Server
           //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          Class.forName("com.mysql.jdbc.Driver");
           
            //this connects to a particular database within a particular instance
       
        //String dbURL = "jdbc:sqlserver://Islam-PC:1433;databaseName=BankingDB";
       String dbURL ="jdbc:mysql://localhost:3306/javaeedb";
        String user = "root";
        String pass = "abdus";
        //creating the connection
        conn = DriverManager.getConnection(dbURL,user,pass);
         if(conn!=null)
                {
                   //conn.open() 
                   out.println("Connetion ESTABLISED SUCESSFULLY"+"<br>");
                }
           else
           {
               out.println("Connetion Not found"+"<br>");
           }
          
     }
        catch(ClassNotFoundException cnfex)
        {
            out.println(cnfex.toString());
        }
         catch(SQLException ex)
         {
             out.println(ex.toString());
         }
         
        return conn;
     
    }

   public static void main(String args[]) throws SQLException
    {
      ConnectionDB dbcon=new ConnectionDB();
      dbcon.connDatabase();
    }
}
