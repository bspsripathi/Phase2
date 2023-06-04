package com.javatpoint;
import jakarta.servlet.*;

import java.sql.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		
		Connection con=null;
	try{
		ResultSet rs;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "8143303511@Sri");
		
		PreparedStatement ps1=con.prepareStatement("Select * from QUIZCONTACT");
		
		rs=ps1.executeQuery();
		if(rs.next())
		{System.out.println("your table name already exist");}
		else 
		{System.out.println("else if part table does not exist new table has created");
	
		
		
		PreparedStatement ps=con.prepareStatement("CREATE TABLE QUIZCONTACT (NAME VARCHAR(4000),EMAIL VARCHAR(4000),PHONE VARCHAR(4000),MESSAGE VARCHAR(4000))");
		ps.executeUpdate();
		PreparedStatement ps4=con.prepareStatement("CREATE TABLE QUIZINFO (SUBJECT VARCHAR(4000),QUIZNAME VARCHAR(4000))");
		ps4.executeUpdate();		
		
	
		PreparedStatement  ps5=con.prepareStatement("CREATE TABLE  QUIZQ(NAME VARCHAR(4000),EMAIL VARCHAR(4000),PHONE VARCHAR(4000),QUESTION VARCHAR(4000))");
		ps5.executeUpdate();
		
		
		ps5= con.prepareStatement("CREATE TABLE  QUIZQUES(QUESTION VARCHAR(4000),OPTION1 VARCHAR(4000),OPTION2 VARCHAR(4000),OPTION3 VARCHAR(4000),OPTION4 VARCHAR(4000),ANSWER VARCHAR(4000),QUIZNAME VARCHAR(4000),QID VARCHAR(4000),DESCRIPTION VARCHAR(4000),CONSTRAINT QUIZQUES_PK PRIMARY KEY (QID) ENABLE)");
		ps5.executeUpdate();
		
		
		ps5= con.prepareStatement("CREATE TABLE  QUIZREGISTER (USERNAME VARCHAR(4000),USERPASS VARCHAR(4000),CATEGORY VARCHAR(4000),EMAIL VARCHAR(4000))");
		ps5.executeUpdate();
		Statement stmt=con.createStatement();
		
		}	
	}
		
	    catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    }
	    
	    public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");
		
	}
}
