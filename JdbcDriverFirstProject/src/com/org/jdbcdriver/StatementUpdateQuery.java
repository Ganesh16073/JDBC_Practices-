package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class StatementUpdateQuery {
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
			Statement sta=con.createStatement();
			ResultSet rs=sta.executeQuery("select *from register"); // ResultSet Store all data
			while(rs.next()) // .next() is used to chect up to last element
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
	}
}