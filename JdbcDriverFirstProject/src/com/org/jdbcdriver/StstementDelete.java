package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class StstementDelete {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	public static void main(String[] args)throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver(); //create object of driver type4
		DriverManager.registerDriver(d); //register driver 
		Connection con=DriverManager.getConnection(url,userName,password); // create connection
		if(con!=null)
		{
			System.out.println("Connection Esablished");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the email to delete which is in Database");
			String email=sc.nextLine();
			Statement sta=con.createStatement();
			int val=sta.executeUpdate("delete from register where email='"+email+"'"); // SQl Query
			if(val>0) //if query executed then it will give output 1 or greater than 1 if not then 0
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
