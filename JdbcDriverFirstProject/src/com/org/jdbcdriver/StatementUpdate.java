package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class StatementUpdate {
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
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter name where to update data in database");
			String name=sc.nextLine();
			System.out.println("Enter email to update");
			String email=sc.nextLine();
			System.out.println("Enter Contact to update");
			String contact=sc.nextLine();
			Statement sta=con.createStatement();
			sc.close();// close Scanner Class
			int val=sta.executeUpdate("update register set email='"+email+"',contact='"+contact+"' where name='"+name+"' ");
			if(val>0)
			{
				System.out.println("Query Exectued");
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
