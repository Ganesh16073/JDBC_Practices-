package com.org.jdbcdriver;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.Properties;

public class JdbcConnectionWithProperties {

	public static void main(String[] args) throws Exception {
		InputStream inf=new FileInputStream("D:\\JDBC practics\\JdbcDriverFirstProject\\src\\com\\org\\jdbcdriver\\Tests.properties");
		Properties p=new Properties();
		p.load(inf);
		System.out.println("File Loaded Successfully...............");
		String driverClassName=p.getProperty("driver");
		String urlName=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		
		Class.forName(driverClassName);
		Connection con=DriverManager.getConnection(urlName,username,password);
		if(con!=null)
		{
			System.out.println("Estsblished Connection");
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
	}
}
