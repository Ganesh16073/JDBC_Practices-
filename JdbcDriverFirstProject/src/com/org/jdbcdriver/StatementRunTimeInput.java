package com.org.jdbcdriver;
import java.sql.*;
import java.util.*;
public class StatementRunTimeInput {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	public static void main(String[] args)throws SQLException{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con= DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Connection Established");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Name, Email, Contact");
			String name=sc.nextLine();
			String email=sc.nextLine();
			String contact=sc.nextLine();
			
			Statement sta=con.createStatement();
			int val=sta.executeUpdate("insert into register values('"+name+"','"+email+"','"+contact+"')");//insert using user data
			if(val>0)
			{
				System.out.println("Quere Updated");
			}
			else
			{
				System.out.println("Query not executed");
			}
		}
		else
		{
			System.out.println("Connection not Established");
		}
		
		
		
	}
}
