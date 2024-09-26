package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
import java.io.*;
public class BatchesApp {
	
	public static void main(String[] args)throws Exception {
		InputStream inf= new FileInputStream("D:\\\\JDBC practics\\\\JdbcDriverFirstProject\\\\src\\\\com\\\\org\\\\jdbcdriver\\\\Tests.properties");
		Properties p=new Properties();
		p.load(inf);
		String driverClassName=p.getProperty("driver");
		String urlName=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		
		Class.forName(driverClassName);
		Connection con=DriverManager.getConnection(urlName,username,password);
		if(con!=null)
		{
			System.out.println("Estsblished Connection");
			
			PreparedStatement sta=con.prepareStatement("insert into register values(?,?,?,?)");
			sta.setString(1,"ganesh");
			sta.setString(2,"ganesh@gamil.com");
			sta.setString(3, "8451400");
			sta.setString(4, "vita");
			sta.addBatch();
			
			sta.setString(1,"ganesh");
			sta.setString(2,"ganesh@gamil.com");
			sta.setString(3, "8451400");
			sta.setString(4, "vita");
			sta.addBatch();
			
			sta.setString(1,"ganesh");
			sta.setString(2,"ganesh@gamil.com");
			sta.setString(3, "8451400");
			sta.setString(4, "vita");
			sta.addBatch();
			
			int val[]=sta.executeBatch();
			System.out.println("Number of entries is "+val.length);
			
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
	}

}
