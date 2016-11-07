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
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class RegisterInsert 
{
     public void insertRegisterDB(RegisterVOBean vobean) throws SQLException  //object is passing using that class name vo bean
    {
        // boolean status=false;
         Connection conn=null;
         PreparedStatement ps=null;
         //ResultSet rs=null;
          
         try
       {
            DBConnection dbcon=new DBConnection();
             //creating object of db connection class that will have in package com.pcs.dbmodel
            conn = dbcon.databaseConnMe();
            System.out.println("Connection ok..........to database ...");
      
            String strQuery="Insert into register_tb (firstname,lastname,email,username,password,department,gender,city,mobileno) values(?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(strQuery);
            ps.setString(1, vobean.getFirstname1());
            ps.setString(2, vobean.getLastname1());
            ps.setString(3, vobean.getEmail1());
            ps.setString(4, vobean.getUsername1());
            ps.setString(5, vobean.getPassword1());
            ps.setString(6, vobean.getDepartment1());
            ps.setString(7, vobean.getGender1());
            ps.setString(8, vobean.getCity1());
            //ps.setString(9, String.valueOf(vobean.getMobileno1()));  //converting to integer to string
            ps.setString(9, vobean.getMobileno1());
            ps.executeUpdate();
            System.out.println("kkkkk get:"+vobean.getFirstname1());
            System.out.println("mob no get:"+vobean.getMobileno1());
            System.out.println("Record Inseted Succesfully to DB");  
            //System.out.println("hiiiiiiiiiiiii"+fname);
       }
         
         
       catch( SQLException sqe)
               {
                   System.out.println(sqe.toString());
               }
           finally
                {
                     conn.close();
                     ps.close();
                } 
       
     // return status;
    }
}
