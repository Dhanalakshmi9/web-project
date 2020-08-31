package com.dxc.web;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet3")  
public class SaveServlet3 extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException { 
    	StudentDao student = new StudentDao();
    	  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
          out.println("<h1>Save Student</h1>"); 
         
          String sid=request.getParameter("id");  
          int id=Integer.parseInt(sid);  
          String name=request.getParameter("name");  
          String email=request.getParameter("email");  
          String date=request.getParameter("date");  
            
           
            int status=student.Save(id,name,email,date);
            if(status==1)
            {
            	out.println("success");
            }
            else
            {
            	out.println("failed");
            }
            
          out.close();  
          
          
    }  
 
}
