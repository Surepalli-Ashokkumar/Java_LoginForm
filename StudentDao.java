package com.cisco.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao 
{
    
    public static int save(Student s) 
    {
    	int num=0;
    	Connection con= StudentConfig.getConnection();
    	try 
    	{
			PreparedStatement ps=con.prepareStatement("insert into studentreg(name,password,email,course) values(?,?,?,?)");
			ps.setString(1,s.getName());
			ps.setString(2,s.getPassword());
			ps.setString(3,s.getEmail());
			ps.setString(4,s.getCourse());
			
			num = ps.executeUpdate();
			con.close();
			
		} 
    	catch (SQLException e) 
    	{
			
			e.printStackTrace();
		}
		return num;
    }
    
    public static int update(Student s)
    {
		
    	int num=0;
    	Connection con= StudentConfig.getConnection();
    	try 
    	{
			PreparedStatement ps=con.prepareStatement("update studentreg set name=?,password=?,email=?,course=? where id=?");
			ps.setString(1,s.getName());
			ps.setString(2,s.getPassword());
			ps.setString(3,s.getEmail());
			ps.setString(4,s.getCourse());
			ps.setInt(5, s.getId());
			
			num = ps.executeUpdate();	
			con.close();
		} 
    	catch (SQLException e) 
    	{
			
			e.printStackTrace();
		}
		return num;
    	
    }
    
    public static int delete(int id)
    {
    	int num=0;
    	Connection con = StudentConfig.getConnection();
    	try 
    	{
    		PreparedStatement ps = con.prepareStatement("delete from studentreg where id=?");
    		ps.setInt(1,id);
    		
    		num = ps.executeUpdate();
    		con.close();
    	}
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
    	return num;
    }
    
    public static Student getStudentById(int id)
    {
    	Student s = new Student();
    	Connection con = StudentConfig.getConnection();
    	try 
    	{
			PreparedStatement ps = con.prepareStatement("select * from studentreg where id=?");
			ps.setInt(1, id);
			
		    ResultSet rs = ps.executeQuery();
		    
		    if(rs.next())
		    {
		    	s.setId(rs.getInt(1));
		    	s.setName(rs.getString(2));
		    	s.setPassword(rs.getString(3));
		    	s.setEmail(rs.getString(4));
		    	s.setCourse(rs.getString(5));
		    }
		  con.close();
		} 
    	catch (Exception e) 
    	{
		    e.printStackTrace();
		}
		return s;
    }
    
    public static List<Student> getAllStudents()
    {
    	List<Student> ls = new ArrayList<Student>();
    	Connection con = StudentConfig.getConnection();

    	try 
    	{
			PreparedStatement ps = con.prepareStatement("select * from studentreg");
			ResultSet rs = ps.executeQuery();
			
		    while(rs.next())
		    {    
		    	Student s = new Student();
		    	
		    	s.setId(rs.getInt(1));
		    	s.setName(rs.getString(2));
		    	s.setPassword(rs.getString(3));
		    	s.setEmail(rs.getString(4));
		    	s.setCourse(rs.getString(5));
		    	
		    	ls.add(s);
		    }
		    con.close();
		} 
    	catch (Exception e) 
    	{
		    e.printStackTrace();
		}
    	return ls;
    }
}
