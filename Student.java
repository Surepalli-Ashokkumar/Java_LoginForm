package com.cisco.demo2;

public class Student 
{
     private int id;
     private String name;
     private String password;
     private String email;
     private String course;
     
	/*public Student(int id, String name, String password, String email, String course) 
	{
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.course = course;
	}*/

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getCourse() 
	{
		return course;
	}

	public void setCourse(String course) 
	{
		this.course = course;
	}    
}
