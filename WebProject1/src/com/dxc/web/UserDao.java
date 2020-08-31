package com.dxc.web;

import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDao 	
{
   static Connection currentCon = null;
   static ResultSet rs = null;  
	

   public static class ConnectionManager {

       static Connection con;
      static String url;
            
      public static Connection getConnection()
      {
        
         try
         {
            String url = "jdbc:mysql://localhost:3306/web"; 
           

            Class.forName("com.mysql.jdbc.Driver");
            
            try
            {            	
               con = DriverManager.getConnection(url,"root","root"); 
                 
            }
            
            catch (SQLException ex)
            {
               ex.printStackTrace();
            }
         }

         catch(ClassNotFoundException e)
         {
            System.out.println(e);
         }

      return con;
}
   }
		
	     
		public static UserBean login(UserBean user)
		{
			// TODO Auto-generated method stub
			
		         //preparing some objects for connection 
		         Statement stmt = null;    
			
		         String username = user.getName();    
		         String password = user.getPassword();   
			    
		         String searchQuery =
		               "select * from users where username='"
		                        + username
		                        + "' AND password='"
		                        + password
		                        + "'";
			    
		    
		      System.out.println("Your user name is " + username);          
		      System.out.println("Your password is " + password);
		      System.out.println("Query: "+searchQuery);
			    
		      try 
		      {
		         //connect to DB 
		         currentCon = ConnectionManager.getConnection();
		         stmt=currentCon.createStatement();
		         rs = stmt.executeQuery(searchQuery);	        
		         boolean more = rs.next();
			       
		         // if user does not exist set the isValid variable to false
		         if (!more) 
		         {
		            System.out.println("Sorry, you are not a registered user! Please sign up first");
		            user.setValid(false);
		         } 
			        
		         //if user exists set the isValid variable to true
		         else if (more) 
		         {
		           
			     	
		            System.out.println("Welcome " + username);
		        
		            user.setValid(true);
		         }
		      } 

		      catch (Exception ex) 
		      {
		         System.out.println("Log In failed: An Exception has occurred! " + ex);
		      } 
			    
		      //some exception handling
		      finally 
		      {
		         if (rs != null)	{
		            try {
		               rs.close();
		            } catch (Exception e) {}
		               rs = null;
		            }
			
		         if (stmt != null) {
		            try {
		               stmt.close();
		            } catch (Exception e) {}
		               stmt = null;
		            }
			
		         if (currentCon != null) {
		            try {
		               currentCon.close();
		            } catch (Exception e) {
		            }

		            currentCon = null;
		         }
		      }
		      

		return user;
			
		      }
		  public static int Register(String username,String password){  
			    int status=0;
		          
		        try{  
		            Connection con=StudentDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("insert into users(username,password) values (?,?) ");  
		            ps.setString(1, username);
		            ps.setString(2, password);
		            status=ps.executeUpdate();  
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return status;  
		    }  
			public static int login1(String name)
			{
				// TODO Auto-generated method stub
				int status=0;  
		        try{  
		            Connection con=StudentDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from users where username=?");  
		            ps.setString(1, name);  
		            ResultSet rs=ps.executeQuery();
		            while(rs.next())
		            {
		            	status++;
		            }
		              
		            con.close();  
	       	        }catch(Exception e){e.printStackTrace();}  
		          
		        return status;  
		    } 
		
}
