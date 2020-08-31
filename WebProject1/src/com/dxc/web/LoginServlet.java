package com.dxc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* Servlet implementation class LoginServlet
*/
@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, java.io.IOException {

try
{	    

UserBean user = new UserBean();
String name=request.getParameter("name");
int status = UserDao.login1(name);
	    
if (status==1)
{

HttpSession session = request.getSession(true);	    
session.setAttribute("currentSessionUser",user); 
response.sendRedirect("ViewServlet"); //logged-in page      		
}

else

System.out.println("login fails");//error page 
} 


catch (Throwable theException) 	    
{
System.out.println(theException); 
}
}
}


