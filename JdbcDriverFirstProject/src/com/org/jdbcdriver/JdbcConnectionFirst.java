package com.org.jdbcdriver;
import java.sql.*;

public class JdbcConnectionFirst {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver Created");
		Connection con= DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Connected to MySql");
		}
		else
		{
			System.out.println("Not Connected");
		}
		

	}

}
