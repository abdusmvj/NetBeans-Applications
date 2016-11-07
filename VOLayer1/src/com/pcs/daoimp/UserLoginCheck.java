/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.daoimp;

import com.pcs.bean.RegisterVOBean;
import com.pcs.dbmodel.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class UserLoginCheck 
{
    //public void checkValidUser( String eml, String pw)  we can pass to argument using this method
    public boolean checkValidUser(String un1, String pw1) throws SQLException
    {
            Connection conn=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            boolean status=true;
            
            try
       {
            DBConnection dbcon=new DBConnection();
             //creating object of db connection class that will have in package com.pcs.dbmodel
            conn = dbcon.databaseConnMe();
            System.out.println("Connection ok..........to database ...");
             //RegisterVOBean vobean=new RegisterVOBean();  //creating object of regidtervobean class
             //LoginBean lb=new LoginBean();
             //System.out.println("kkkkk get:"+vobean.setUsername1());
            //System.out.println("kkkkk get:"+vobean.getUsername1());
            
            String strQuery="select * from  register_tb where  username=? and password=?";
            ps = conn.prepareStatement(strQuery);
                
               // ps.setString(3, vobean.getEmail1());
            
                ps.setString(1,un1);
                ps.setString(2,pw1);
                rs=ps.executeQuery();
                status=rs.next();
                //while(rs.next())
                //{
                    //System.out.println("I get value from db111111111 :"+rs.getString("username"));
                    //vobean.setUsername1(rs.getString("username"));
                    //vobean.setPassword1(rs.getString("password"));
                    //return status;
                    
                //}
                //status=rs.next();
                 System.out.println("I get value from db111111111 :"+rs.getString("username"));
                
               
             
       }
            
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
