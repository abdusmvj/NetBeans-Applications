/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pack.daoImp;

import com.pack.connection.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DisplayFetchRecord 
{
    public static  boolean fetchRecord() throws SQLException
       {
           boolean status=false;
           Connection conn=null;
           PreparedStatement ps=null;
           ResultSet rs=null;
           ResultSetMetaData rsmd=null;
           ConnectionDB dbcon=new ConnectionDB();
           try
           {
               dbcon.connDatabase();
               System.out.println("Connection ok..........to database ...");
               String strQuery="select * from servletlogin";
               ps = conn.prepareStatement(strQuery);
               ps.setString(1, strQuery);
           }
           //status=true;
           catch( SQLException sqe)
               {
                   System.out.println(sqe.toString());
               }
           finally
                {
                     conn.close();
                     ps.close();
                     rs.close();
                } 
        
           return status;
       }
           
}
