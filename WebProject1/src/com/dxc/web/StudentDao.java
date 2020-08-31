package com.dxc.web;

import java.sql.*;
import java.util.*;

public class StudentDao {
	  public static Connection getConnection()
	  {  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","root");  
	        }
	        catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	  
	  public int Save(int id, String name, String email, String date){  
		    int status=0;
	          
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("insert into student(id,name,email,date) values (?,?,?,?)");   
	            ps.setInt(1, id);
	            ps.setString(2, name);
	            ps.setString(3, email);
	            ps.setString(4, date);
	            status=ps.executeUpdate();  
	            con.close();  
   	        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
	          
	        
	    public static List<Student> getAllStudents(){  
	        List<Student> list=new ArrayList<Student>();  
	          
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from student");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	Student e=new Student();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(3));  
	                e.setDate(rs.getString(4));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }    
	    public static int update(Student e)
	    {  
	        int status=0;  
	        try
	        {  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update student set name=?,email=?,date=? where id=?");  
	            ps.setString(1,e.getName()); 
	            ps.setString(2,e.getEmail());  
	            ps.setString(3,e.getDate());  
	            ps.setInt(4,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        }  
	         return status;  
	    }
		public static void delete(int id)
		{
			// TODO Auto-generated method stub
			int status=0;  
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from student where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
       	        }catch(Exception e){e.printStackTrace();}  
	          
	        return;  
	    } 
		   public static Student getStudentById(int id){  
			   Student e=new Student();  
		          
		        try{  
		            Connection con=StudentDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from student where id=?");  
		            ps.setInt(1,id);  
		            ResultSet rs=ps.executeQuery();  
		            if(rs.next()){  
		                e.setId(rs.getInt(1));  
		                e.setName(rs.getString(2)); 
		                e.setEmail(rs.getString(3));  
		                e.setDate(rs.getString(4));  
		            }  
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return e;  
		    }

}

	   
