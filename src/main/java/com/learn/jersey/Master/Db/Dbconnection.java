package com.learn.jersey.Master.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

	public Connection start() 
	{
		Connection con=null;
		try {
		
			 Class.forName("comr");//load the driver class from jar files
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy?user=root&password=");  //create connection
		}
		 catch (Exception e) {
	System.out.println(e);
		}
		
		
		if(con!=null) 
		System.out.println("Connection created= " +con);
		
		else if(con==null)
			
		System.out.println("Connection lost please Reconnect");

		return con;	
		
	}
	
	
}