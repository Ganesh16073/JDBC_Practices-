package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class AlterCallableStatement {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	
	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Connection Established");
			
		}
		else
		{
			System.out.println("Connection Not Established");
		}
	}

}
