package com.dxc.web;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String email=request.getParameter("email");  
        String date=request.getParameter("date");  
          
        Student e=new Student(); 
        e.setId(id);
        e.setName(name);  
        e.setEmail(email);  
        e.setDate(date);  
          
        /*int status=StudentDao.Save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            response.sendRedirect("ViewServlet");
            }else{  
            out.println("Sorry! Register first");  
        }  */
          
        out.close();  
    } 
}
