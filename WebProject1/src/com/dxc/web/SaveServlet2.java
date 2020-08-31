package com.dxc.web;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet2")  
public class SaveServlet2 extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException { 
    	UserDao user = new UserDao();
    	  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
          out.println("<h1>Save USER</h1>");  
          String sid=request.getParameter("name");  
          String pwd=request.getParameter("password");  
           
            int status=user.Register(sid, pwd);
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

