package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class PreparedAltertTable {
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
			PreparedStatement sta=con.prepareStatement("alter table register add column Address varchar(200)");// add New COlumn
			int val=sta.executeUpdate();
			if(val>0)
			{
				System.out.println("Query Executed");
			}
			else
			{
				System.out.println("Query Not Executed");
			}
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
	}

}
