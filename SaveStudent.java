package com.cisco.demo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveservlet")
public class SaveStudent extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	    resp.setContentType("text/html"); 
		PrintWriter pw = resp.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		
		Student s = new Student();
		
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		s.setCourse(course);
		 
		int num = StudentDao.save(s);
		if(num>0)
		{
			pw.print("<h1>successfully saved</h1>");
			req.getRequestDispatcher("index1.html").include(req, resp);
		}
		else 
		{
		    pw.print("sry unable tro save");	
		}
	     pw.close();
	
	}
      
}
