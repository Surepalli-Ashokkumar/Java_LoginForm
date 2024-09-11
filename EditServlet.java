package com.cisco.demo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		 pw.println("<h1>Update Employee</h1>");
		 
		 String sid = req.getParameter("id");
		 int id = Integer.parseInt(sid);
		 
		 Student s = StudentDao.getStudentById(id);
		 
		    pw.print("<form action='EditServlet2' method='post'>");  
	        pw.print("<table>");  
	        pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+s.getId()+"'/></td></tr>");  
	        pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+s.getName()+"'/></td></tr>");  
	        pw.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+s.getPassword()+"'/> </td></tr>");  
	        pw.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+s.getEmail()+"'/></td></tr>");  
	        pw.print("<tr><td>Country:</td><td>");  
	        pw.print("<select name='course' style='width:150px'>");  
	        pw.print("<option>Btech</option>");  
	        pw.print("<option>Degree</option>");  
	        pw.print("<option>Mbbs</option>");  
	        pw.print("<option>Mtech</option>");  
	        pw.print("</select>");  
	        pw.print("</td></tr>");  
	        pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        pw.print("</table>");  
	        pw.print("</form>");  
	          
	        pw.close();  
		 
	}
     
}
